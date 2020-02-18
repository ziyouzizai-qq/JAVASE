package designmode.structure.decorator;

/**
 * 具体组件（ConcreteComponent）：是我们需要装饰的对象。
 * 欧式风格
 * @author 王浩
 *
 */
public class EuropeanStyle implements House {

	@Override
	public void style() {
		System.out.println("欧式风格装修");
	}

}
