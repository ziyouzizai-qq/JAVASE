package container.map;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 集合类不安全的问题
 * @author 王浩
 *
 */
public class HashMapNotSafeDemo {

	public static void main(String[] args) {
		Map<String, String> map = new ConcurrentHashMap<>();

		for (int i = 0; i < 30; i++) {
			new Thread(() -> {
				map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0, 8));
				System.out.println(map);
			},String.valueOf(i)).start();
		}
		// java.util.ConcurrentModificationException
		
		/**
		 * 1.故障现象：java.util.ConcurrentModificationException
		 * 
		 * 2.导致原因
		 * 		并发争抢修改导致，
		 * 3.解决方案
		 * 		3.1 
		 * 		3.2 Collections工具包提供同步list
		 * 		3.3 new CopyOnWriteArrayList();
		 * 
		 * 4 优化建议
		 */
	}
}
