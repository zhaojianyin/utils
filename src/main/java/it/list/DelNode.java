package it.list;

import java.util.HashSet;
import java.util.Set;


/**
 * @项目名称：util
 * @类名称：DelNode @类描述：删除重复出现的节点
 *
 * @author 赵建银
 * @date 2018年1月25日
 * @time 上午9:41:58
 * @version 1.0
 */
public class DelNode {

	/**
	 * 
	 * 删除重复出现的节点
	 * 
	 * @param head
	 * @return
	 */
	public static void DelNode1(Node head) {
		if (head == null) {
			return;
		}
		Set<Integer> set = new HashSet<Integer>();
		set.add(head.value);
		Node pre = head;
		Node cur = head.next;
		while (cur != null) {
			if (set.contains(cur.value)) {
				pre.next = cur.next;
			} else {
				set.add(cur.value);
				pre = pre.next;
			}
			cur = cur.next;
		}
	}

	public static void DelNode2(Node head) {
		if (head == null) {
			return;
		}
		Node cur = head;
		while (cur != null) {
			Node pre = cur;
			Node next = cur.next;
			while (next != null) {
				if (cur.value == next.value) {
					pre.next = next.next;
				}else {
					pre = pre.next;
				}
				next = next.next;
			}
			cur = cur.next;
		}
	}

	public static void main(String[] args) {
		Node node = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(5);
		Node node7 = new Node(5);
		node.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		DelNode2(node);
		while (node != null) {
			System.out.print(node.value + "->");
			node = node.next;
		}
	}

}
