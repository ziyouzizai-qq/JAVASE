package designmode.create.factorymethod.lazyinit;

import designmode.create.factorymethod.common.Product;

/**
 * 具体产品
 * @author 王浩
 *
 */
public class ConcreteProduct2 implements Product {

	@Override
	public void method() {
		//具体产品方法
		System.out.println("调用ConcreteProduct2的method");
	}

}
