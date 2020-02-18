package designmode.structure.decorator;

/**
 * 具体组件（ConcreteComponent）：是我们需要装饰的对象。
 * 中式风格
 * @author 王浩
 *
 */
public class ChineseStyle implements House {

	@Override
	public void style() {
		System.out.println("中式风格装修");
	}

}
