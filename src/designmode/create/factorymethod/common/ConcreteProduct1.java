package designmode.create.factorymethod.common;

/**
 * 具体产品
 * @author 王浩
 *
 */
public class ConcreteProduct1 implements Product {

	@Override
	public void method() {
		//具体产品方法
		System.out.println("调用ConcreteProduct1的method");
	}

}
