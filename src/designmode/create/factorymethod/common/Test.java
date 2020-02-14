package designmode.create.factorymethod.common;

/**
 * 测试
 * @author 王浩
 *
 */
public class Test {
	public static void main(String[] args) {
		// 一般工厂是单例
		Creator creator  = new ConcreteCreator();
		ConcreteProduct1 noticeProduct = creator.createProduct(ConcreteProduct1.class);
		noticeProduct.method();
	}
}
