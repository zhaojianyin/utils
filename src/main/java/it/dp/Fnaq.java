package it.dp;

/**
 * @author 赵建银
 * @version 1.0
 * @项目名称：util
 * @类名称：Fnaq @类描述：
 * @date 2018年1月11日
 * @time 下午7:06:57
 */
public class Fnaq {

	/**
	 * O（2的N次） 斐波那契数列暴力递归
	 *
	 * @param n 第n个数
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
	 * O（n） 斐波那契数列列举
	 *
	 * @param n 第n个数
	 * @return 第n个数的值
	 */
	public static int f2(int n) {
		int a[] = new int[n + 1];
		return helper(a, n);
	}

	private static int helper(int a[], int n) {
		if (n <= 2) {
			return 1;
		} else {
			if (a[n] != 0) {
				return a[n];
			}
			a[n] = helper(a, n - 1) + helper(a, n - 2);
		}
		return a[n];
	}

	public static int f3(int n) {
		int a[] = new int[n + 1];
		a[1] = 1;
		a[2] = 1;
		for (int i =3;i<=n;i++){
			a[i] = a[i-1] + a[i-2];
		}
		return a[n];
	}


	/**
	 * O（logn） 斐波那契数列
	 *
	 * @param n 第n个数
	 * @return 第n个数的值
	 */
	public static int f4(int n) {
		if (n < 1) {
			return 0;
		} else if (n == 1 || n == 2) {
			return 1;
		}
		int prev = 0, curr = 1;
		for (int i = 0; i < n - 1; i++) {
			int sum = prev + curr;
			prev = curr;
			curr = sum;
		}
		return curr;
	}

	public static void main(String[] args) {
		System.out.println(f1(5));
		System.out.println(f2(5));
		System.out.println(f3(5));
		System.out.println(f4(5));
	}
}
