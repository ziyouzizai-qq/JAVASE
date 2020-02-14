package designmode.create.factorymethod.singleton;

/**
 * 测试
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) {
		SingletonFactory factory = new SingletonFactory();
		Singleton singleton1 = factory.getSingleton();
		Singleton singleton2 = factory.getSingleton();
		System.out.println(singleton1);
		System.out.println(singleton2);
		System.out.println(singleton1 == singleton2);
	}
}
