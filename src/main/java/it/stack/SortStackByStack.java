package it.stack;

import java.util.Stack;

/**
 * @项目名称：util
 * @类名称：SortStackByStackk @类描述： 用一个栈实现对另一个栈的排序
 * 
 * @author 赵建银
 * @date 2017年12月27日
 * @time 下午9:03:44
 * @version 1.0
 */
public class SortStackByStack {

	public static void sortstackByStack(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<Integer>();// 帮助栈
		while (!stack.isEmpty()) {
			int cur = stack.pop();// 出栈值；
			if (help.isEmpty()) {
				help.push(cur);
			} else if (cur <= help.peek()) {
				help.push(cur);
			} else {
				stack.push(help.pop());
			}
		}
		// 全部排序后入栈
		while (!help.isEmpty()) {
			stack.push(help.pop());
		}
	}

}
