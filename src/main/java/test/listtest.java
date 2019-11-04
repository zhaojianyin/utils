package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhaojianyin
 * @create 2019-11-04 下午3:59
 */
public class listtest {

	public static void main(String[] args) {
		int[] datas = {1, 2, 3, 4};
		List list = Arrays.asList(datas);
		//1
		System.out.println("list的大小：" + list.size());


		Integer[] datas2 = {1, 2, 3, 4};
		List list2 = Arrays.asList(datas2);
		//4
		System.out.println("list的大小：" + list2.size());


		Integer[] datas3 = {1,2,3,4};
		List list3 = Arrays.asList(datas3);
		System.out.println("list为"+list3);
		//阿里规约，java.lang.UnsupportedOperationException
		list3.add(5);
		System.out.println("添加新元素后的list为"+list3.size());

		List<String > lists = new ArrayList<String>();
		lists.add("AA");
		lists.add("BB");
		lists.add("CC");
		lists.add("DD");
		lists.add("EE");

		List<String> subList = lists.subList(1,3);

		lists.add("DD");
		System.out.println(lists.size());
		System.out.println(subList.size());

	}
}
