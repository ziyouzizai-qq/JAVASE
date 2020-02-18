package designmode.structure.proxy.staticstate;

/**
 * 目标对象（被代理对象）类
 * @author 王浩
 *
 */
public class Admin implements Manager {

	@Override
	public void doSomething() {
		System.out.println("来自Admin方法doSomething！");
	}

}
