package com.yida;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年6月6日 下午2:44:03
 ***********************
 */
public class TestVo extends TestPojo {

	private Byte sex;

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public TestVo(Byte sex) {
		super();
		this.sex = sex;
	}

	public TestVo() {
		super();
	}

	@Override
	public String toString() {
		return super.toString() + "TestVo [sex=" + sex + "]";
	}

	public static void main(String[] args) {
		TestVo testVo = new TestVo((byte) 1);
		testVo.setAge(10);
		testVo.setName("test");
		System.out.println(testVo.toString());
	}
}
