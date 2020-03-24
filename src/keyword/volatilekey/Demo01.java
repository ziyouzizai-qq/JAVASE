package keyword.volatilekey;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile：
 * 1.保证可见性：每一个线程jvm都会开辟一个工作内存，访问主内存中的变量需要复制一份到本地，本地修改后再写回
 * 	 主内存，这就会存在线程安全。volatile修饰的变量一旦变量改变，其他线程就会重新读取一份在本地。
 * 2.不保证原子性：
 * 		不可分割，完整，即某个线程正在做某个业务操作时，中间不可以被插入或切割，需要整体完整，要么同时成功，
 * 	 要么同时失败。
 * 	 为什么？
 * 		底层指令
 * 	 解决synchronized
 * 3.禁止指令重排
 * 
 * 1.验证volatile的可见性
 * 	1.1 假如int number = 0；number变量之前根本没有添加volatile关键字修饰
 * @author 王浩
 *
 */
public class Demo01 {

	public static void main(String[] args) { // 主线程
		MyData myData = new MyData();
		for (int i = 1; i<=20; i++) {
			new Thread(() -> {
				for (int j = 0; j < 1000; j++) {
					myData.addPlus();
					myData.addAtomic();
				}
			}, String.valueOf(i)).start();
		}
		
		while (Thread.activeCount() > 2) {
			Thread.yield();
		}
		System.out.println(Thread.currentThread().getName()+"finally number value:"+myData.number);
		System.out.println(Thread.currentThread().getName()+"finally atomicInteger value:"+myData.atomicInteger);
	}
	
	// volatile可以保证可见性，及时通知其他线程，主物理内存的值已经被修改了。
	private static void seeOKByVolatile() {
		MyData myData = new MyData();
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName()+"\t come in");
			// 暂停一会线程
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (Exception e) {
				e.printStackTrace();
			}
			myData.addTo60();
			System.out.println(Thread.currentThread().getName()+"\t update number value:"+myData.number);
		}, "a").start();
		
		while (myData.number == 0) {
			// main线程就一直在这里等待循环，直到number不为0
		}
		System.out.println(Thread.currentThread().getName()+"\t mission is over");
	}
}

class MyData {
	volatile int number = 0;
	
	public void addTo60() {
		number = 60;
	}
	
	/**
	 * synchronized
	 */
	public void addPlus(){
		number++;
	}
	
	AtomicInteger atomicInteger = new AtomicInteger();
	
	/**
	 * synchronized
	 */
	public void addAtomic(){
		atomicInteger.getAndIncrement();
	}
}