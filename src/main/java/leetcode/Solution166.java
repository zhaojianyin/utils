package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 * <p>
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojianyin
 * @create 2019-08-30 下午1:12
 */
public class Solution166 {


	public static void main(String[] args) {
		System.out.println(fractionToDecimal(-50,8));
//		System.out.println(fractionToDecimal(1,2));
	}

	public static String fractionToDecimal(int numerator, int denominator) {
		//除数是0直接返回
		if (numerator == 0){
			return "0";
		}
		StringBuilder stringBuilder = new StringBuilder();
		//有一个是负数加负号
		if (numerator < 0 ^ denominator < 0) {
			stringBuilder.append("-");
		}
		//转为正数求余数
		long dividend = Math.abs(Long.valueOf(numerator));
		long divisor = Math.abs(Long.valueOf(denominator));
		//整数位
		stringBuilder.append(dividend/divisor);

		Map<Long, Integer> map = new HashMap<>();
		//余数
		long facva = dividend % divisor;
		//加点
		if (facva != 0){
			stringBuilder.append(".");
		}
		//判断循环小数
		while (facva != 0) {
			//存在循环，加括号
			if (map.containsKey(facva)) {
				stringBuilder.insert(map.get(facva), "(");
				stringBuilder.append(")");
				break;
			}
			//不存在，把余数放到map
			map.put(facva, stringBuilder.length());
			//余数成10
			facva *= 10;
			//把下一个结果加进去
			stringBuilder.append(facva / divisor);
			//再求余数
			facva%= denominator;
		}
		return stringBuilder.toString();
	}

}
