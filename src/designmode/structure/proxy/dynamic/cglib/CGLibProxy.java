package designmode.structure.proxy.dynamic.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 2.生成代理
 * @author 王浩
 *
 */
public class CGLibProxy implements MethodInterceptor {

	/**
	 * 生成CGLIB代理对象
	 * @param clazz class类
	 * @return class类的CGLIB代理对象
	 */
	public Object getProxy(Class<?> clazz) {
		// CGLIB enhancer增强类对象
		Enhancer enhancer = new Enhancer();
		// 设置增强类型
		enhancer.setSuperclass(clazz);
		enhancer.setUseCache(false);
		// 定义代理逻辑对象为当前对象，要求当前对象实现MethodInterceptor方法
		enhancer.setCallback(this);
		// 生成并返回代理对象
		return enhancer.create();
	}

	/**
	 * 拦截所有目标类方法的调用,即代理逻辑方法
	 * @param obj 代理对象
	 * @param method 方法
	 * @param args 方法的参数
	 * @param proxy 方法代理
	 * @return 
	 * @throws Throwable异常
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// 理类调用父类的方法  
        System.out.println("调用真实对象前");
        // CGLIB反射调用真实对象方法
        Object result = proxy.invokeSuper(obj, args);  
        System.out.println("调用真实对象后");  
		return result;
	}

}
