package it.string;

/**
 * @项目名称：util
 * @类名称：ReplaceString @类描述：替换连续出现的字符串 思路： 将连续出现的字符位置设置为空，将为空的地方设置为要替换的字符
 *
 * @author 赵建银
 * @date 2018年1月10日
 * @time 下午7:06:47
 * @version 1.0
 */
public class ReplaceString {

	public static String replce(String str, String from, String to) {
		if (str.equals("") || str == null || from.length() > str.length()) {
			throw new RuntimeException("不符合要求");
		}
		int match = 0;
		char[] charArray = str.toCharArray();
		char[] charArray2 = from.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == charArray2[match++]) {
				if (match == from.length()) {
					// 匹配
					clear(charArray, i, from.length());
					match = 0;
				}
			} else {// 字符不相同
				match = 0;
			}
		}

		// 晴空完成 ，开始拼接
		String res = "";
		String cur = "";
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] != 0) {// 不为空拼接
				cur = cur + String.valueOf(charArray[i]);
			} // 为空则进行一次拼接
			if (charArray[i] == 0 && (i == 0 || charArray[i - 1] != 0)) {
				res = res + cur + to;
				cur = "";
			}
		} // 最后一次拼接
		if (!cur.equals("")) {
			res = res + cur;
		}
		return res;
	}

	/**
	 * @param charArray
	 *            要清空的数组
	 * @param i
	 *            开始的下标
	 * @param j
	 *            清空的数量
	 */
	public static void clear(char[] charArray, int i, int j) {
		while (j-- != 0) {
			charArray[i--] = 0;
		}
	}

	public static void main(String[] args) {
		String string = "12abcabca4";
		String from = "abc";
		String to = "X";
		System.out.println(replce(string, from, to));
	}

}
