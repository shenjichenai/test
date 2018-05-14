package com.yida;

/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月10日 下午2:59:50
 ***********************
 */
public class Test {
	public static void main(String[] args) {
		int[] arr = new int[] { 12, 23, 34, 45, 56, 67, 77, 89, 90 };
		System.out.println(search(arr, 12));
		System.out.println(search(arr, 45));
		System.out.println(search(arr, 67));
		System.out.println(search(arr, 89));
		System.out.println(search(arr, 99));
	}

	public static int search(int[] arr, int key) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int middle = (start + end) / 2;
			if (key < arr[middle]) {
				end = middle - 1;
			} else if (key > arr[middle]) {
				start = middle + 1;
			} else {
				return middle;
			}
		}
		return -1;
	}
}
