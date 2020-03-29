package lock.count.down;

import java.util.concurrent.CountDownLatch;

/**
 * 计数。给初始值，减
 * @author 王浩
 *
 */
public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException{
		CountDownLatch latch = new CountDownLatch(6);
		
		for (int i = 1; i <= 6; i++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName()+"\t 国，被灭");
				latch.countDown();
			}, CountryEnum.forEach_CountryEnum(i).getName()).start();
		}

		latch.await();
		System.out.println(Thread.currentThread().getName()+"\t 秦国success");
	}

	public static void case1() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(6);
		
		for (int i = 0; i < 6; i++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName()+"\t go");
				latch.countDown();
			}, String.valueOf(i)).start();
		}

		latch.await();
		System.out.println(Thread.currentThread().getName()+"\t last");
	}
}
