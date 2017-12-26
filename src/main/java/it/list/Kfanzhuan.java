package it.list;

import java.util.Stack;

/**
 * @项目名称：util
 * @类名称：Kfanzhuan @类描述： 每k个节点逆序
 *
 * @author 赵建银
 * @date 2018年1月24日
 * @time 下午1:17:27
 * @version 1.0
 */
public class Kfanzhuan {

	public static void main(String[] args) {
		Node node = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		node.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		Node sort = fanhzuan(node, 3);
		while (sort != null) {
			System.out.print(sort.value + "->");
			sort = sort.next;
		}
	}

	/**
	 * @param head
	 *            头节点
	 * @param k
	 *            要反转的个数
	 * @return 新的头节点
	 */
	private static Node fanhzuan(Node head, int k) {
		if (k < 2) {
			return head;
		}
		Node cur = head;
		Node newHead = head;
		Node next = null;
		Node left = null;
		Stack<Node> stack = new Stack<Node>();
		while (cur != null) {
			next = cur.next;
			stack.push(cur);
			if (stack.size() == k) {
				left = lianjie(stack, left, next);// 返回这次最右面的节点
				newHead = newHead == head ? cur : newHead;
			}
			cur = next;
		}
		return newHead;
	}

	/**
	 * @param stack
	 *            传入栈
	 * @param left
	 *            左面的节点
	 * @param right
	 *            右面的节点
	 * @return 这次链接的最后一个节点
	 */
	private static Node lianjie(Stack<Node> stack, Node left, Node right) {
		Node cur = stack.pop();
		if (left != null) {
			left.next = cur;
		}
		Node next = null;
		while (!stack.isEmpty()) {
			next = stack.pop();
			cur.next = next;
			cur = next;
		}
		cur.next = right;
		return cur;
	}

	public static Node fanzhuan2(Node head, int k) {
		if (k < 2) {
			return head;
		}
		Node cur = head;
		Node newHead = head;
		Node next = null;
		Node left = null;
		int n = 0;
		while (cur != null) {
			next = cur.next;
			n++;
			if (n == k) {
				
				lianjie2(left, cur, left, next);// 返回这次最右面的节点
				newHead = newHead == head ? cur : newHead;
				n = 0;
			}
			cur = next;
		}
		return newHead;
	}

	public static void lianjie2(Node start, Node end, Node left, Node right) {
		
		Node next = null;
		Node pre = null;
		while (start != end) {
			next = start.next;
			start.next = pre;
			pre = start;
			start = next;
		}
		start.next = right;
	}
}
