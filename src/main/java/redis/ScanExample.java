package redis;

/**
 * @author zhaojianyin
 * @date 2020-05-08 下午2:23
 */

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import util.JedisUtils;

public class ScanExample {
	public static void main(String[] args) {
		// 添加 10w 条数据
		initData();
		BasicIndexableFieldIdentifier();
	}

	public static void initData() {
		Jedis jedis = JedisUtils.getJedis();
		Pipeline pipe = jedis.pipelined();
		for (int i = 1; i < 100001; i++) {
			pipe.set("user_token_" + i, "id" + i);
		}
		// 执行命令
		pipe.sync();
		System.out.println("数据插入完成");
	}

	public static void BasicIndexableFieldIdentifier() {
		Jedis jedis = JedisUtils.getJedis();
		// 定义 match 和 count 参数
		ScanParams params = new ScanParams();
		params.count(10000);
		params.match("user_token_9999*");
		// 游标
		int cursor = 0;
		while (true) {
			ScanResult<String> res = jedis.scan(cursor, params);
			if (res.getCursor() == 0) {
				// 表示最后一条
				break;
			}
			// 设置游标
			cursor = res.getCursor();
			for (String item : res.getResult()) {
				// 打印查询结果
				System.out.println("查询结果：" + item);
			}
		}
	}
}
