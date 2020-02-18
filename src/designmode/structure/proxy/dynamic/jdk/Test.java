package designmode.structure.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理测试类
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) throws Exception {
		// 被代理对象
		Car car = new Car();
		// 代理逻辑
        InvocationHandler h = new TimeHandler(car);
        // 获取代理类对象
        Class<?> cls = car.getClass();  
        /** 
         *loader 类加载器 
         *interfaces 实现接口 
         *h InvocationHandler 
         */ 
        // 获取代理对象
        Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(),cls.getInterfaces(), h);  
        m.move();
	}
}
