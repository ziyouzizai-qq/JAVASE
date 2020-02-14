package designmode.create.factorymethod.lazyinit;

import java.util.HashMap;
import java.util.Map;

import designmode.create.factorymethod.common.Product;

public class ConcreteCreator {

	// 容纳已经创建的对象
    private static Map<Class,Product> map =  new HashMap<>(16);
    
    public static Map<Class,Product> getMap() {
    	return map;
    }
 
    // 工厂方法
    public static synchronized <T extends Product> T create(Class<T> c) {
        Product product = null;
 
        if(map.containsKey(c)){
            // 如果map 中已存在创建的对象直接返回
        	System.out.println("container " + c + " is exist");
            return (T)map.get(c);
        }
        try {
            product = (Product)Class.forName(c.getName()).newInstance();
            map.put(c, product);
        } catch (Exception e) {
            // 异常处理
        }
        return (T)product;
    }
}
