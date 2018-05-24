package com.yida.cutimage;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *********************
 * java截图：swing方式
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月24日 下午3:56:03
 ***********************
 */
public class CutPictureBySwing extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3640477874654542643L;

	public static void main(String[] args) {
		try {
			ConstantsUtils.init();
			CutPictureBySwing main = new CutPictureBySwing();
			main.setVisible(true); // 设置窗体可见
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Container p = getContentPane();
	public static JButton updateButton;
	public static JTextField draftIdTextField;
	public static JLabel infoLable;
	public static JLabel infoLable1;
	public static JLabel infoLable2;
	public static int totalCount;

	public CutPictureBySwing() {
		super();
		this.setTitle("更新截图");
		this.setBounds(200, 200, 350, 260); // setSize(int width,int
											// hight);setBounds(x,y,width,hight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.setLayout(null);

		JLabel label1 = new JLabel("稿件ID");
		label1.setBounds(80, 10, 80, 30);
		p.add(label1);

		draftIdTextField = new JTextField();
		draftIdTextField.setBounds(130, 10, 120, 30);
		p.add(draftIdTextField);

		updateButton = new JButton("更新");
		updateButton.setBounds(80, 48, 180, 30);
		updateButton.addActionListener(this); // 添加鼠标响应事件
		p.add(updateButton);

		infoLable = new JLabel();
		p.add(infoLable);
		infoLable.setBounds(100, 100, 300, 30);

		infoLable1 = new JLabel();
		p.add(infoLable1);
		infoLable1.setBounds(100, 125, 300, 30);
	}

	public void actionPerformed(ActionEvent e) {
		JButton jb = (JButton) e.getSource();
		/*
		 * if (jb == updateButton) { String id = draftIdTextField.getText(); if
		 * (null == id || "".equals(id)) { infoLable.setText("稿件ID不能为空！"); }
		 * else { try { updateShortCutImgURL(id); } catch (Exception ex) {
		 * ex.printStackTrace(); } } }
		 */
		if (jb == updateButton) {
			List<String> urls = new ArrayList<>();
			urls.add("http:\\www.baidu.com");
			List<String> paths = new ArrayList<>();
			paths.add("C:\\Users\\0\\Desktop\\temp\\images\\cut");
			EagleBrowser.main1(urls, paths);
		}
	}

	/**
	 * 更新大数据表中的截图url
	 * 
	 * @param draftPublishedList
	 */
	private void updateShortCutImgURL(String draftId) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "select id,url from tb_draft_published_list where draft_id = " + Integer.parseInt(draftId)
				+ " and short_cut_Img is null and url is not null";
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery(sql);

		// 计算该稿件在大数据表中的个数
		String countSql = "select count(*) as rowCount from tb_draft_published_list where draft_id = "
				+ Integer.parseInt(draftId) + " and short_cut_Img is null and url is not null";
		PreparedStatement stmt2 = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet r2 = stmt2.executeQuery(countSql);
		r2.next();

		List<String> urls = new ArrayList<String>();
		List<String> paths = new ArrayList<String>();
		while (rs.next()) {
			Integer id = Integer.parseInt(rs.getString(1));
			final String url = rs.getString(2);
			final String path = initPath(draftId);
			urls.add(url);
			paths.add(path);
			String updateSql = "update tb_draft_published_list set short_cut_Img = '" + path + "' where id = " + id;
			PreparedStatement stmt1 = null;
			try {
				stmt1 = (PreparedStatement) conn.prepareStatement(updateSql);
				stmt1.executeUpdate(updateSql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		infoLable.setText("共：" + urls.size() + "张");
		EagleBrowser.main1(urls, paths);

	}

	private static String initPath(String draftId) {
		Calendar cal = Calendar.getInstance();
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		String path = year + "/" + month + "/" + draftId + "/";
		String s_save = ConstantsUtils.IMG_WRITE_PATH + ConstantsUtils.FILE_SHORTCUT_URL + "/" + path;
		String randomFile = UUID.randomUUID().toString().concat(".jpg");
		File file = new File(s_save);
		if (!file.exists()) {
			file.mkdirs();
		}
		return s_save.concat(randomFile);
	}
}
