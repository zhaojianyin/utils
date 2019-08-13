package it.list;

import java.util.Stack;

/**
 * @项目名称：util
 * @类名称：DelNum @类描述：删除和当前数字相同的节点
 *
 * @author 赵建银
 * @date 2018年1月24日
 * @time 下午6:28:12
 * @version 1.0
 */
public class DelNum {

	public static Node delnode(Node head, int num) {
		Stack<Node> stack = new Stack<Node>();
		while (head != null) {
			if (num != head.value) {
				stack.push(head);
			}
			head = head.next;
		}
		head = null;
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			node.next = head;
			head = stack.pop();
		}
		return head;
	}

	public static Node delnode2(Node head, int num) {

		while (head != null) {// 找到第一个不一样的店
			if (num != head.value) {
				break;
			}
			head = head.next;
		}
		Node cur = head.next;
		Node pre = head;
		while (cur != null) {
			if (cur.value == num) {
				pre.next = cur.next;
			}
			pre = pre.next;
			cur = cur.next;
		}

		return head;
	}

	public static void main(String[] args) {
		Node node = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		node.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		Node test = delnode2(node, 3);
		while (test != null) {
			System.out.print(test.value + "->");
			test = test.next;
		}
	}
}
