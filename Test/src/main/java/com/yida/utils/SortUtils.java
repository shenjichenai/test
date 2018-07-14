package com.yida.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.gson.Gson;

/**
 *********************
 * 排序算法工具类
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年7月12日 下午5:14:02
 ***********************
 */
public class SortUtils {

	public static void main(String[] args) {
		Gson gson = new Gson();
		Random random = new Random();
		int[] array = new int[20];
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100);
		}
		System.out.println(gson.toJson(array));
		mergeSort(array, new int[array.length], 0, array.length - 1);
		System.out.println(gson.toJson(array));
	}

	/**
	 * 直接插入排序 :把新的数据插入到已经排好的数据列中。
	 * 
	 * @param array
	 * @return
	 */
	public static void insertSort(int[] array) {
		int length = array.length;
		int insertNum;
		for (int i = 1; i < length; i++) {
			int j = i - 1;
			insertNum = array[i];
			for (; j >= 0 && array[j] > insertNum; j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = insertNum;
		}
	}

	/**
	 * 希尔排序:对于直接插入排序问题，数据量巨大时。
	 * 
	 * @param array
	 * @return
	 */
	public static void shellSort(int[] array) {
		int length = array.length;
		int d = length / 2;
		int insertNum;
		int j = 0;
		for (; d > 0; d /= 2) {
			for (int i = d; i < length; i++) {
				insertNum = array[i];
				for (j = i - d; j >= 0 && insertNum < array[j]; j -= d) {
					array[j + d] = array[j];
				}
				array[j + d] = insertNum;
			}
		}
	}

	/**
	 * 简单选择排序:常用于取序列中最大最小的几个数时。
	 * 
	 * @param array
	 * @return
	 */
	public static void selectSort(int[] array) {
		int length = array.length;
		for (int i = 0; i < length; i++) {
			int min = array[i];
			int minPosition = i;
			for (int j = i + 1; j < length; j++) {
				if (array[j] < min) {
					min = array[j];
					minPosition = j;
				}
			}
			array[minPosition] = array[i];
			array[i] = min;
		}
	}

	/**
	 * 堆排序:对简单选择排序的优化。
	 * 
	 * @param array
	 */
	public static void heapSort(int[] array) {
		// 将无序堆构造成一个大根堆，大根堆有length/2个父节点
		int length = array.length;
		for (int i = length / 2 - 1; i >= 0; i--) {
			headAdjust(array, i, length);
		}
		// 逐步将每个最大值的根节点与末尾元素交换，并且再调整其为大根堆
		for (int i = length - 1; i > 0; i--) {
			// 将堆顶节点和当前未经排序的子序列的最后一个元素交换位置
			swap(array, 0, i);
			headAdjust(array, 0, i);
		}
	}

	/**
	 * 交换数组中两个位置的元素
	 * 
	 * @param array
	 * @param top
	 * @param last
	 */
	private static void swap(int[] array, int top, int last) {
		int temp = array[top];
		array[top] = array[last];
		array[last] = temp;
	}

	/**
	 * 构建大顶堆
	 * 
	 * @param array
	 * @param i
	 * @param length
	 */
	private static void headAdjust(int[] array, int parent, int length) {
		// 保存当前父节点
		int temp = array[parent];
		// 左子节点
		int leftChild = parent * 2 + 1;
		while (leftChild < length) {
			// 得到较大的子节点
			if (leftChild + 1 < length && array[leftChild] < array[leftChild + 1]) {
				leftChild++;
			}
			if (temp > array[leftChild]) {
				break;
			}
			array[parent] = array[leftChild];
			parent = leftChild;
			leftChild = parent * 2 + 1;
		}
		array[parent] = temp;
	}

	/**
	 * 冒泡排序:一般不用。
	 * 
	 * @param array
	 */
	public static void bubbleSort(int[] array) {
		int length = array.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	/**
	 * 快速排序:要求时间最快时。
	 * 
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void quickSort(int[] array, int left, int right) {
		if (left < right) {
			// 分割数组，找到分割点
			int point = partition(array, left, right);
			// 递归调用，对左子数组进行快速排序
			quickSort(array, left, point - 1);
			// 递归调用，对右子数组进行快速排序
			quickSort(array, point + 1, right);
		}
	}

	/**
	 * 找到分割点
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partition(int[] array, int left, int right) {
		int first = array[left];
		while (left < right) {
			while (left < right && array[right] >= first) {
				right--;
			}
			swap(array, left, right);

			while (left < right && array[left] <= first) {
				left++;
			}
			swap(array, left, right);
		}
		return left;
	}

	/**
	 * 归并排序
	 * 
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void mergeSort(int[] array, int[] tempArray, int head, int rear) {
		if (head < rear) {
			// 取分割位置
			int middle = (head + rear) / 2;
			// 递归划分列表的左序列
			mergeSort(array, tempArray, head, middle);
			// 递归划分列表的右序列
			mergeSort(array, tempArray, middle + 1, rear);
			// 列表的合并操作
			merge(array, tempArray, head, middle + 1, rear);
		}
	}

	/**
	 * 列表的两两合并
	 * 
	 * @param array
	 * @param tempArray
	 * @param head
	 * @param middle
	 * @param rear
	 */
	private static void merge(int[] array, int[] tempArray, int head, int middle, int rear) {
		// 左指针尾
		int headEnd = middle - 1;
		// 右指针头
		int rearStart = middle;
		// 临时列表的下标
		int tempIndex = head;
		// 列表合并后的长度
		int tempLength = rear - head + 1;

		// 先循环两个区间段都没有结束的情况
		while ((headEnd >= head) && (rearStart <= rear)) {
			// 如果发现右序列大，则将此数放入临时列表
			if (array[head] < array[rearStart]) {
				tempArray[tempIndex++] = array[head++];
			} else {
				tempArray[tempIndex++] = array[rearStart++];
			}
		}

		// 判断左序列是否结束
		while (head <= headEnd) {
			tempArray[tempIndex++] = array[head++];
		}

		// 判断右序列是否结束
		while (rearStart <= rear) {
			tempArray[tempIndex++] = array[rearStart++];
		}

		// 交换数据
		for (int i = 0; i < tempLength; i++) {
			array[rear] = tempArray[rear];
			rear--;
		}

	}

	/**
	 * 基数排序:用于大量数，很长的数进行排序时。
	 * 
	 * @param array
	 */
	public static void sort(int[] array) {
		int max = array[0];
		for (int i : array) {
			if (max < i) {
				max = i;
			}
		}
		int time = 0;
		int length = array.length;
		// 判断位数
		while (max > 0) {
			max /= 10;
			time++;
		}
		// 建立10个队列;
		List<List<Integer>> queue = new ArrayList<List<Integer>>();
		for (int i = 0; i < 10; i++) {
			List<Integer> queue1 = new ArrayList<Integer>();
			queue.add(queue1);
		}
		// 建立10个队列;
		for (int i = 0; i < time; i++) {
			for (int j = 0; j < length; j++) {
				int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
				List<Integer> queue2 = queue.get(x);
				queue2.add(array[j]);
				queue.set(x, queue2);
			}
			int count = 0;// 元素计数器;
			// 收集队列元素;
			for (int k = 0; k < 10; k++) {
				while (queue.get(k).size() > 0) {
					List<Integer> queue3 = queue.get(k);
					array[count] = queue3.get(0);
					queue3.remove(0);
					count++;
				}
			}
		}
	}
}
