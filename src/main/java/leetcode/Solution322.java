package leetcode;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojianyin
 * @create 2019-08-21 下午1:36
 */
public class Solution322 {

	public static int coinChange(int[] coins, int amount) {
		if (amount == 0){
			return 0;
		}
		int res = Integer.MAX_VALUE;
		for (int coin: coins) {

			if (amount - coin < 0){
				//当前金额不符合,下一个
				continue;
			}
			//子问题不符合
			int coinChange = coinChange(coins, amount - coin);
			if (coinChange < 0){
				continue;
			}
			res = Math.min(res, coinChange + 1);
		}
		return res == Integer.MAX_VALUE ? -1 : res;

	}

	public static void main(String[] args) {
		int[] coins = new int[]{12, 2, 5, 1};
		System.out.println(coinChange(coins, 11));
	}
}
