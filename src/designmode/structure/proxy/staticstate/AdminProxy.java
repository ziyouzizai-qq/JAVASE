package designmode.structure.proxy.staticstate;

/**
 * 第一种代理方式：对象代理
 * 静态代理对象类
 * @author 王浩
 *
 */
public class AdminProxy implements Manager {
	
	// 被代理对象
	private Manager admin;
	
	public AdminProxy(Manager admin){
		this.admin = admin;
	}

	@Override
	public void doSomething() {
		System.out.println("----开始了----");
		admin.doSomething();
		System.out.println("----结束了----");
	}

}
