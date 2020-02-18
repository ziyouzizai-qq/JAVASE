package designmode.structure.proxy.staticstate;

/**
 * 测试静态代理
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) {
		// 目标对象
		Manager admin = new Admin();
		// 代理对象
		Manager proxy = new AdminProxy(admin);
		
		proxy.doSomething();
		
		AdminProxy2 proxy2 = new AdminProxy2();
		proxy2.doSomething();
	}
}
