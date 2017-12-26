package it.string;

/**
 * @项目名称：util
 * @类名称：CountString @类描述： 字符串统计字符串
 *
 * @author 赵建银
 * @date 2018年1月10日
 * @time 下午12:56:41
 * @version 1.0
 */
public class CountString {

	/**
	 * @param str
	 *            要进行统计的字符串
	 * @return 返回统计之后的字符串
	 */
	public static String getCountString(String str) {
		if (str == null || str.equals("")) {
			return "";
		}
		String res = "";// 结果字符串
		int count = 1;// 数量
		char[] charArray = str.toCharArray();// 转换为字符数组
		for (int i = 1; i < charArray.length; i++) {
			if (charArray[i] == charArray[i - 1]) {// 和上一个相等数量加1
				count++;
			} else {
				res += charArray[i - 1] + "_" + count + "_";// 不想等则进行统计后的字符串拼接
				count = 1;// 进行下一次统计
			}
		}
		// 到最后全部相同情况进行字符串拼接
		res += charArray[str.length() - 1] + "_" + count + "";
		return res;
	}

	public static char getCharAt(String str, int index) {
		if (str == null || str.equals("")) {
			return 0;
		}
		char[] charArray = str.toCharArray();
		char c = 0;
		int num = 0;
		int sum = 0;
		boolean flag = true;// 字符阶段和统计阶段
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == '_') {
				flag = !flag;
				i++;
			}
			if (flag) {
				sum += num;
				if (sum > index) {
					return c;
				}
				// 字符阶段
				c = charArray[i];
				num = 0;
			} else {
				// 统计阶段
				num = num * 10 + charArray[i]-'0';
			}
		}
		
		return sum+num>index?c:0;
	}

	public static void main(String[] args) {
		String str = "aaa";
		System.out.println(getCountString(str));
		String a = "a_9_t_1000";
		int index = 10;
		System.out.println(getCharAt(a, index));

	}
}
