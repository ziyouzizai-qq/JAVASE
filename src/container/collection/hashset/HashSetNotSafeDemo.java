package container.collection.hashset;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合类不安全的问题
 * HashSet:底层用的是HashMap，只用key部分，value是PRESENT常量
 * @author 王浩
 *
 */
public class HashSetNotSafeDemo {

	public static void main(String[] args) {
//		Set<String> arr = Collections.synchronizedSet(new HashSet<>());
		CopyOnWriteArraySet<String> arr = new CopyOnWriteArraySet<String>();
//		arr.add(1);
//		arr.add(2);
//		arr.add(3);
//		arr.add(4);
		for (int i = 0; i < 30; i++) {
			new Thread(() -> {
				arr.add(UUID.randomUUID().toString().substring(0, 8));
				System.out.println(arr);
			},String.valueOf(i)).start();
		}
		// java.util.ConcurrentModificationException
		
		/**
		 * 1.故障现象：java.util.ConcurrentModificationException
		 * 
		 * 2.导致原因
		 * 		并发争抢修改导致，
		 * 3.解决方案
		 * 		3.1 可以用Vector，但是并发效率低，不建议使用
		 * 		3.2 Collections工具包提供同步list
		 * 		3.3 new CopyOnWriteArrayList();
		 * 
		 * 4 优化建议
		 */
	}
}
