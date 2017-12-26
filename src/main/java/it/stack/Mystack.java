package it.stack;

import java.util.Stack;

/**
 * @项目名称：util
 * @类名称：Mystack @类描述： 设计一个有getMin功能的栈，实现返回栈的基本功能之后，在实现返回栈的最小值。 -思路：
 *              使用两个栈，一个栈用来存放当前栈中
 *              的数据，功能类似正常的栈，StackData；第二个栈用于保存每一步的最小值。StackMin
 * @author 赵建银
 * @date 2017年12月26日
 * @time 下午12:49:42
 * @version 1.0
 */
public class Mystack {

	private Stack<Integer> stackData;// 存放当前数据
	private Stack<Integer> stackMin;// 存放最小值

	public Mystack() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}

	/**
	 * 
	 * 将当前数据压入栈中，
	 * 
	 * @param newNum
	 *            当前数据
	 */
	public void push(int newNum) {
		if (this.stackMin.isEmpty()) {// 判断stackMin是否为空
			this.stackMin.push(newNum);// 压入
		} else if (newNum <= this.getMin()) {// 有数据，判断是否小于当前栈顶的值
			this.stackMin.push(newNum);// 小于压入
		}
		this.stackData.push(newNum);
	}

	/**
	 * 数据出栈，与压入规则相同
	 */
	public int pop() {
		if (this.stackData.isEmpty()) {
			throw new RuntimeException("stack is empty!");
		}
		int value = this.stackData.pop();
		if (value <= this.getMin()) {
			this.stackMin.pop();
		}
		return value;
	}

	public int getMin() {
		if (stackMin.isEmpty()) {
			throw new RuntimeException("stack is empty!");
		}
		return stackMin.peek();
	}

}
