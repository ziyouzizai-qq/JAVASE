package map.hashmap;


/**
 * 整个源码分析完成我会做一篇md文档，比放在java类里面更直观一点
 * 
 * 转红黑树
 * 当链表长度大于8时转红黑树，调用方法treeifyBin(tab, hash);
 * tab：数组
 * hash：当前put的key的hash值
 * 当节点数达到8要转换成红黑树？
 * 1.根据计算出来的hash值，导致在数组同一个位置，产生的概率符合泊松分布
 * 当节点数达到8时，概率是0.00000006，这意味着能到8个节点，概率可以去买彩票。
 * 当如果真的数量到达8时，链表的性能就会很差，差的原因就是因为Node的数据结构
 * 你会发现每个节点都是需要先找到父节点才能定位到自身。所以说为什么链表结构查询
 * 比下标效率要低。为了提高效率，链表节点数超过8是要有红黑树操作的。
 * 
 * 2.对比Node和TreeNode源码，TreeNode空间复杂度是Node的两倍，因为他两个节点，
 * 一定程度上可以理解为利用空间换取时间的策略。
 * 其实在JDK1.8之前的版本只是数组+链表结构，1.8之后引入红黑树，并且源码都有很大
 * 的变化。但为什么在一定范围内用Node，一定范围内转TreeNode，查看源码之后你会发现
 * 当满足节点数超过8并且数组长度大于等于64，才转为红黑树。就是因为节点数达到8并且
 * 数组长度大于等于64的时候，红黑树的效率是比链表高的，反之，链表效率比红黑树高，
 * 官方这么折腾，就是为了提高性能。
 * 下面分析源码：
 * @author 王浩
 *
 */
public class Demo02 {
	
	/**
	 * 走进整个方法的前提是链表节点数超过8个
		final void treeifyBin(Node<K,V>[] tab, int hash) {
	        int n, index; Node<K,V> e;
	        仅仅针对于putVal调用treeifyBin来讲，不存在tab == null的情况，putVal方法对此情况
	        是有处理的，所以说是tab == null是false，tab.length<64,进行扩容，不满足转红黑树的
	        条件，至此，我问一个问题，链表长度有没有可能超过8的情况，比如说9？
	        参照package test01
	        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
	        	小于64，进行扩容，不转成红黑树
	            resize();
	        else if ((e = tab[index = (n - 1) & hash]) != null) {
	        	e：取出计算出索引值位置的链表
	        	阈值大于8并且table长度大于等于64，仅仅针对于putVal调用treeifyBin来讲，不存在
	        	tab[index = (n - 1) & hash] == null的情况，putVal方法对此情况是有处理的。
	        	hd：红黑树的头结点
	        	tl：拼接时树的尾节点（注意是拼接时）
	            TreeNode<K,V> hd = null, tl = null;
	            迭代链表节点
	            do {
	            	将头节点用TreeNode类型包起来，底层继承Node，所以说取出的节点要instanceof判断
	                TreeNode<K,V> p = replacementTreeNode(e, null);
	                if (tl == null)
	                	第一次进来，链表头节点转成树节点还是树的根节点吧
	                    hd = p;
	                else {
	                	当前树节点p中保存t1为前节点
	                    p.prev = tl;
	                    父节点的子节点保存一份p
	                    tl.next = p;
	                }
	                记录上一个循环的节点，供下一次循环节点之间互相关联
	                tl = p;
	            } while ((e = e.next) != null);
	            if ((tab[index] = hd) != null)
	            	如果hd有值的话，其实到这里肯定是有值的，至此，还没转红黑树，感觉只是包了
	            	个TreeNode类型，还是个链表，只不过和普通链表区别就是，普通链表是父节点只会记录子
	            	节点，子节点是不会记录父节点的吧，上面父子节点是不是互相都记录了。
	            	下面这个方法才是关键
	                hd.treeify(tab);
	        }
	    }
	 	
	 	
	 	
	 	final void treeify(Node<K,V>[] tab) {
            TreeNode<K,V> root = null;
            for (TreeNode<K,V> x = this, next; x != null; x = next) {
                next = (TreeNode<K,V>)x.next;
                x.left = x.right = null;
                if (root == null) {
                    x.parent = null;
                    x.red = false;
                    root = x;
                }
                else {
                    K k = x.key;
                    int h = x.hash;
                    Class<?> kc = null;
                    for (TreeNode<K,V> p = root;;) {
                        int dir, ph;
                        K pk = p.key;
                        if ((ph = p.hash) > h)
                            dir = -1;
                        else if (ph < h)
                            dir = 1;
                        else if ((kc == null &&
                                  (kc = comparableClassFor(k)) == null) ||
                                 (dir = compareComparables(kc, k, pk)) == 0)
                            dir = tieBreakOrder(k, pk);

                        TreeNode<K,V> xp = p;
                        if ((p = (dir <= 0) ? p.left : p.right) == null) {
                            x.parent = xp;
                            if (dir <= 0)
                                xp.left = x;
                            else
                                xp.right = x;
                            root = balanceInsertion(root, x);
                            break;
                        }
                    }
                }
            }
            moveRootToFront(tab, root);
        }
	 	
	 */

}
