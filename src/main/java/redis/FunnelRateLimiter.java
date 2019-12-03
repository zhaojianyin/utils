package redis;

import java.util.HashMap;
import java.util.Map;

/**
 * 漏斗的剩余空间就代表着当前行为可以持续进行的数量，漏嘴的流水速率代表着
 * 系统允许该行为的最大频率。
 *
 * @author zhaojianyin
 * @create 2019-12-03 下午8:15
 */
public class FunnelRateLimiter {

	static class Funnel {
		int capacity;
		float leakingRate;
		int leftQuota;
		long leakingTs;

		public Funnel(int capacity, float leakingRate) {
			this.capacity = capacity;
			this.leakingRate = leakingRate;
			this.leftQuota = capacity;
			this.leakingTs = System.currentTimeMillis();
		}

		void makeSpace() {
			long nowTs = System.currentTimeMillis();
			long deltaTs = nowTs - leakingTs;
			int deltaQuota = (int) (deltaTs * leakingRate);
			if (deltaQuota < 0) {
				// 间隔时间太长，整数数字过大溢出
				this.leftQuota = capacity;
				this.leakingTs = nowTs;
				return;
			}
			if (deltaQuota < 1) {
				// 腾出空间太小，最小单位是 1
				return;
			}

			this.leftQuota += deltaQuota;
			this.leakingTs = nowTs;
			if (this.leftQuota > this.capacity) {
				this.leftQuota = this.capacity;
			}
		}

		boolean watering(int quota) {
			makeSpace();
			if (this.leftQuota >= quota) {
				this.leftQuota -= quota;
				return true;
			}
			return false;
		}
	}

	private Map<String, Funnel> funnels = new HashMap<>();

	public boolean isActionAllowed(String userId, String actionKey, int capacity, float leakingRate) {
		String key = String.format("%s:%s", userId, actionKey);
		Funnel funnel = funnels.get(key);
		if (funnel == null) {
			funnel = new Funnel(capacity, leakingRate);
			funnels.put(key, funnel);
		}
		return funnel.watering(1);
		// 需要 1 个 quota }
	}
}
