package it.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @项目名称：util
 * @类名称：RandNode @类描述：随机指针复制
 *
 * @author 赵建银
 * @date 2018年1月22日
 * @time 下午6:32:51
 * @version 1.0
 */
public class RandNode {

	public static RNode copyList(RNode rNode) {
		RNode cur = rNode;
		Map<RNode, RNode> map = new HashMap<RNode, RNode>();
		while (cur != null) {
			map.put(cur, new RNode(cur.value));
			cur = cur.next;
		}
		cur = rNode;
		while (cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).rand = map.get(cur.rand);
			cur = cur.next;
		}
		return map.get(rNode);

	}

	public static RNode copyList2(RNode rNode) {
		RNode head = rNode;
		RNode next = null;
		// 复制链接节点
		while (head != null) {
			next = head.next;
			head.next = new RNode(head.value);
			head.next.next = next;
			head = next;
		}
		head = rNode;
		RNode node = null;
		// 复制rand指针
		while (head != null) {
			next = head.next.next;
			node = head.next;
			node.rand = head.rand != null ? head.rand.next : null;
			head = next;
		}

		// 拆分
		head = rNode;
		RNode res = rNode.next;
		while (head != null) {
			next = head.next.next;
			node = head.next;
			node.next = next;
			node.next = next != null ? next.next : null;
			head = next;
		}
		return res;

	}

	public static void main(String[] args) {
		RNode rNode = new RNode(1);
		RNode rNode2 = new RNode(2);
		RNode rNode3 = new RNode(3);
		RNode rNode4 = new RNode(4);
		RNode rNode5 = new RNode(5);
		rNode.next = rNode2;
		rNode.rand = rNode3;
		rNode2.next = rNode3;
		rNode2.rand = rNode3;
		rNode3.next = rNode4;
		rNode3.rand = rNode;
		rNode4.next = rNode5;
		rNode4.rand = rNode2;
		rNode5.next = null;
		rNode5.rand = rNode3;
		RNode copyList = copyList2(rNode);

		while (copyList != null) {
			System.out.print(copyList.value + "->" + copyList.rand.value + "||");
			copyList = copyList.next;
		}
	}

}

class RNode {

	RNode next;
	RNode rand;
	int value;

	public RNode(int value) {
		this.value = value;
	}
}
