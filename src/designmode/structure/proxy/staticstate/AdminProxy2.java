package designmode.structure.proxy.staticstate;

/**
 * 第一种代理方式：类代理
 * @author 王浩
 *
 */
public class AdminProxy2 extends Admin {

	@Override
	public void doSomething() {
		System.out.println("----2开始了----");
		super.doSomething();
		System.out.println("----2结束了----");
	}

}
