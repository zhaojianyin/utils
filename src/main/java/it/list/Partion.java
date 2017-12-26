package it.list;

/**
 * @项目名称：util
 * @类名称：Partion @类描述：
 *
 * @author 赵建银
 * @date 2018年1月19日
 * @time 下午2:42:03
 * @version 1.0
 */
public class Partion {

	public static Node part(Node head, int x) {
		Node smH = null;
		Node smT = null;
		Node eqH = null;
		Node eqT = null;
		Node biH = null;
		Node biT = null;
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next = null;
			if (head.value < x) {
				if (smH == null) {
					smH = head;
					smT = head;
				} else {
					smT.next = head;
					smT = head;
				}
			}
			if (head.value == x) {
				if (eqH == null) {
					eqH = head;
					eqT = head;
				} else {
					eqT.next = head;
					eqT = head;
				}
			}
			if (head.value > x) {
				if (biH == null) {
					biH = head;
					biT = head;
				} else {
					biT.next = head;
					biT = head;
				}
			}
			head = next;
		}

		if (smT != null) {
			smT.next = eqH;
			eqT = eqT == null ? smT : eqT;
		}
		if (eqT != null) {
			eqT.next = biH;
		}
		return smH != null ? smH : eqH != null ? eqH : biH;
	}

	public static void main(String[] args) {
		Node node = new Node(4);
		Node node2 = new Node(3);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(5);
		node.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		Node test = part(node, 3);
		while (test != null) {
			System.out.print(test.value + "->");
			test = test.next;
		}
		String  s = "AAAAa";
		System.out.println(s.toLowerCase());
//		System.out.println(new StringBuffer("-2147483648").reverse().toString().equals("-2147483648"));
	}
}
