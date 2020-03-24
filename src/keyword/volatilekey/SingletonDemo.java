package keyword.volatilekey;

/**
 * 单侧模式运用demo
 * @author 王浩
 *
 */
public class SingletonDemo {

	private static SingletonDemo instance = null;
	
	private SingletonDemo() {
		System.out.println(Thread.currentThread().getName()+"\t 调用构造方法");
	}
	
	/**
	 * 不能加synchronized，细粒度比较大
	 * DCL(Double Check Lock双端检索机制)
	 * 不一定线程安全，还存在指令重排，详情见设计模式sington
	 */
	public static void getInstance() {
		if (instance == null) {
			synchronized (SingletonDemo.class) {
				if (instance == null) {				
					instance = new SingletonDemo();
				}			
			}
		}
	}
	
	public static void main(String[] args) {
		
		// 多线程
		for (int i = 1; i <= 1000000; i++) {
			new Thread(() -> {
				SingletonDemo.getInstance();
			}, String.valueOf(i)).start();
		}
	}

}
