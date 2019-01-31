package com.yida.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.impl.cookie.DefaultCookieSpec;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.nutz.lang.Lang;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年12月20日 下午10:33:29
 ***********************
 */
class AnyTrustStrategy implements TrustStrategy {

	@Override
	public boolean isTrusted(java.security.cert.X509Certificate[] chain, String authType)
			throws java.security.cert.CertificateException {
		return true;
	}

}

public class HttpsUtil {
	private static final Logger log = LoggerFactory.getLogger(HttpsUtil.class);

	private static int bufferSize = 1024;

	private static volatile HttpsUtil instance;

	private static volatile CloseableHttpClient client = HttpClients.createDefault();;

	private volatile BasicCookieStore cookieStore;

	public static String defaultEncoding = "utf-8";

	private static List<NameValuePair> paramsConverter(Map<String, String> params) {
		List<NameValuePair> nvps = new LinkedList<NameValuePair>();
		Set<Entry<String, String>> paramsSet = params.entrySet();
		for (Entry<String, String> paramEntry : paramsSet) {
			nvps.add(new BasicNameValuePair(paramEntry.getKey(), paramEntry.getValue()));
		}
		return nvps;
	}

	public static String readStream(InputStream in, String encoding) {
		if (in == null) {
			return null;
		}
		try {
			InputStreamReader inReader = null;
			if (encoding == null) {
				inReader = new InputStreamReader(in, defaultEncoding);
			} else {
				inReader = new InputStreamReader(in, encoding);
			}
			char[] buffer = new char[bufferSize];
			int readLen = 0;
			StringBuffer sb = new StringBuffer();
			while ((readLen = inReader.read(buffer)) != -1) {
				sb.append(buffer, 0, readLen);
			}
			inReader.close();
			return sb.toString();
		} catch (IOException e) {
			log.error("读取返回内容出错", e);
		}
		return null;
	}

	private HttpsUtil() throws Exception {

		SSLContextBuilder builder = new SSLContextBuilder();
		builder.loadTrustMaterial(new AnyTrustStrategy());

		HostnameVerifier hostnameVerifierAllowAll = new HostnameVerifier() {
			@Override
			public boolean verify(String name, SSLSession session) {
				return true;
			}
		};
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build(),
				new String[] { "SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2" }, null, hostnameVerifierAllowAll);

		HttpRequestRetryHandler myRetryHandler = new HttpRequestRetryHandler() {
			public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
				// 重试设置
				if (executionCount >= 5) {
					// Do not retry if over max retry count
					return false;
				}
				if (exception instanceof InterruptedIOException) {
					// Timeout
					return false;
				}
				if (exception instanceof UnknownHostException) {
					// Unknown host
					return false;
				}
				if (exception instanceof ConnectTimeoutException) {
					// Connection refused
					return false;
				}
				if (exception instanceof SSLException) {
					// SSL handshake exception
					return false;
				}
				HttpClientContext clientContext = HttpClientContext.adapt(context);
				HttpRequest request = clientContext.getRequest();
				boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
				if (idempotent) {
					return true;
				}
				return false;
			}
		};
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(120000).setSocketTimeout(120000)// 超时设置
				.build();
		client = HttpClients.custom().setSSLSocketFactory(sslsf).setRetryHandler(myRetryHandler)// 重试设置
				.setDefaultRequestConfig(requestConfig).build();
	}

	public static HttpsUtil getInstance() {
		synchronized (HttpsUtil.class) {
			if (HttpsUtil.instance == null) {
				try {
					instance = new HttpsUtil();
				} catch (Exception e) {
				}
			}
			return instance;
		}
	}

	public InputStream doGet(String url) throws URISyntaxException, ClientProtocolException, IOException {
		HttpResponse response = doGet(url, null, null);
		return response != null ? response.getEntity().getContent() : null;
	}

	public String doGetForString(String url) throws URISyntaxException, ClientProtocolException, IOException {
		return HttpsUtil.readStream(doGet(url), null);
	}

	@SuppressWarnings("static-access")
	public InputStream doGetForStream(String url, Map<String, String> queryParams)
			throws URISyntaxException, ClientProtocolException, IOException {
		HttpResponse response = this.doGet(url, queryParams, null);
		return response != null ? response.getEntity().getContent() : null;
	}

	public String doGetForString(String url, Map<String, String> queryParams)
			throws URISyntaxException, ClientProtocolException, IOException {
		return HttpsUtil.readStream(this.doGetForStream(url, queryParams), null);
	}

	/**
	 * 基本的Get请求
	 * 
	 * @param url         请求url
	 * @param queryParams 请求头的查询参数
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static HttpResponse doGet(String url, Map<String, String> queryParams, Map<String, String> headers)
			throws URISyntaxException, ClientProtocolException, IOException {
		HttpGet gm = new HttpGet();
		URIBuilder builder = new URIBuilder(url);
		// 填入查询参数
		if (queryParams != null && !queryParams.isEmpty()) {
			builder.setParameters(HttpsUtil.paramsConverter(queryParams));
		}
		// 设置header
		if (headers != null && !headers.isEmpty()) {
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				gm.setHeader(key, value);
			}
		}
		gm.setURI(builder.build());
		CloseableHttpResponse execute = client.execute(gm);
		HttpEntity entity = execute.getEntity();
		if (null != entity) {
			String content = EntityUtils.toString(entity);
			System.out.println(content);
		}
		return client.execute(gm);
	}

	public InputStream doPostForStream(String url, Map<String, String> queryParams)
			throws URISyntaxException, ClientProtocolException, IOException {
		HttpResponse response = this.doPost(url, queryParams, null);
		return response != null ? response.getEntity().getContent() : null;
	}

	public String doPostForString(String url, Map<String, String> queryParams)
			throws URISyntaxException, ClientProtocolException, IOException {
		return HttpsUtil.readStream(this.doPostForStream(url, queryParams), null);
	}

	public InputStream doPostForStream(String url, Map<String, String> queryParams, Map<String, String> formParams)
			throws URISyntaxException, ClientProtocolException, IOException {
		HttpResponse response = this.doPost(url, queryParams, formParams);
		return response != null ? response.getEntity().getContent() : null;
	}

	public String doPostRetString(String url, Map<String, String> queryParams, Map<String, String> formParams)
			throws URISyntaxException, ClientProtocolException, IOException {
		return HttpsUtil.readStream(this.doPostForStream(url, queryParams, formParams), null);
	}

	/**
	 * 基本的Post请求
	 * 
	 * @param url         请求url
	 * @param queryParams 请求头的查询参数
	 * @param formParams  post表单的参数
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public HttpResponse doPost(String url, Map<String, String> queryParams, Map<String, String> formParams)
			throws URISyntaxException, ClientProtocolException, IOException {
		HttpPost pm = new HttpPost();
		URIBuilder builder = new URIBuilder(url);
		// 填入查询参数
		if (queryParams != null && !queryParams.isEmpty()) {
			builder.setParameters(HttpsUtil.paramsConverter(queryParams));
		}
		pm.setURI(builder.build());
		// 填入表单参数
		if (formParams != null && !formParams.isEmpty()) {
			pm.setEntity(new UrlEncodedFormEntity(HttpsUtil.paramsConverter(formParams), defaultEncoding));
		}
		return client.execute(pm);
	}

	/**
	 * 多块Post请求
	 * 
	 * @param url         请求url
	 * @param queryParams 请求头的查询参数
	 * @param formParts   post表单的参数,支持字符串-文件(FilePart)和字符串-字符串(StringPart)形式的参数
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 * @throws HttpException
	 * @throws IOException
	 */
	public HttpResponse multipartPost(String url, Map<String, String> queryParams, List<FormBodyPart> formParts)
			throws URISyntaxException, ClientProtocolException, IOException {
		HttpPost pm = new HttpPost();
		URIBuilder builder = new URIBuilder(url);
		// 填入查询参数
		if (queryParams != null && !queryParams.isEmpty()) {
			builder.setParameters(HttpsUtil.paramsConverter(queryParams));
		}
		pm.setURI(builder.build());
		// 填入表单参数
		if (formParts != null && !formParts.isEmpty()) {
			MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
			entityBuilder = entityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			for (FormBodyPart formPart : formParts) {
				entityBuilder = entityBuilder.addPart(formPart.getName(), formPart.getBody());
			}
			pm.setEntity(entityBuilder.build());
		}
		return client.execute(pm);
	}

	/**
	 * 获取当前Http客户端状态中的Cookie
	 * 
	 * @param domain    作用域
	 * @param port      端口 传null 默认80
	 * @param path      Cookie路径 传null 默认"/"
	 * @param useSecure Cookie是否采用安全机制 传null 默认false
	 * @return
	 */
	public Map<String, Cookie> getCookie(String domain, Integer port, String path, Boolean useSecure) {
		if (domain == null) {
			return null;
		}
		if (port == null) {
			port = 80;
		}
		if (path == null) {
			path = "/";
		}
		if (useSecure == null) {
			useSecure = false;
		}
		List<Cookie> cookies = cookieStore.getCookies();
		if (cookies == null || cookies.isEmpty()) {
			return null;
		}

		CookieOrigin origin = new CookieOrigin(domain, port, path, useSecure);
		DefaultCookieSpec cookieSpec = new DefaultCookieSpec(null, false);
		Map<String, Cookie> retVal = new HashMap<String, Cookie>();
		for (Cookie cookie : cookies) {
			if (cookieSpec.match(cookie, origin)) {
				retVal.put(cookie.getName(), cookie);
			}
		}
		return retVal;
	}

	/**
	 * 批量设置Cookie
	 * 
	 * @param outCookies cookie键值对图
	 * @param domain     作用域 不可为空
	 * @param path       路径 传null默认为"/"
	 * @param useSecure  是否使用安全机制 传null 默认为false
	 * @return 是否成功设置cookie
	 */
	public boolean setCookie(Map<String, String> outCookies, String domain, String path, Boolean useSecure) {
		synchronized (cookieStore) {
			if (domain == null) {
				return false;
			}
			if (path == null) {
				path = "/";
			}
			if (useSecure == null) {
				useSecure = false;
			}
			if (outCookies == null || outCookies.isEmpty()) {
				return true;
			}
			Set<Entry<String, String>> set = outCookies.entrySet();
			List<Cookie> cookies = cookieStore.getCookies();
			for (int i = 0; i < cookies.size(); i++) {
				outCookies.put(cookies.get(i).getName(), cookies.get(i).getValue());
			}

			String key = null;
			String value = null;
			for (Entry<String, String> entry : set) {
				key = entry.getKey();
				if (key == null || key.isEmpty() || value == null || value.isEmpty()) {
					throw new IllegalArgumentException("cookies key and value both can not be empty");
				}
				BasicClientCookie cookie = new BasicClientCookie(key, value);
				cookie.setDomain(domain);
				cookie.setPath(path);
				cookie.setSecure(useSecure);
				cookieStore.addCookie(cookie);
			}
			return true;
		}
	}

	/**
	 * 设置单个Cookie
	 * 
	 * @param key       Cookie键
	 * @param value     Cookie值
	 * @param domain    作用域 不可为空
	 * @param path      路径 传null默认为"/"
	 * @param useSecure 是否使用安全机制 传null 默认为false
	 * @return 是否成功设置cookie
	 */
	public boolean setCookie(String key, String value, String domain, String path, Boolean useSecure) {
		Map<String, String> cookies = new HashMap<String, String>();
		cookies.put(key, value);
		return setCookie(cookies, domain, path, useSecure);
	}

	/**
	 * 向指定URL发送POST方法的请求
	 * 
	 * @param url        发送请求的URL
	 * @param jsonString json数据
	 * @return 所代表远程资源的响应结果
	 */
	public String sendJsonDataByPost(String url, String jsonString) {
		return sendStringDataByPost(url, jsonString, "application/json");
	}

	/**
	 * 向指定URL发送POST方法的请求
	 * 
	 * @param url       发送请求的URL
	 * @param xmlString xml数据
	 * @return 所代表远程资源的响应结果
	 */
	public String sendXmlDataByPost(String url, String xmlString) {
		return sendStringDataByPost(url, xmlString, "application/xml");
	}

	/**
	 * 向指定URL发送POST方法的请求
	 * 
	 * @param url         发送请求的URL
	 * @param stringData  字符串数据
	 * @param contentType httpheader的Content-Type参数
	 * @return 所代表远程资源的响应结果
	 */
	private String sendStringDataByPost(String url, String stringData, String contentType) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpPost httppost = new HttpPost(url);

			StringEntity entity = new StringEntity(stringData, "utf-8");// 解决中文乱码问题
			entity.setContentEncoding("UTF-8");
			// 添加参数
			httppost.setEntity(entity);
			// 添加http headers
//			httppost.addHeader("Authorization", getSecretKey());
			httppost.addHeader("Content-Type", contentType);
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				public String handleResponse(final HttpResponse response) throws IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity) : null;
					} else {
						throw new IOException("Unexpected response status: " + status);
					}
				}

			};
			return httpclient.execute(httppost, responseHandler);
		} catch (IOException e) {
			throw Lang.wrapThrow(e);
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
			}
		}
	}

	public static void main(String[] args) {
		try {
			HashMap<String, String> headers = new HashMap<String, String>();
			headers.put("Authorization", "0hMpWS5ZFRPwBC65");
			HttpResponse doGet = doGet("http://192.168.194:9090/plugins/restapi/v1/groups", null, headers);
			String string = doGet.getEntity().toString();
			System.out.println(string);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
