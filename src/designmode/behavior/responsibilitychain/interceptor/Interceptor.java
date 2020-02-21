package designmode.behavior.responsibilitychain.interceptor;

import java.lang.reflect.Method;

/**
 * 拦截器接口
 * @author 王浩
 *
 */
public interface Interceptor {

	boolean before(Object proxy, Object target, Method method, Object[] args);
	
	void around(Object proxy, Object target, Method method, Object[] args);
	
	void after(Object proxy, Object target, Method method, Object[] args);
}
