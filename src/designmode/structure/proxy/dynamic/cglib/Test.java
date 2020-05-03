package designmode.structure.proxy.dynamic.cglib;

/**
 * CGLIB动态代理测试
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) {
		// 代理逻辑类
		CGLibProxy proxy = new CGLibProxy();
		// 获取Train类的代理对象
        Train t = (Train) proxy.getProxy(Train.class);
        // 代理对象调用
        t.move();
        
        System.out.println("=========");
        Train t1 = (Train) proxy.getProxy(Train.class);
        System.out.println(t == t1);
	}

}
