package lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁（也叫做递归锁）
 * 
 * 指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码，
 * 在同一个线程在外层方法获取锁的时候，在同一个线程在外层方法获取锁的
 * 时候，在进入内层方法会自动获取锁
 * 
 * 也即是说，线程可以进入任何一个它已经拥有的锁所同步着的代码块
 * 
 * 1.synchronized是一个典型的可重入锁
 * 
 * 2.ReenterLock是一个典型的可重入锁
 * @author 王浩
 *
 */
public class ReenterLockDemo {

	public static void main(String[] args) {
		/**
		 * 8	 invoked sendSMS() t1线程在外层方法获取锁的时候
		 * 8	 invoked sendEmail() t1在进入内层方法会自动获取锁
		 * 9	 invoked sendSMS()
		 * 9	 invoked sendEmail()
		 *
		 */
		Phone phone = new Phone();
		new Thread(() -> {
			try {
				phone.sendSMS();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "t1").start();
		
		new Thread(() -> {
			try {
				phone.sendSMS();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "t2").start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread t3 = new Thread(phone);
		Thread t4 = new Thread(phone);
		t3.start();
		t4.start();
	}
}

class Phone implements Runnable{
	
	public synchronized void sendSMS() throws Exception {
		System.out.println(Thread.currentThread().getId()+"\t invoked sendSMS()");
		sendEmail();
	}
	
	public synchronized void sendEmail() throws Exception {
		System.out.println(Thread.currentThread().getId()+"\t invoked sendEmail()");
	}
	
	// 默认是非公平锁
	Lock lock = new ReentrantLock();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		get();
	}

	private void get() {
		// 加锁几次解锁就要几次
		lock.lock();
//		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+"\t invoked get()");
			set();
		} finally {
//			lock.unlock(); 
			lock.unlock(); 
		}
	}
	
	private void set() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+"\t invoked set()");
		} finally {
			lock.unlock(); 
		}
	}
}
