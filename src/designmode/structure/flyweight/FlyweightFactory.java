package designmode.structure.flyweight;

import java.util.HashMap;

/**
 * 享元工厂类
 * 
 * @author 王浩
 *
 */
public class FlyweightFactory {

	// 存储享元对象
	private HashMap<String, Flyweight> flyweights = new HashMap<String, Flyweight>();

	/**
	 * 获取享元对象（存在线程问题）
	 * @param key 
	 * @return
	 */
	public Flyweight getFlyweight(String key) {
		Flyweight flyweight = (Flyweight) flyweights.get(key);
		if (flyweight != null) {
			System.out.println("具体享元" + key + "已经存在，被成功获取！");
		} else {
			flyweight = new ConcreteFlyweight(key);
			flyweights.put(key, flyweight);
		}
		return flyweight;
	}
}
