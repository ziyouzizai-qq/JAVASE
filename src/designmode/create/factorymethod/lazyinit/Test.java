package designmode.create.factorymethod.lazyinit;

import designmode.create.factorymethod.common.ConcreteProduct1;
import designmode.create.factorymethod.common.Product;

/**
 * 测试
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) {
		ConcreteCreator creator = new ConcreteCreator();
		Product product1 = creator.create(ConcreteProduct1.class);
		Product product = creator.create(ConcreteProduct1.class);
		Product product2 = creator.create(ConcreteProduct2.class);
		
		System.out.println(product1 == product);
		
		System.out.println(creator.getMap().size());
	}
}
