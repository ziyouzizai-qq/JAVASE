package container.collection.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 集合类不安全的问题
 * ArrayList
 * @author 王浩
 *
 */
public class ArrayListNotSafeDemo {

	public static void main(String[] args) {
//		List<String> arr = new Vector<String>();
//		List<String> arr = Collections.synchronizedList(new ArrayList<String>());
		CopyOnWriteArrayList<String> arr = new CopyOnWriteArrayList<>();
//		Vector比ArrayList版本还要早，但是Vector线程安全，但是并发效率低
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
