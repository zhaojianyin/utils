package util.limit;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 限流三：令牌桶。
 * @author zhaojianyin
 * @create 2019-09-05 上午11:55
 */
public class RateLimiterTest {
	private static ConcurrentHashMap<String, RateLimiter> resourceRateLimiter = new ConcurrentHashMap<>();

	/**
	 * 资源
	 */
	private static final String resource = "order";

	/**
	 * qps
	 */
	private static final double QPS = 50;

	private static Integer zhixingCount = 0;


	private static Integer xianzhiCount = 0;

	static {
		createResourceLimiter(resource, QPS);
	}


	private static void createResourceLimiter(String resource, double qps) {
		if (resourceRateLimiter.contains(resource)) {
			resourceRateLimiter.get(resource).setRate(qps);
		} else {
			RateLimiter rateLimiter = RateLimiter.create(qps);
			resourceRateLimiter.putIfAbsent(resource, rateLimiter);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new Thread(() -> {
				if (resourceRateLimiter.get(resource).tryAcquire(10, TimeUnit.MILLISECONDS)) {
					zhixingCount++;
				} else {
					xianzhiCount++;
				}
			}).start();
		}
		System.out.println(zhixingCount);
		System.out.println(xianzhiCount);
		System.out.println(zhixingCount + xianzhiCount);
	}
}
