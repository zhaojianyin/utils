package util.limit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *
 * 限流一：
 * Java 并发库的Semaphore 可以很轻松完成信号量控制，
 * Semaphore可以控制某个资源可被同时访问的个数，
 * 通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。单个信号量的Semaphore对象可以实现互斥锁的功能，
 * 并且可以是由一个线程获得了“锁”，再由另一个线程释放“锁”，这可应用于死锁恢复的一些场合。
 * 下面的Demo中申明了一个只有5个许可的Semaphore，而有20个线程要访问这个资源，通过acquire()和release()获取和释放访问许可：
 *
 * @author zhaojianyin
 * @create 2019-09-05 上午11:18
 */

public class SemaphoreLimit {

	public static void main(String[] args) {


		final Semaphore semaphore = new Semaphore(5);

		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < 20; i++) {
			final int no = i;
			Runnable runnable = () -> {
				try {
//					从信号量中获取一个允许机会
					semaphore.acquire();
					System.out.println("acquire" + no);
					Thread.sleep((long) (Math.random() * 1000));
					semaphore.release();
					System.out.println("可用数量：" + semaphore.availablePermits());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
			executorService.execute(runnable);
		}
		executorService.shutdown();
	}
}
