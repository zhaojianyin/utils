package util.limit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 限流二：漏桶算法
 *
 * @author zhaojianyin
 * @create 2019-09-05 上午11:37
 */
public class LeakyDemo {

	private static long timeStamp = System.currentTimeMillis();

	/**
	 * 桶的容量
	 */
	private static int size = 10;
	/**
	 * 水漏出的速度
	 */
	private static int rate = 3;
	/**
	 * 当前水量(当前累积请求数)
	 */
	private static int water = 0;

	public static boolean grant() {
		long now = System.currentTimeMillis();
		// 先执行漏水，计算剩余水量
		water = Math.max(0, (int) (water - (now - timeStamp) * rate));
		timeStamp = now;
		if ((water + 1) < size) {
			// 尝试加水,并且水还未满
			water += 1;
			System.out.println("water:" + water);
			return true;
		} else {
			System.out.println("namle");
			// 水满，拒绝加水
			return false;
		}
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 50; i++) {
			final int no = i;
			Runnable runnable = () -> {
				if (grant()) {
					System.out.println("执行" + no);
					try {
						Thread.sleep((long) (Math.random() * 1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("水漫了");
				}
			};
			executorService.execute(runnable);
		}
		executorService.shutdown();
	}
}
