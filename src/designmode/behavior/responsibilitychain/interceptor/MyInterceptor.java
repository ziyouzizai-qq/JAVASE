package designmode.behavior.responsibilitychain.interceptor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 拦截器接口实现类
 * @author 王浩
 *
 */
public class MyInterceptor implements Interceptor {

	@Override
	public boolean before(Object proxy, Object target, Method method, Object[] args) {
		System.err.println("反射方法前逻辑");
		return true; // 不反射被代理对象原有方法
	}

	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		System.err.println("取代了被代理对象的方法");
	}

	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		System.err.println("反射方法后逻辑");
	}

}
