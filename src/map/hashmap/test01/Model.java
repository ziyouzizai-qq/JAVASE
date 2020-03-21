package map.hashmap.test01;

public class Model {

	private String str1;

	/**
	 * 返回固定值，这样不同Model的hashCode相同，hash = (h = key.hashCode()) ^ (h >>> 16)
	 * hash值一样，(n - 1) & hash 计算出的索引值就是一样的
	 */
	@Override
	public int hashCode() {
//		00000000 00000000 00000000 00000001
//		00000000 00000000 00000000 00000000
//		
//		hash =  11111111 11111111 11111111 11111110
//		16-1	00000000 00000000 00000000 00001111
//		index： 00000000 00000000 00000000 00001110 = 14
		return 1;
	}

	/**
	 * 固定是false，索引一样，hash值一样，为了产生链表p.next = newNode(hash, key, value, null);
	 * 不是同一个引用可以保证，并且equals必须是false
	 */
	@Override
	public boolean equals(Object obj) {
		return false;
	}
	
	
}
