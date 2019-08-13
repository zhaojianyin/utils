package it.list;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @项目名称：util
 * @类名称：TreeTolist @类描述： 将搜索二叉树转换为双向链表
 *
 * @author 赵建银
 * @date 2018年1月25日
 * @time 下午12:45:34
 * @version 1.0
 */
public class TreeTolist {

	/**
	 * 
	 * 将二叉树转换为list
	 * 
	 * @param head
	 * @return
	 */
	public static TNode TreeTolist1(TNode head) {
		Queue<TNode> queue = new LinkedList<TNode>();
		queue = toqueue(head, queue);
		head = queue.poll();
		TNode pre = null;
		TNode next = null;
		head.left = pre;
		TNode cur = head;
		while (!queue.isEmpty()) {
			next = queue.poll();
			cur.right = next;
			cur.left = pre;
			pre = cur;
			cur = next;
		}
		return head;
	}

	/**
	 * 将二叉树放入queue中
	 * 
	 * @param node
	 * @param queue
	 * @return
	 */
	static Queue<TNode> toqueue(TNode node, Queue<TNode> queue) {
		if (node == null) {
			return null;
		}
		toqueue(node.left, queue);
		queue.offer(node);
		toqueue(node.right, queue);
		return queue;

	}

	/**
	 * 将返回的节右面为null。
	 * @param head
	 * @return
	 */
	public static TNode TreeTolist2(TNode head) {
		if (head == null) {
			return null;
		}
		TNode procces = procces(head);
		TNode right = procces.right;
		procces.right = null;
		return right;
	}

	/**
	 * @param head
	 * @return 当链表的最后一个值，最后一个的下一个为头节点。
	 */
	public static TNode procces(TNode head) {
		if (head==null) {
			return null;
		}
		TNode leftE = null;
		TNode rightE = null;
		TNode leftS = null;
		TNode rightS = null;
		leftE = procces(head.left);
		rightE = procces(head.right);
		leftS = leftE == leftS ? null : leftE.right;
		rightS = rightE == rightS ? null : rightE.right;
		if (leftE != null && rightE != null) {
			leftE.right = head;
			head.left = leftE;
			head.right = rightS;
			rightE.right = leftS;
			return rightE;
		} else if (leftE != null) {
			leftE.right = head;
			head.left = leftE;
			head.right = leftS;
			return head;
		} else if (rightE != null) {
			rightE.right = head;
			head.right = rightS;
			rightS.left = head;
			return rightE;
		} else {
			head.right = head;
			return head;
		}
	}

	public static void main(String[] args) {
		TNode tNode1 = new TNode(1);
		TNode tNode2 = new TNode(2);
		TNode tNode3 = new TNode(3);
		TNode tNode4 = new TNode(4);
		TNode tNode5 = new TNode(5);
		TNode tNode6 = new TNode(6);
		TNode tNode7 = new TNode(7);
		TNode tNode8 = new TNode(8);
		TNode tNode9 = new TNode(9);
		tNode6.left = tNode4;
		tNode6.right = tNode7;
		tNode4.left = tNode2;
		tNode4.right = tNode5;
		tNode2.left = tNode1;
		tNode2.right = tNode3;
		tNode7.right = tNode9;
		tNode9.left = tNode8;
		TNode treeTolist1 = TreeTolist1(tNode6);
//		TNode treeTolist1 = TreeTolist2(tNode6);
		while (treeTolist1 != null) {
			System.out.println(treeTolist1.value);
			treeTolist1 = treeTolist1.right;
		}
	}

}

class TNode {
	TNode left;
	TNode right;
	int value;

	public TNode(int data) {
		value = data;
	}
}
