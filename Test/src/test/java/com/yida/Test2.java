package com.yida;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.yida.utils.StringUtils;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年7月31日 下午1:37:34
 ***********************
 */
public class Test2 {
	// 字段值占位符：${name}
	protected static final String REGEX_VAR_EXPRESSION = "\\$\\{([a-zA-Z0-9_-]+)\\}";
	protected static final String URL_TEMPLATE = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appid}&redirect_uri=${redirectUri}&response_type=code&scope=snsapi_base&state=123&connect_redirect=1#wechat_redirect";
	protected static final String REGEX_PAGE_EXPRESSION = "(http?|https)://(?!open\\.weixin\\.qq\\.com)([\\s\\S]*?)\\.(html?|jsp)";

	public static void main(String[] args) throws UnsupportedEncodingException {
		String abc = "wewe2wewewewewewewewewewewewewwewer1";
		System.out.println(abc.length());
	}

	public static String replace(String str, Map<String, String> data) {
		Pattern compile = Pattern.compile(REGEX_VAR_EXPRESSION);
		Matcher matcher = compile.matcher(str);
		while (matcher.find()) {
			String name = matcher.group(1).trim();
			str = matcher.replaceFirst(data.get(name));
			matcher = compile.matcher(str);
		}
		return str;
	}

	public static String string2RegExp(String str) {
		if (StringUtils.isEmpty(str)) {
			return str;
		}

		return str.replace("\\", "\\\\").replace("*", "\\*").replace("+", "\\+").replace("|", "\\|").replace("{", "\\{")
				.replace("}", "\\}").replace("(", "\\(").replace(")", "\\)").replace("^", "\\^").replace("$", "\\$")
				.replace("[", "\\[").replace("]", "\\]").replace("?", "\\?").replace(",", "\\,").replace(".", "\\.")
				.replace("&", "\\&");
	}

	public static String encode() {
		String s = "http://${domainName}/wechat-server/page/wx/bridge.html";
		try {
			String encode = URLEncoder.encode(s, "utf-8");
			System.out.println(encode);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
}
