package lock.spinlock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * 是指尝试获取锁的线程不会立即阻塞，而是采用循环的方式去尝试获取锁，这样的好处是减少线程
 * 上下文切换的消耗，缺点是循环会消耗CPU
 * 
 * 手写自旋锁
 * @author 王浩
 *
 */
public class SpinLockDemo {
	
	// 原子引用线程
	AtomicReference<Thread> ref = new AtomicReference<Thread>();
	
	public void myLock() {
		Thread thread = Thread.currentThread();
		while (!ref.compareAndSet(null, thread)) {

		}
		System.out.println(thread.getName()+"\t lock");
	}
	
	public void myUnLock() {
		Thread thread = Thread.currentThread();
		ref.compareAndSet(thread, null);
		System.out.println(thread.getName()+"\t Unlock");
	}

	public static void main(String[] args) {
		SpinLockDemo demo = new SpinLockDemo();
		new Thread(() -> {
			demo.myLock();
			try {
				Thread.sleep(5000000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			demo.myUnLock();
		},"a").start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(() -> {
			demo.myLock();
			demo.myUnLock();
		},"b").start();
	}
	
	
}
