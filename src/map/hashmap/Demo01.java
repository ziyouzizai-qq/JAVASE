package map.hashmap;

import java.util.HashMap;

/**
 * JDK1.8之后的HashMap源码分析 数组+链表+红黑树
 * HashMap这个类可以看出继承了AbstractMap并且实现了Map接口，
 * AbstractMap也实现了Map接口，其作者也承认这是一个失误。
 * 构造函数方面：
 * HashMap提供三个构造方法
 * @author 王浩
 *
 */
public class Demo01 {

	public static void main(String[] args) {
		// =====无参构造======
		/**
		 * loadFactor：加载因子，HashMap中一个重要的属性。
		 * 构造器中可以看出仅仅是将加载因子设置成0.75
		 * 加载因子过高虽然减少了空间开销，但同时也增加了查询成本。0.75是反复测试出来的最优选择，不要改！
		 * 小了会增大时间开销（频繁扩容，容易产生链表），大了会也增大时间开销（影响遍历）。
		 */
		HashMap<String, String> map1 = new HashMap<String, String>();

		// =====有参构造 ======
		/**
		 * 指定容量map
		 * 通过无符号右移，并且按位或的算法大于等于cap的最小的二次幂数值
		
		public HashMap(int initialCapacity, float loadFactor) {
			对你传过来的容量进行check
	        if (initialCapacity < 0)
	            throw new IllegalArgumentException("Illegal initial capacity: " +
	                                               initialCapacity);
	        if (initialCapacity > MAXIMUM_CAPACITY)
	            initialCapacity = MAXIMUM_CAPACITY;
	        if (loadFactor <= 0 || Float.isNaN(loadFactor))
	            throw new IllegalArgumentException("Illegal load factor: " +
	                                               loadFactor);
	        0.75的加载因子
	        this.loadFactor = loadFactor;
	        计算容量
	        this.threshold这边接收的是2的n次幂，其实resize之后
	        DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY，会变成总容量的0.75，要注意
	        this.threshold = tableSizeFor(initialCapacity);
	    }
	    
	    static final int tableSizeFor(int cap) {
	        int n = cap - 1;
	        n |= n >>> 1;
	        n |= n >>> 2;
	        n |= n >>> 4;
	        n |= n >>> 8;
	        n |= n >>> 16;
	        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
	    }
	    假设cap传过来是10
	    		十进制									二进制
	    cap		  10						0000 0000 0000 0000 0000 0000 0000 1010
	    
	    n		   9						0000 0000 0000 0000 0000 0000 0000 1001
	    n >>> 1    							0000 0000 0000 0000 0000 0000 0000 0100		按位或运算
	    -----------------------------------------------------------------------------------------
	    n		  13						0000 0000 0000 0000 0000 0000 0000 1101	
	    n >>> 2								0000 0000 0000 0000 0000 0000 0000 0011
	    -----------------------------------------------------------------------------------------
	    n         15						0000 0000 0000 0000 0000 0000 0000 1111
	    
	    。。。
	    之后不管移多少位还是一样的
	    通过移位算法或运算可以发现n第一个1的高位的后面多少位都会变成1的。然后在判断n+1，等于1 0000，
	    10最靠近的2的幂次方不就是16嘛
	    
	    但是为什么一上来先cap-1呢？
	    如果传过来是2的幂次方，比方说是16的话，意思是需要16的容量数组，是符合2的幂次方规则的，所以应当
	    返回16。
	    如果没有int n = cap - 1;这行代码
	    0000 0000 0000 0000 0000 0000 0001 0000
	    0000 0000 0000 0000 0000 0000 0000 1000
	    ---------------------------------------
	    0000 0000 0000 0000 0000 0000 0001 1000
	    0000 0000 0000 0000 0000 0000 0000 0110
	    。。。
	    最终会移动成 1 1111,再+1，等于10 0000 ，返回32了吧，与返回16不符，这就是为什么要先-1的操作。 
	    return操作三目套三目，主要是看n+1操作，其成立条件是0<=n<MAXIMUM_CAPACITY  
		 */
		HashMap<String, String> map2 = new HashMap<String, String>(10);
		
		
		/**
		 * Map<? extends K, ? extends V> m 将map放入另一个map
		 * 1. this.loadFactor = DEFAULT_LOAD_FACTOR;
		 * 2. putMapEntries(m, false);
		 * 
		 * 
      	final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
      		获取map中存放键值对数量
	        int s = m.size();	
	        if (s > 0) {
	        	table：数组，即Node<K,V>[]
	            if (table == null) { // pre-size
	            	3.map3对象才创建，table还是null，该进if吧
	            	======
	            	// TODO：为什么要这么算？
	            	如果(6,12]中s取除12外一个整数，容量还是16，因为你最大有11个元素
	            	还差一个元素才能进行扩容，但是如果是12呢，以下：
	            	s = 12
	            	((float)s / loadFactor) = 16
	            	ft = 17
	            	容量就需要取到32了，提前扩容，因为只要你再put一个元素有很大可能
	            	发生扩容，频繁扩容，需要重新计算索引，效率降低，不如提前扩容，因为现在
	            	还没计算索引值，该操作在putVal(hash(key), key, value, false, evict)中 	
	            	======
	                float ft = ((float)s / loadFactor) + 1.0F;
	                4.与2的30次方即数组容量最大值比较
	                int t = ((ft < (float)MAXIMUM_CAPACITY) ?
	                		 有可能是小数
	                         (int)ft : MAXIMUM_CAPACITY);
	                if (t > threshold)
	                	5.计算数组的容量（这个时候threshold还是table.length）
	                	调用for循环里面的putVal，只有第一次的时候
	                	(tab = table) == null 为true,进行resize后threshold = 0.75*table.length
	                    threshold = tableSizeFor(t);
	            }
	            else if (s > threshold)
	            	该情况说明什么进来：putAll方法是不是也要进来
	            	说明该map已经创建完毕并且扩容了吧，threshold = 0.75*table.length
	            	被存放的数组元素超过了是不是必须要扩容
	            	扩容
	                resize();
	            6.遍历键值对
	            for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
	                K key = e.getKey();
	                V value = e.getValue();
	                放值操作（下面涉及到）
	                putVal(hash(key), key, value, false, evict);
	            }
	        }
	    }  
		 */
		HashMap<String, String> map3 = new HashMap<String, String>(map1);		
		
		
		/**
		 * 放值源码解析：putVal(hash(key), key, value, false, evict);
		 * 上面遍历键值对也有这个操作

		求出hash值
		static final int hash(Object key) {
	        int h;
	        hashmap是可以以null为key的，求出的hash值永远为0，所以(n - 1) & hash 永远是同一个位置
	        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	    }
	    
	    (h = key.hashCode()) ^ (h >>> 16)
	    hashcode高16位和低16位异或求hash值，不容易出现hash碰撞
	    
		
		final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
	                   boolean evict) {
	        Node<K,V>[] tab; Node<K,V> p; int n, i;
	        ======
	        tab为数组，n为table数组长度
	        目前来看，源码还没涉及到设计层面，仅仅是用的java语法+算法+逻辑来处理
	        这部分源码我看下来，作者很喜欢在判断里面就把值赋了，源码看的时候一定
	        要细节，就拿下面这个判断为例，如果table为null，(n = tab.length) == 0不需要判断和赋值
	        直接走进if中扩容取length赋值给n，下面的if判断要用到。那如果table不等于null，判断
	        (n = tab.length) == 0，还防止了空指针。就算length不是0，这部分操作也不浪费，同样是
	        给n赋值给下面的if判断。整个代码看上去一团糟，其实学问很大，把代码的执行顺序和判断短路
	        运用的淋漓尽致。
	        ======
	        if ((tab = table) == null || (n = tab.length) == 0)
	        	说明需要扩容，有值进来，table是null或者是空是不合理的
	            n = (tab = resize()).length;
	        if ((p = tab[i = (n - 1) & hash]) == null)
	        	i = (n - 1) & hash求数组索引值，此处不仅判断该索引位置是否有节点存储
	        	如果null，创建一个节点，注意的是传入一个null，跟源码可以看出next为null，
	        	子节点为null，由此可见是链表，注意，如果不为null，走else，p在这里取到该索引的头节点
	            tab[i] = newNode(hash, key, value, null);
	        else {
	            Node<K,V> e; K k;
	            if (p.hash == hash &&
	                ((k = p.key) == key || (key != null && key.equals(k))))
	                如果put进来的hash和p节点的hash相等并且，两个key引用地址或者equals相等取其一
	                保存头节点
	                e = p;
	            else if (p instanceof TreeNode)
	            	红黑树操作
	                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
	            else {
	            	链表结构
	                for (int binCount = 0; ; ++binCount) {
	                    if ((e = p.next) == null) {
	                        p.next = newNode(hash, key, value, null);
	                        大于等于7就需要转红黑树，为什么是7，头节点算一个
	                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
	                            treeifyBin(tab, hash);
	                        break;
	                    }
	                    if (e.hash == hash &&
	                        ((k = e.key) == key || (key != null && key.equals(k))))
	                    如果在链表中找到符合条件的key，break掉，e = p.next判断加保存，逻辑非常巧妙。
	                        break;
	                    如果不符合上面两个条件，迭代下一个节点继续判断
	                    p = e;
	                }
	            }
	            if (e != null) { // existing mapping for key
	            	旧值
	                V oldValue = e.value;
	                onlyIfAbsent为false，看注释onlyIfAbsent if true, don't change existing value
	                即可以改变已存在的值
	                if (!onlyIfAbsent || oldValue == null)
	               		覆盖以前的值
	                    e.value = value;
	                方法无操作
	                afterNodeAccess(e);
	                返回旧值（这就是你覆盖了一个值，将你旧值返回的原因）
	                return oldValue;
	            }
	        }
	        修改次数+1
	        ++modCount;
	        能到这基本都是非覆盖操作，新元素put，所以size先加一然后判断
	        是否超过0.75的容量
	        if (++size > threshold)
	        	超过则扩容
	            resize();
	        方法无操作
	        afterNodeInsertion(evict);
	        由于你是添的新元素，无旧值返回
	        return null;
	    }
		 */
		// "k1".hashCode() = 3366
		map1.put("k1", "v1");
		
		
		// TODO:resize()分析
		
//		if (1>0) {
//			System.out.println(1);
//		} else if (2>0) {
//			System.out.println(2);
//		} else {
//			System.out.println(3);
//		}
	}

}