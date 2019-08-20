package leetcode;

import java.util.Random;

/**
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 *
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 *
 * 示例:
 *
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 *
 * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
 * solution.pick(3);
 *
 * // pick(1) 应该返回 0。因为只有nums[0]等于1。
 * solution.pick(1);
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-pick-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zhaojianyin
 * @create 2019-08-20 下午6:16
 */
public class Solution398 {
	private int[] nums;

	public Solution398(int[] nums) {
		this.nums = nums;
	}

	public int pick(int target) {
		Random r = new Random();
		int n = 0;
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				//我们的目标对象中选取。
				n++;
				//当前正要读取第n个数据
				if (r.nextInt() % n == 0) {
					//我们以1/n的概率留下该数据
					index = i;
				}
			}
		}
		return index;
	}

	public static void main(String[] args) {
		System.out.println(new Random().nextInt());
		int[] nums = new int[] {1,2,3,3,3};
		Solution398 obj = new Solution398(nums);
		System.out.println(obj.pick(3));
	}
}
