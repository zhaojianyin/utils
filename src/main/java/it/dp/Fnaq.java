package it.dp;

/**
 * @项目名称：util
 * @类名称：Fnaq @类描述：
 *
 * @author 赵建银
 * @date 2018年1月11日
 * @time 下午7:06:57
 * @version 1.0
 */
public class Fnaq {

	/**
	 * 
	 * O（2的N次） 斐波那契数列暴力递归
	 * 
	 * @param n
	 *            第n个数
	 * @return 第n个数的值
	 */
	public static int f1(int n) {
		if (n < 1) {
			return 0;
		} else if (n == 1 || n == 2) {
			return 1;
		} else {
			return f1(n - 2) + f1(n - 1);
		}
	}

	/**
	 * 
	 * O（n） 斐波那契数列列举
	 * 
	 * @param n
	 *            第n个数
	 * @return 第n个数的值
	 */
	public static int f2(int n) {
		if (n < 1) {
			return 0;
		} else if (n == 1 || n == 2) {
			return 1;
		}
		int res = 1;
		int pre = 1;
		int tmp = 0;
		for (int i = 3; i <= n; i++) {
			tmp = res;
			res += pre;
			pre = tmp;
		}
		return res;
	}

	/**
	 * 
	 * O（logn） 斐波那契数列
	 * 
	 * @param n
	 *            第n个数
	 * @return 第n个数的值
	 */
	public static int f3(int n) {
		if (n < 1) {
			return 0;
		} else if (n == 1 || n == 2) {
			return 1;
		}
		int res = 1;
		int pre = 1;
		int tmp = 0;
		for (int i = 3; i <= n; i++) {
			tmp = res;
			res += pre;
			pre = tmp;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(f1(5));
		System.out.println(f2(5));
	}
}
