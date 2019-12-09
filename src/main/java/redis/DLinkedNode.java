package redis;

/**
 * @author zhaojianyin
 * @create 2019-12-09 下午2:22
 */
public class DLinkedNode {
	public String key;
	public Object value;
	public DLinkedNode pre;
	public DLinkedNode next;

	@Override
	public String toString() {
		return "DLinkedNode{" +
				"key='" + key + '\'' +
				", value=" + value +
				'}';
	}
}
