package it.stack;

import java.util.Stack;

/**
 * @项目名称：util
 * @类名称：TwoStacksQueue @类描述：
 *                     用两个栈实现一个队列，支持队列的基本操作（add，poll，peek）。思路：把两个栈的顺序反过来，一个作为压入栈，一个作为弹出栈。全部压入压入栈之后，在讲压入栈的数据压入弹出站。
 *                     注意：第一：压入弹出栈时，弹出栈必须为空。第二：一次性全部压入弹出栈。
 * @author 赵建银
 * @date 2017年12月26日
 * @time 下午3:11:08
 * @version 1.0
 */
public class TwoStacksQueue {

	public Stack<Integer> stackPush;// 存放压入数据
	public Stack<Integer> stackPop;// 存放和push中顺序相反的数据

	public TwoStacksQueue() {
		this.stackPop = new Stack<Integer>();
		this.stackPush = new Stack<Integer>();
	}

	public void add(int pushInt) {
		this.stackPush.push(pushInt);
	}

	public int poll() {
		if (stackPush.isEmpty() && stackPop.isEmpty()) {
			throw new RuntimeException("queue is empty!");
		} else if (stackPop.isEmpty()) {
			while (!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}

	public int peek() {
		if (stackPush.isEmpty() && stackPop.isEmpty()) {
			throw new RuntimeException("queue is empty!");
		} else if (stackPop.isEmpty()) {
			while (!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.peek();
	}

}
