package it.string;

/** 
* @项目名称：util   
* @类名称：RemoveKzeros   
* @类描述：  去除连续k个0.
*
* @author 赵建银
* @date 2018年1月9日 
* @time 下午8:31:23 
* @version 1.0 
*/
public class RemoveKzeros {
	
	public static String remove(String a,int k) {
		int count =0;//记录0 的个数
		int start = -1;//记录开始为零的位置
		char[] charArray = a.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i]=='0') {
				start = start == -1?i:start;
				count++;
			}else {//不是0则判断个数是否为k
				if (count == k) {
					while(count-- !=0) {//去掉
						charArray[start++] = 0;
					}
				}//归零
				count = 0;
				start = -1;
			}
		}//以部位0判断，所以最后为0判断一次
		if (count == k) {
			while(count-- !=0) {
				charArray[start++] = 0;
			}
		}
		return String.valueOf(charArray);
	}
	
	public static void main(String[] args) {
		String aString = "0000200";
		int k = 2;
		System.out.println(remove(aString,k));
	}
}
