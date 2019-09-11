package util;

/**
 * @author zhaojianyin
 * @create 2019-09-11 下午7:46
 */
public class Singleton
{
	private Singleton(){
		System.out.println("new");
	}

	static {
		System.out.println("This's static code block!");
	}

	private static class SingletonHandler {
		private static Singleton singleton = new Singleton();
		static {
			System.out.println("This's innerClass's static code block");
		}
	}

	public static Singleton getInstance(){
		return SingletonHandler.singleton;
	}

	public static void display(){
		System.out.println("This's display!");
	}
}
