package it;

/**
 * @author zhaojianyin
 * @create 2019-10-11 上午10:18
 */
public class FinallyTest {

	public static void main(String[] args) {
		Thread t = new Thread(new Daemon());
		t.start();
	}
}


class Daemon implements Runnable {
	@Override
	public void run() {
		int i = 1/0;
		try {
			System.out.println("1");
		} catch (Exception e) {
			System.out.println("2");
		} finally {
//			Thread.currentThread().stop();
			System.out.println("3");
		}
	}
}