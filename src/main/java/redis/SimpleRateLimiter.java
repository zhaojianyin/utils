package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.io.IOException;

/**
 * 限定 60s 内操作不得超过 100w 次这样的参数，它是不适合做这样的限流 的，因为会消耗大量的存储空间。
 *
 * @author zhaojianyin
 * @create 2019-12-03 下午8:12
 */
public class SimpleRateLimiter {

	private Jedis jedis;

	public SimpleRateLimiter(Jedis jedis) {
		this.jedis = jedis;
	}

	public boolean isActionAllowed(String userId, String actionKey, int period, int maxCount) {
		String key = String.format("hist:%s:%s", userId, actionKey);
		long nowTs = System.currentTimeMillis();
		Pipeline pipe = jedis.pipelined();
		pipe.multi();
		pipe.zadd(key, nowTs, "" + nowTs);
		pipe.zremrangeByScore(key, 0, nowTs - period * 1000);
		Response<Long> count = pipe.zcard(key);
		pipe.expire(key, period + 1);
		pipe.exec();
		try {
			pipe.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return count.get() <= maxCount;
	}

	public static void main(String[] args) {
		Jedis jedis = new Jedis();
		SimpleRateLimiter limiter = new SimpleRateLimiter(jedis);
		for (int i = 0; i < 20; i++) {
			System.out.println(limiter.isActionAllowed("laoqian", "reply", 60, 5));
		}
	}
}
