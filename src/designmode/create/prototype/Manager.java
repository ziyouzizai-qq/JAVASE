package designmode.create.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * 外部复制实例的接口，先注册，将实例对保存在HashMap中，再通过名称去除实例完成复制
 * @author 王浩
 *
 */
public class Manager {
	
	private Map<String,Product> products = new HashMap<String,Product>();
	
    public void register(String name,Product p){
    	products.put(name, p);
    }
    
    public Product create(String name){
        Product product = (Product)products.get(name);
//        return product;
        return product.creactClone();
    }
}
