package it.list;

/**
 * @项目名称：util
 * @类名称：SelectionSort @类描述： 单链表的选择排序
 *
 * @author 赵建银
 * @date 2018年1月26日
 * @time 上午9:28:45
 * @version 1.0
 */
public class SelectionSort {
	public static Node sort(Node node) {
		Node head = getSmallNode(node);
		Node small = head;
		while (node != null) {
			head.next = getSmallNode(node.next);
			head = head.next;
		}
		return small;
	}

	/**
	 * 获取链表的最小值
	 * 
	 * @param node
	 * @return
	 */
	private static Node getSmallNode(Node head) {
		Node cur = head;
		Node node2 = head;//将第一个节点设置为最小值
		while (cur!= null) {//遍历链表
			if (cur.value <= node2.value) {//当前的数组有比最小值小的数
				node2 = cur.next;
				cur.next = cur.next.next;
			}
			cur = cur.next;
		}
		return node2;
	}

	public static void main(String[] args) {
		Node node = new Node(6);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(7);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		node.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		Node sort = sort(node);
		while (sort != null) {
			System.out.print(sort.value + "->");
			sort = sort.next;
		}
	}
}
