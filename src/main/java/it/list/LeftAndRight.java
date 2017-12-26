package it.list;

/**
 * @项目名称：util
 * @类名称：LeftAndRight @类描述：将链表按左右分开，左面一个，右面一个链接
 *
 * @author 赵建银
 * @date 2018年1月25日
 * @time 上午10:32:03
 * @version 1.0
 */
public class LeftAndRight {

	public static void LeftAndRight1(Node head) {
		Node slow = head;
		Node fast = head.next;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node mid = slow.next;
		slow.next = null;
		Node next1, next2;
		while (head.next != null) {
			next2 = mid.next;
			next1 = head.next;

			head.next = mid;
			mid.next = next1;

			head = next1;
			mid = next2;
		}
		if (mid != null) {
			head.next = mid;
		}
	}

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
		LeftAndRight1(node);
		while (node != null) {
			System.out.print(node.value + "->");
			node = node.next;
		}
	}
}
