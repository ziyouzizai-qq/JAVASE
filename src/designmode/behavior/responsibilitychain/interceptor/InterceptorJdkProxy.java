package designmode.behavior.responsibilitychain.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Jdk动态代理使用拦截器
 * @author 王浩
 *
 */
public class InterceptorJdkProxy implements InvocationHandler {
	
	private Object target; // 真实对象
	
	private String interceptorClass = null; // 拦截器权限定名

	public InterceptorJdkProxy(Object target, String interceptorClass) {
		this.target = target;
		this.interceptorClass = interceptorClass;
	}

	/**
	 * 绑定目标对象并返回一个代理对象
	 * @param target 目标对象
	 * @param interceptorClass 拦截器权限定名
	 * @return 代理对象
	 */
	public static Object bind(Object target, String interceptorClass) {
		// 获取代理对象
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), 
				new InterceptorJdkProxy(target, interceptorClass));
	}
	
	@Override
	/**
	 * 通过代理对象调用该方法
	 * 
	 * @param proxy 代理对象
	 * @param method 方法，被调用的方法
	 * @param 方法的参数
	 * 
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (interceptorClass == null) {
			// 没有设置拦截器则直接反射原有方法
			return method.invoke(target, args);
		}
		
		Object result = null;
		// 通过反射生成拦截器
		Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();
		// 调用前置方法
		if (interceptor.before(proxy, args, method, args)) {
			result = method.invoke(target, args);
		} else { // 返回false执行around方法
			interceptor.around(proxy, args, method, args);
		}
		// 调用后置方法
		interceptor.after(proxy, args, method, args);
		return result;
	}

}
