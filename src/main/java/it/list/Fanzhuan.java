package it.list;

/**
 * @项目名称：util
 * @类名称：Fanzhuan @类描述：
 *
 * @author 赵建银
 * @date 2018年1月17日
 * @time 下午6:49:07
 * @version 1.0
 */
public class Fanzhuan {

	public static Node fanzhuanlist(Node head) {
		Node pre = null;
		Node next = null;
		while (head != null) {
			next = head.next;// 拿到下一个节点
			head.next = pre;// 将当前节点next设为上一个节点
			pre = head;// 将上一个节点设为头节点
			head = next;// 遍历下一个节点
		}
		return pre;
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
		Node test = fanzhuanlist(node);
		while (test != null) {
			System.out.println(test.value);
			test = test.next;
		}
	}
}
