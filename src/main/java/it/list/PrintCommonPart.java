package it.list;

/**
 * @项目名称：util
 * @类名称：PrintCommonPart @类描述： 打印两个有序链表的公共部分
 *
 * @author 赵建银
 * @date 2018年1月1日
 * @time 下午8:14:59
 * @version 1.0
 */
public class PrintCommonPart {

	public void PrintCommon(Node head1, Node head2) {
		while (head1 != null || head2 != null) {
			if (head1.value < head2.value) {
				head1 = head1.next;
			} else if (head2.value < head1.value) {
				head2 = head2.next;
			} else if (head1.value == head2.value) {
				System.out.println(head1.value);
				head1 = head1.next;
				head2 = head2.next;
			}

		}
	}
}

class Node {
	int value;
	Node next;

	public Node(int value) {
		this.value = value;
	}
}
