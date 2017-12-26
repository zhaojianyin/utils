package it.list;

/**
 * @项目名称：util
 * @类名称：RemoveNodeList @类描述：删除指定的节点
 *
 * @author 赵建银
 * @date 2018年1月2日
 * @time 下午7:41:10
 * @version 1.0
 */
public class RemoveNodeList {

	public Node removeNode(Node node, int num) {
		while (node != null) {
			if (num == node.value) {
				node = node.next;
			}
		}
		return node;
	}
}
