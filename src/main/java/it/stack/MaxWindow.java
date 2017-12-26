package it.stack;

import java.util.LinkedList;

/**
 * @项目名称：util
 * @类名称：MaxWindow 
 * @类描述：获取窗口的最大值，整形数组【4，3，5，4，3，3，6，7】
 *                ，窗口大小为3，向右滑动，找到每次滑动的窗口的最大值 
 * @思路：
 *                使用双端队列，存放数组下标。队列为空将数组下标放入队列，过程结束。不为空：判断队列尾下标对应数组>当前数据放入。下标对应数组<当前数据放入
 *                ，弹出继续放入。弹出规则：队列对头下标等于i-w过期弹出即可
 * @author 赵建银
 * @date 2018年1月8日
 * @time 下午4:30:40
 * @version 1.0
 */
public class MaxWindow {

	/**
	 * 获取窗口最大值
	 * 
	 * @param arr
	 *            整型数组
	 * @param w
	 *            大小为w的窗口
	 * @return 每次滑动窗口的最大值
	 */
	public static int[] getMaxWindow(int[] arr, int w) {
		int[] res = new int[arr.length - w + 1];// 返回的窗口集
		LinkedList<Integer> qmax = new LinkedList<Integer>();// 双端队列
		int index = 0;
		for (int i = 0; i < arr.length; i++) {// 循环遍历数组
			while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {// 队尾下标的数值小于当前数组的值
				qmax.pollLast();// 将对尾出队
			}
			qmax.addLast(i);// 小于队尾或者队列为空加入队尾
			if (qmax.peekFirst() == i - w) {// 判断过期
				qmax.pollFirst();// 过期出队
			}
			// 当前下标 大于窗口值-1（及存入一条数据） 将返回的数据存入数组中
			if (i >= w - 1) {
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
	}

	/**
	 * 
	 * 主方法进行测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
		int w = 3;
		for (int i = 0; i < arr.length - w + 1; i++) {
			System.out.println(getMaxWindow(arr, w)[i]);
		}

	}

}
