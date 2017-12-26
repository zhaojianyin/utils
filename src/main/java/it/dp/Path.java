package it.dp;

/**
 * @项目名称：util
 * @类名称：Path @类描述：最短路径
 *
 * @author 赵建银
 * @date 2018年1月11日
 * @time 下午7:45:07
 * @version 1.0
 */
public class Path {

	/**
	 * 时间O(M*N) 空间为O(M*N) 最短路劲
	 * 
	 * @param m
	 *            传入的矩阵
	 * @return
	 */
	public static int minPath(int[][] m) {
		int[][] dp = new int[m.length][m[0].length];// 创建和m同样的dp数组用于记录到当前点的最短路径
		dp[0][0] = m[0][0];// 第一步为起点
		// 先求出[i][0]
		for (int i = 1; i < m.length; i++) {
			dp[i][0] = m[i][0] + m[i - 1][0];
		}
		// 在求[0][j]
		for (int j = 1; j < m.length; j++) {
			dp[0][j] = m[0][j] + m[0][j - 1];
		}
		// 求dp[i][j] 上一步 的最小值 加上当前结点的步数
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
			}
		}
		// 最后的节点就是到最后节点的最小值
		return dp[m.length - 1][m[0].length - 1];
	}

	/**
	 * 空间压缩 时间O(M*N) 空间为O(min（M，N）) 最短路劲
	 * 
	 * @param m
	 *            传入的矩阵
	 * @return
	 */
	public static int minPath2(int[][] m) {
		int more = Math.max(m.length, m[0].length);
		int less = Math.min(m.length, m[0].length);// 行数和类数较小的
		boolean rowmore = m.length > m[0].length ? true : false;// 行数是否大于列数
		int arr[] = new int[less];
		arr[0] = m[0][0];
		// 第一次
		for (int j = 1; j < less; j++) {
			arr[j] = arr[j - 1] + (rowmore ? m[0][j] : m[j][0]);
		}

		for (int j = 1; j < more; j++) {
			arr[0] = arr[0] + (rowmore ? m[j][0] : m[0][j]);
			for (int i = 1; i < less; i++) {
				arr[i] = Math.min(arr[i - 1], arr[i])+(rowmore ? m[j][i]:m[i][j]);
			}
		}
		return arr[less - 1];
	}

	public static void main(String[] args) {
		int[][] m = new int[][] { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
		System.out.println(minPath(m));
		System.out.println(minPath2(m));
	}
}
