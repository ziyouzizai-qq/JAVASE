package lock.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS：Compare-And-Swap，这是一条CPU并发原语
 * 它的功能是判断内存某个位置的值是否为预期值，如果是则更改为新的值，这个过程是原子的
 * CAS并发原语体现在JAVA语言中就是sun.misc.Unsafe类中的各个方法。调用UnSafe类中CAS方法，JVM会帮我们
 * 实现出CAS汇编指令。这时一种完全依赖于硬件的功能，通过它实现了原子操作。再次强调，由于CAS是一种系统
 * 原语，原语属于操作系统用语范畴，是由若干条指令组成的，用语完成某个功能的一个过程，并且原语的执行必须是
 * 连续的，在执行过程中不允许被中断，也就是说CAS是一条CPU的原子指令，不会造成所谓的数据不一致问题。
 * 比较并交换
 * @author 王浩
 *
 */
public class CASDemo {

	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(5);
		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		=====》compareAndSet
		// 类似于乐观锁
		System.out.println(atomicInteger.compareAndSet(5, 2020)+"\t current data: "+atomicInteger.get());
		System.out.println(atomicInteger.compareAndSet(5, 1024)+"\t current data: "+atomicInteger.get());
		atomicInteger.getAndIncrement();
		
		/**
		 * CAS的缺点：
		 * 1.底层采用自旋，CPU开销大。
		 * 2.只能对一个共享变量原子操作
		 * 3.ABA问题
		 */
	}
}
