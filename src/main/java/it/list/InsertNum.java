package it.list;

/**
 * @项目名称：util
 * @类名称：InsertNum @类描述：向有序的环形链表有序插入一个节点
 *
 * @author 赵建银
 * @date 2018年1月24日
 * @time 下午5:56:44
 * @version 1.0
 */
public class InsertNum {

	/**
	 * 
	 * @param num
	 * @param head
	 * @return
	 */
	public static Node insert(int num, Node head) {
		Node node = new Node(num);
		if (head == null) {
			return node;
		}
		Node pre = head;
		Node next = head.next;
		while (next != head) {
			if (num >= pre.value && num <= next.value) {
				pre.next = node;
				node.next = next;
				return head;
			}
			next = next.next;
			pre = pre.next;
		} // 不满足则大于最后一个或者小于第一个
		node.next = head;
		pre.next = node;
		return node = num < head.value ? node : head;
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
		node5.next = node;
		Node test = insert(6, node);
		Node e = test;
		while (test.next != e) {
			System.out.print(test.value + "->");
			test = test.next;
		}
		System.out.println(test.value);
	}
}
