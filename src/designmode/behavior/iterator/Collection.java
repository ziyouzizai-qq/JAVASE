package designmode.behavior.iterator;

/**
 * Collection接口
 * @author 王浩
 *
 */
public interface Collection {

	Iterator iterator();  
    
    /*取得集合元素*/  
    Object get(int i);  
      
    /*取得集合大小*/  
    int size(); 
}
