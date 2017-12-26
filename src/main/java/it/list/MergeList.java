package it.list;

/**
 * @项目名称：util
 * @类名称：MergeList @类描述： 合并两个有序的链表，返回链表头
 *
 * @author 赵建银
 * @date 2018年1月2日
 * @time 下午7:17:53
 * @version 1.0
 */
public class MergeList {

	public Node megre(Node head1, Node head2) {

		// 如果有一个为空
		if (head1 == null || head2 == null) {
			// 返回不为空的
			return head1 == null ? head2 : head1;
		} else {
			// 都不为空
			Node now = head1.value < head2.value ? head1 : head2;
			// 最小的为要返回的节点
			// 拿到最小值的链表
			// 开始比较
			while (head1 != null && head2 != null) {
				now.next = head1.value < head2.value ? head1 : head2;
			}
			return now;
		}
	}
}
