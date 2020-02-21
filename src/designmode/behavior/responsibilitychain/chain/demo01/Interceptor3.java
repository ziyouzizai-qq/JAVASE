package designmode.behavior.responsibilitychain.chain.demo01;

import java.lang.reflect.Method;

import designmode.behavior.responsibilitychain.interceptor.Interceptor;

/**
 * 拦截器3
 * @author 王浩
 *
 */
public class Interceptor3 implements Interceptor {

	@Override
	public boolean before(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("【拦截器3】的before方法");
		return true;
	}

	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("【拦截器3】的after方法");

	}

}
