package designmode.behavior.iterator;

/**
 * 迭代子模式测试类
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) {
		Collection collection = new MyCollection();  
        Iterator it = collection.iterator();  
          
        while(it.hasNext()){  
            System.out.println(it.next());  
        } 
	}
}
