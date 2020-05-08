package util;

import redis.clients.jedis.Jedis;

/**
 * @author zhaojianyin
 * @date 2020-05-08 下午2:24
 */
public class JedisUtils {

	public static Jedis getJedis(){
		return new Jedis("127.0.0.1");
	}
}
