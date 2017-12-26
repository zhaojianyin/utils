package it.list;

/**
 * @项目名称：util
 * @类名称：FanzhuanBufen @类描述：反转部分链表，从from 到 to
 *
 * @author 赵建银
 * @date 2018年1月17日
 * @time 下午6:58:08
 * @version 1.0
 */
public class FanzhuanBufen {

	public static Node fanzhuanlist(Node head, int from, int to) {
		Node node = head;
		Node fpre = null;
		Node fpos = null;
		int len = 0;
		while (node != null) {
			len++;
			fpre = from - 1 == len ? node : fpre;
			fpos = to + 1 == len ? node : fpos;
			node = node.next;
		}
		if (from > to || from < 1 || from > len) {
			return head;
		}

		node = fpre == null ? head : fpre.next;// 反转的第一个节点
		Node node2 = node.next;// 反转的节点的下一个节点
		node.next = fpos;
		Node next = null;
		while (node2 != fpos) {
			next = node2.next;
			node2.next = node;
			node = node2;
			node2 = next;
		}
		if (fpre != null) {
			fpre.next = node;
			return head;
		}
		return node;
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
		Node test = fanzhuanlist(node, 2, 4);
		while (test != null) {
			System.out.print(test.value + "->");
			test = test.next;
		}
	}
}
