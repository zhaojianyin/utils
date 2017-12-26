package it.string;

/** 
* @项目名称：util   
* @类名称：Deformation   
* @类描述：  互为旋转词，字母种类和个数相同
*
* @author 赵建银
* @date 2018年1月9日 
* @time 下午7:56:54 
* @version 1.0 
*/
public class Deformation {
	
	
	public static boolean isDeformation(String a,String b) {
		char[] arr = a.toCharArray();
		char[] brr = b.toCharArray();
		int[] map = new int[256];
		for (int i = 0; i < arr.length; i++) {
			map[arr[i]]++;
		}
		for (int i = 0; i < brr.length; i++) {
			if (map[brr[i]]-- == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String a = "113";
		String b = "113";
		System.out.println(isDeformation(a, b));
	}
}
