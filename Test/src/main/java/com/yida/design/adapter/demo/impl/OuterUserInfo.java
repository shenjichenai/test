package com.yida.design.adapter.demo.impl;

import java.util.Map;

import com.yida.design.adapter.demo.IUserInfo;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月31日 下午4:42:36
 ***********************
 */
public class OuterUserInfo extends OuterUser implements IUserInfo {

	@SuppressWarnings({ "rawtypes" })
	private Map baseInfo = super.getUserBaseInfo(); // 员工的基本信息
	@SuppressWarnings({ "rawtypes" })
	private Map homeInfo = super.getUserHomeInfo(); // 员工的家庭信息
	@SuppressWarnings({ "rawtypes" })
	private Map officeInfo = super.getUserOfficeInfo(); // 工作信息

	/*
	 * 家庭地址
	 */
	@Override
	public String getHomeAddress() {
		String homeAddress = (String) this.homeInfo.get("homeAddress");
		System.out.println(homeAddress);
		return homeAddress;
	}

	/*
	 * 家庭电话号码
	 */
	@Override
	public String getHomeTelNumber() {
		String homeTelNumber = (String) this.homeInfo.get("homeTelNumber");
		System.out.println(homeTelNumber);
		return homeTelNumber;
	}

	/*
	 * 职位信息
	 */
	@Override
	public String getJobPosition() {
		String jobPosition = (String) this.officeInfo.get("jobPosition");
		System.out.println(jobPosition);
		return jobPosition;
	}

	/*
	 * 手机号码
	 */
	@Override
	public String getMobileNumber() {
		String mobileNumber = (String) this.baseInfo.get("mobileNumber");
		System.out.println(mobileNumber);
		return mobileNumber;
	}

	/*
	 * 办公电话
	 */
	@Override
	public String getOfficeTelNumber() {
		String officeTelNumber = (String) this.officeInfo.get("officeTelNumber");
		System.out.println(officeTelNumber);
		return officeTelNumber;
	}

	/*
	 * 员工的名称
	 */
	@Override
	public String getUserName() {
		String userName = (String) this.baseInfo.get("userName");
		System.out.println(userName);
		return userName;
	}

}
