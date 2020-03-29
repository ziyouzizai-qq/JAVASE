package lock.readorwrite;

import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行。
 * 但是，如果有一个线程想去写共享资源来，就不应该再有其他线程可以对该资源进行读写
 * 
 * 总结：读读能共存
 * 		 读写不能共存
 * 		 写写不能共存
 * @author 王浩
 *
 */
public class ReadWriteLockDemo {

	public static void main(String[] args) {
		MyCache cache = new MyCache();
		
		for (int i = 0; i < 5; i++) {
			final int tempInt = i;
			new Thread(() -> {
				cache.write(tempInt+"", tempInt+"");
			}, String.valueOf(i)).start();
		}
		
		for (int i = 0; i < 5; i++) {
			final int tempInt = i;
			new Thread(() -> {
				cache.read(tempInt+"");
			}, String.valueOf(i)).start();
		}
	}

}

class MyCache { // 资源类
	
	private volatile HashMap<String, Object> map = new HashMap<>();
	
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	
	public void write(String k, Object v) {
		// 写一个个写
		lock.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"\t 正在写入："+k);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put(k, v);
			System.out.println(Thread.currentThread().getName()+"\t 写入完成："+k);
		} finally {
			lock.writeLock().unlock();
		}
	}
	
	public Object read(String k) {
		// 读一起读
		lock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"\t 正在读取");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Object v = map.get(k);
			System.out.println(Thread.currentThread().getName()+"\t 读取完成");
			return v;
		} finally {
			lock.readLock().unlock();
		}
	}
	
//	public void clear() {
//		map.clear();
//	}
}
