package com.yida.cutimage;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import chrriis.dj.nativeswing.swtimpl.NativeComponent;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserAdapter;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserEvent;

/**
 *********************
 * 主要截图类
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月24日 下午4:09:06
 ***********************
 */
public class EagleBrowser extends JPanel {
	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static Integer pic_nums = 0;// 记录已完成数量

	@SuppressWarnings("unused")
	private String url;

	JWebBrowser webBrowser;

	public EagleBrowser(String url) {
		super(new BorderLayout());
		this.url = url;
		JPanel webBrowserPanel;
		webBrowserPanel = new JPanel(new BorderLayout());
		webBrowser = new JWebBrowser();

		webBrowser.navigate(url);
		webBrowser.setButtonBarVisible(false);
		webBrowser.setMenuBarVisible(false);
		webBrowser.setBarsVisible(false);
		webBrowser.setStatusBarVisible(false);
		webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
		add(webBrowserPanel, BorderLayout.CENTER);
	}

	final static public String LS = System.getProperty("line.separator", "\n");
	// 文件分割符
	final static public String FS = System.getProperty("file.separator", "\\");
	// 以javascript脚本获得网页全屏后大小
	final static StringBuffer JS_DIMENSION;

	static {
		JS_DIMENSION = new StringBuffer();
		JS_DIMENSION.append("var width = 0;").append(LS);
		JS_DIMENSION.append("var height = 0;").append(LS);
		JS_DIMENSION.append("if(document.documentElement) {").append(LS);
		JS_DIMENSION.append("  width = Math.max(width, document.documentElement.scrollWidth);").append(LS);
		JS_DIMENSION.append("  height = Math.max(height, document.documentElement.scrollHeight);").append(LS);
		JS_DIMENSION.append("}").append(LS);
		JS_DIMENSION.append("if(self.innerWidth) {").append(LS);
		JS_DIMENSION.append("  width = Math.max(width, self.innerWidth);").append(LS);
		JS_DIMENSION.append("  height = Math.max(height, self.innerHeight);").append(LS);
		JS_DIMENSION.append("}").append(LS);
		JS_DIMENSION.append("if(document.body.scrollWidth) {").append(LS);
		JS_DIMENSION.append("  width = Math.max(width, document.body.scrollWidth);").append(LS);
		JS_DIMENSION.append("  height = Math.max(height, document.body.scrollHeight);").append(LS);
		JS_DIMENSION.append("}").append(LS);
		JS_DIMENSION.append("return width + ':' + height;");
	}

	public static void main1(final List<String> urls, final List<String> paths) {
		final String title = "";
		// UIUtils.setPreferredLookAndFeel();
		NativeInterface.open();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < urls.size(); i++) {
					JFrame frame = new JFrame(title);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					EagleBrowser eb = new EagleBrowser(urls.get(i));
					Container contentPane = frame.getContentPane();
					contentPane.add(eb, BorderLayout.CENTER);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setLocationByPlatform(true);
					frame.invalidate();
					frame.pack();
					frame.setVisible(false);

					swingWorker(eb.webBrowser, urls.get(i), frame, urls.size(), paths.get(i));
				}
			}
		});
		// NativeInterface.runEventPump();
	}

	@SuppressWarnings("restriction")
	public static void swingWorker(final JWebBrowser webBrowser, final String url, final JFrame frame, final int nums,
			final String path) {

		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5),
				new ThreadPoolExecutor.DiscardOldestPolicy());
		sun.awt.AppContext.getAppContext().put(SwingWorker.class, threadPool);

		SwingWorker<Integer, String> sw = new SwingWorker<Integer, String>() {

			@Override
			protected Integer doInBackground() throws Exception {
				editJpg(webBrowser, url, frame, path);
				publish(url);
				return pic_nums;
			}

			@Override
			// This will be called if you call publish() from doInBackground()
			// Can safely update the GUI here.
			protected void process(List<String> chunks) {
				System.out.println("do in back");
			}

			@Override
			// This is called when the thread finishes.
			// Can safely update GUI here.
			protected void done() {
				System.out.println(new File(path).exists());
			}
		};
		sw.execute();
	}

	public static void editJpg(final JWebBrowser webBrowser, final String url, final JFrame frame, final String path) {
		// 截取图片
		webBrowser.addWebBrowserListener(new WebBrowserAdapter() {
			// 监听加载进度
			@Override
			public void loadingProgressChanged(WebBrowserEvent e) {
				// 当加载完毕时
				if (e.getWebBrowser().getLoadingProgress() == 100) {
					String result = (String) webBrowser.executeJavascriptWithResult(JS_DIMENSION.toString());
					if (null != result && result.indexOf(":") > 0) {
						int index = result.indexOf(":");
						NativeComponent nativeComponent = webBrowser.getNativeComponent();
						Dimension originalSize = nativeComponent.getSize();
						Dimension imageSize = new Dimension(Integer.parseInt(result.substring(0, index)),
								Integer.parseInt(result.substring(index + 1)));
						imageSize.width = Math.max(originalSize.width, imageSize.width + 50);
						imageSize.height = Math.max(originalSize.height, imageSize.height + 50);
						nativeComponent.setSize(imageSize);
						BufferedImage image = new BufferedImage(imageSize.width, imageSize.height,
								BufferedImage.TYPE_INT_RGB);
						nativeComponent.paintComponent(image);
						nativeComponent.setSize(originalSize);

						// 当网页超出目标大小时
						// 此部分为使用缩略图
						AffineTransform tx = new AffineTransform();
						tx.scale(0.8d, 0.9d);
						// int width = image.getWidth(), height =
						// image.getHeight();
						// AffineTransformOp op = new AffineTransformOp(tx,
						// AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
						// //缩小
						// image = op.filter(image, null);

						BufferedImage outputImage = new BufferedImage((int) (imageSize.width * 0.8),
								(int) (imageSize.height * 0.9), BufferedImage.TYPE_INT_RGB);
						Graphics2D gd2 = outputImage.createGraphics();
						gd2.drawImage(image, tx, null);
						gd2.dispose();
						try {
							// 输出图像
							ImageIO.write(image, "jpg", new File(path));
						} catch (IOException ex) {
							ex.printStackTrace();
						}

						// 如果加载完毕之后就关闭掉该监听事件，this为当前new的webBrowserListener
						// Main.infoLable.setText("剩余（" + --Main.totalCount +
						// "）个");
						e.getWebBrowser().removeWebBrowserListener(this);
						// webBrowser.removeWebBrowserListener(this);
						if (null != image) {
							image = null;
							System.gc();
						}
						if (null != outputImage) {
							outputImage = null;
							System.gc();
						}
						if (null != frame) {
							frame.dispose();
						}
						synchronized (pic_nums) {
							pic_nums = pic_nums + 1;
							System.out.println("图片路径：" + path);
							System.out.println("第" + pic_nums + "张图,存在：" + new File(path).exists());
						}
					}
				}
			}
		});

	}
}
