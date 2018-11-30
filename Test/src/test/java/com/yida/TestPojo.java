package com.yida;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.joda.time.LocalDate;
import org.joda.time.LocalDate.Property;

import com.google.common.base.Objects;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年6月6日 下午1:37:29
 ***********************
 */
public class TestPojo {

	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "TestPojo [name=" + name + ", age=" + age + "]";
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equal(this, obj);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name, age);
	}

	public void dateTest() {
		LocalDate now = LocalDate.now();
		Property dayOfMonth = now.dayOfMonth();
		System.out.println(dayOfMonth.get());
	}

	public void asListTest() {
		String[] ss = { "aa", "bb" };
		List<String> asList = Arrays.asList(ss);
		System.out.println(asList.get(0));
		// Arrays.asList()-->适配器模式，数据仍然为数组
		ss[0] = "cc";
		System.out.println(asList.get(0));
	}

	@SuppressWarnings({ "unused" })
	public void subListTest() {
		List<String> arrayList = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			arrayList.add(UUID.randomUUID().toString());
		}
		// 强制转化报错
		// List<String> subList = (ArrayList) arrayList.subList(2, 5);

		List<String> subList = arrayList.subList(2, 5);
	}

	public void testHashcodeAndEquals() {
		// 有问题
		TestPojo testPojo = new TestPojo();
		testPojo.setAge(10);
		testPojo.setName("sds");
		TestPojo testPojo2 = new TestPojo();
		testPojo2.setAge(10);
		testPojo2.setName("sds");
		System.out.println(Objects.equal(testPojo, testPojo2));
	}

	public static void main(String[] args) {
		Integer a = 100;
		Integer b = 100;
		System.out.println(a == b);

		Integer c = 1000;
		Integer d = 1000;
		System.out.println(c == d);

		System.out.println(c.equals(d));
	}
}
