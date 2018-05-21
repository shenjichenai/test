package com.yida.hanlp;

import java.util.List;

import com.hankcs.hanlp.HanLP;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月21日 下午5:47:01
 ***********************
 */
public class Test {
	public static void main(String[] args) {
		// 关键字提取
		String content = "程序员(英文Programmer)是从事程序开发、维护的专业人员。一般将程序员分为程序设计人员和程序编码人员，但两者的界限并不非常清楚，特别是在中国。软件从业人员分为初级程序员、高级程序员、系统分析员和项目经理四大类。";
		// 数值5表示提取5个关键词
		List<String> extractKeyword = HanLP.extractKeyword(content, 5);
		for (String string : extractKeyword) {
			System.err.println(string);
		}
	}
}
