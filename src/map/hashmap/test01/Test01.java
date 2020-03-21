package map.hashmap.test01;

import java.util.HashMap;

/**
 * 测试链表长度是否可以超过8
 * @author 王浩
 *
 */
public class Test01 {

	public static void main(String[] args) throws Exception {
		HashMap<Model, Integer> map = new HashMap<Model, Integer>();
//		Model model = new Model();
		for (int i = 1; i <= 8; i++) {
			map.put(new Model(), i);
		}
		map.put(new Model(), 9);
		// 上述操作只能debug调试，不能使用反射
		/**
		 * 讲一下大致原理，由于索引位置一样，要保证每一次都在链表后面生成一个节点
		 * 就要保证引用地址是不一样并且equals为false，所以说上述我每次都new对象，
		 * equals恒为false。
		 * 假设table长度为16，同一个索引地址放入8个节点，再放一个，走treeifyBin方法，由于此时
		 * 长度小于64，进行扩容，扩容前面我讲过原理，左移扩容两倍。变成32。在新数组的索引值两种情况
		 * 假设9个节点的hash值关键位相同，是不是就可以以9个节点的链表挂在新数组对应索引下面。
		 * 所以说，链表超过8在特殊情况下是有可能存在的。那我在放一个，又走treeifyBin方法，又扩容，64
		 * 10个节点的hash值关键位相同，链表长度就是10，那我在放一个，又走treeifyBin方法，又扩容，128。
		 * table长度就不符合小于64的条件，就得转红黑树。
		 */
		// 结论：在特定条件下，链表长度可以存在超过8的情况。
	}
}
