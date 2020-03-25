package lock.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA问题解决：加版本，AtomicStampedReference
 * @author 王浩
 *
 */
public class ABADemo {
	
	static AtomicReference<Integer> atomicReference = new AtomicReference<Integer>(100);
	// 参数1：对象；参数二：版本号
	static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(100,1);
	
	public static void main(String[] args) {
		// ABA问题
		new Thread(() -> {
			atomicReference.compareAndSet(100, 101);
			atomicReference.compareAndSet(101, 100);
		},"t1").start();
		
		new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(atomicReference.compareAndSet(100, 2020)+"\t"+atomicReference.get());
		},"t2").start();
		
		// 解决ABA问题
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(() -> {
			// 获取版本号
			int ver = atomicStampedReference.getStamp();
			System.out.println(Thread.currentThread().getName()+"\t第一次版本号："+ver);
			atomicStampedReference.compareAndSet(100, 101, ver, ver+1);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		},"t3").start();
		
		new Thread(() -> {
			// 获取版本号
			int ver = atomicStampedReference.getStamp();
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"\t第一次版本号："+ver);
			boolean flag = atomicStampedReference.compareAndSet(100, 2020, ver, ver+1);
			System.out.println("修改成功："+flag + "值为："+atomicStampedReference.getReference());
		},"t4").start();
	}
}
