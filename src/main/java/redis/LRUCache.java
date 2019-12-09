package redis;

import java.util.concurrent.ConcurrentHashMap;

/**
 * LRU 缓存算法
 * <p>
 * 使用双向链表+map，map是为了提供效率
 *
 * @author zhaojianyin
 * @create 2019-12-09 下午2:23
 */
public class LRUCache {

	private ConcurrentHashMap<String, DLinkedNode>
			cache = new ConcurrentHashMap<>();
	private int count;
	private int capacity;
	private DLinkedNode head, tail;

	LRUCache(int capacity) {
		this.count = 0;
		this.capacity = capacity;

		tail = new DLinkedNode();
		head = new DLinkedNode();

		tail.next = null;
		tail.pre = head;

		head.next = tail;
		head.pre = null;
	}


	/**
	 * 存在？移到顶上：返回null
	 *
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		DLinkedNode node = cache.get(key);
		if (node == null) {
			return null;
		}

		//移到顶上
		this.moveToHead(node);

		return node.value;
	}

	private void moveToHead(DLinkedNode node) {
		this.removeNode(node);
		this.addNode(node);
	}

	public void set(String key, Object value) {
		DLinkedNode node = cache.get(key);
		if (node == null) {
			node = new DLinkedNode();
			node.key = key;
			node.value = value;

			//放到队列

			this.addNode(node);


			if (count > capacity) {

				popTail();
			}
		} else {
			//有这个节点，将其移到顶部，并且更新内容
			node.value = value;
			moveToHead(node);
		}
	}

	private void popTail() {
		DLinkedNode node = tail.pre;
		this.removeNode(node);
	}

	private void removeNode(DLinkedNode node) {
		this.cache.remove(node.key);
		--count;
		DLinkedNode next = node.next;
		DLinkedNode pre = node.pre;
		next.pre = pre;
		pre.next = next;

	}

	private void addNode(DLinkedNode node) {
		++count;
		this.cache.put(node.key, node);

		node.pre = head;
		node.next = head.next;

		head.next.pre = node;
		head.next = node;
	}


	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(3);
		lruCache.set("key1", 7);
		System.out.println(lruCache);
		lruCache.set("key2", 0);
		System.out.println(lruCache);
		lruCache.set("key3", 1);
		System.out.println(lruCache);
		lruCache.set("key4", 2);
		System.out.println(lruCache);
		lruCache.get("key2");
		System.out.println(lruCache);
		lruCache.set("key5", 3);
		System.out.println(lruCache);
		lruCache.get("key2");
		System.out.println(lruCache);
		lruCache.set("key6", 4);

	}

	@Override
	public String toString() {
		return "LRUCache{" +
				"cache=" + cache +
				", count=" + count +
				", capacity=" + capacity +
				'}';
	}
}
