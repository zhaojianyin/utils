package it.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @项目名称：util
 * @类名称：SerailTree @类描述： 二叉树的序列化和反序列话
 *
 * @author 赵建银
 * @date 2018年1月4日
 * @time 下午7:02:35
 * @version 1.0
 */
public class SerailTree {
	/**
	 * 将二叉树序列化成字符串，先序遍历
	 * 
	 * @param head
	 *            头节点
	 * @return 序列化后的字符串
	 */
	public static String serailByPre(Node head) {
		if (head == null) {
			return "#!";
		}
		String res = head.value + "!";
		res += serailByPre(head.left);
		res += serailByPre(head.right);
		return res;
	}

	/**
	 * 将字符串序列化成二叉树，及二叉树的反序化
	 * 
	 * @param res
	 *            传入的字符串
	 * @return 转换的二叉树结点
	 */
	public Node reconByPreString(String res) {
		// 将字符串分割
		String[] split = res.split("!");
		Queue<String> queue = new LinkedList<String>();
		for (int i = 0; i < split.length; i++) {
			queue.offer(split[i]);
		}
		return reconPreOrder(queue);
	}

	/**
	 * @param queue
	 * @return 节点树
	 */
	public Node reconPreOrder(Queue<String> queue) {
		String value = queue.poll();
		if (value.equals("#")) {
			return null;
		}
		Node head = new Node(Integer.parseInt(value));// 头节点
		head.left = reconPreOrder(queue);
		head.right = reconPreOrder(queue);
		return head;
	}

}

class Node {
	Node left;
	Node right;
	int value;

	public Node(int data) {
		value = data;
	}
}
