package designmode.structure.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {
	
	private Object target;  
    
    public TimeHandler(Object target) {  
        this.target = target;  
    } 

    /** 
     * 参数： 
     * @param proxy 被代理的对象 
     * @param method 被代理对象的方法 
     * @param args 方法的参数  
     * @return Object 方法返回值 
     */ 
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long startTime = System.currentTimeMillis();  
        System.out.println("汽车开始行驶…");  
        method.invoke(target, args);  
        long stopTime = System.currentTimeMillis();  
        System.out.println("汽车结束行驶…汽车行驶时间：" + (stopTime - startTime) + "毫秒！");  
        return null; 
	}

}
