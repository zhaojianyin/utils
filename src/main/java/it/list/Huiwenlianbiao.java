package it.list;

import java.util.Stack;

/**
 * @项目名称：util
 * @类名称：Huiwenlianbiao @类描述：
 *
 * @author 赵建银
 * @date 2018年1月18日
 * @time 下午8:06:18
 * @version 1.0
 */
public class Huiwenlianbiao {

	public static boolean isHuiwen1(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Stack<Node> stack = new Stack<>();
		Node node = head;
		while (node != null) {
			stack.push(node);
			node = node.next;
		}
		while (head != null) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;

	}

	public static boolean isHuiwen2(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node cur = head;
		Stack<Node> stack = new Stack<>();
		Node node = head.next;
		while (head.next != null && head.next.next != null) {
			node = node.next;
			head = head.next.next;
		}

		while (node != null) {
			stack.push(node);
			node = node.next;
		}
		while (!stack.isEmpty()) {
			if (cur.value != stack.pop().value) {
				return false;
			}
			cur = cur.next;
		}
		return true;

	}

	public static boolean isHuiwen3(Node head) {
		Node node2 = head;
		Node right = head;
		Node node = head;
		while (node != null && node.next.next != null) {
			right = right.next;
			node = node.next.next;
		}
		node = right.next;
		right.next = null;

		// 将right之后的反转
		while (node != null) {
			node2 = node.next;
			node.next = right;
			right = node;
			node = node2;
		}

		return true;
	}

	public static Node fanhzhuan(Node head) {
		Node next = null;
		Node pre = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;

	}

	public static void main(String[] args) {
		Node node = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(3);
		Node node5 = new Node(2);
		Node node6 = new Node(1);
		node.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		System.out.println(isHuiwen1(node));
		System.out.println(isHuiwen2(node));

		Node fanhzhuan = fanhzhuan(node);
		while (fanhzhuan != null) {
			System.out.println(fanhzhuan.value);
			fanhzhuan = fanhzhuan.next;
		}
	}
}
