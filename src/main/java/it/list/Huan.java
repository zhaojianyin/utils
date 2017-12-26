package it.list;

/**
 * @项目名称：util
 * @类名称：Huan @类描述：判断两个链表是否有交点
 *
 * @author 赵建银
 * @date 2018年1月23日
 * @time 下午8:05:19
 * @version 1.0
 */
public class Huan {

	/**
	 * @param head
	 * @return 获取有环链表的入环节点
	 */
	public static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}

		Node slow = head.next;// 慢指针
		Node fast = head.next.next;// 快指针
		while (slow != fast) {
			if (slow.next == null || fast.next == null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		} // 两个相交
			// 快指针从头开始
		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		} // 和慢指针在次相交，极为入环的第一个节点
		return fast;
	}

	/**
	 * 
	 * 两个链表都没有环
	 * 
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static Node NoLoopNode(Node head1, Node head2) {
		int n = 0;
		Node cur1 = head1;
		Node cur2 = head2;
		while (cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		// 记录1尾节点
		while (cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		// 记录2尾节点
		if (cur1 != cur2) {
			return null;
		}
		cur1 = n > 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		n = Math.abs(n);
		// 长的链表先走n步，之后一起走
		while (n != 0) {
			n--;
			cur1 = cur1.next;
		}
		// 相交的为第一个节点
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

	/**
	 * 两个链表都有环
	 * 
	 * @param head1
	 * @param loop1
	 *            入环节点
	 * @param head2
	 * @param loop2
	 * @return
	 */
	public static Node BothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1 = head1;
		Node cur2 = head2;
		if (loop1 != loop2) {// 入环节点不同
			cur1 = loop1.next;
			cur2 = loop2;
			while (cur1 != loop1) {// 第一个绕环一周
				if (cur1 == cur2) {// 发现第二个
					return loop1;// 返回任意一个
				}
				cur1 = cur1.next;
			}
			// 没有说明各自是一个环，没有焦点
			return null;
		} else {
			// 如环节点相同，在入环之前，相当于无环链表
			int n = 0;
			while (cur1.next != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2.next != loop2) {
				n--;
				cur2 = cur2.next;
			}
			if (cur1 != cur2) {
				return null;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;

		}
	}

	/**
	 * 
	 * 
	 * @param head1
	 * @param head2
	 * @return 两个链表相交的第一个节点
	 */
	public static Node GetNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loopNode = getLoopNode(head1);
		Node loopNode2 = getLoopNode(head2);
		Node res = null;
		if (loopNode != null && loopNode2 != null) {// 都有环
			res = BothLoop(head1, loopNode, head2, loopNode2);
		}
		if (loopNode == null && loopNode2 == null) {// 都没环
			res = NoLoopNode(head1, head2);
		}
		return res;
	}
}
