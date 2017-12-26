package it.list;


/**
 * @项目名称：util
 * @类名称：YueSeFuhuan @类描述：
 *
 * @author 赵建银
 * @date 2018年1月17日
 * @time 下午7:40:54
 * @version 1.0
 */
public class YueSeFuhuan {

	public static Node remove(Node head, int m) {
		if (head.next == head || head == null || m < 1) {
			return head;
		}
		Node last = head;
//		while (last != head) {
//			last = last.next;
//		}

		int len = 0;
		while (head != last) {
			if (++len == m) {
				last.next = head.next;
				len = 0;
			} else {
				last = last.next;
			}
			//head = last.next;
		}
		return head;
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
		node6.next = node;
		Node test = remove(node, 3);
		System.out.println(test.value);
	}
}
