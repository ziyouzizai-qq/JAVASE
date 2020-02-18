package designmode.structure.decorator;

/**
 * 抽象装饰类（Decorator）：内含指向抽象组件的引用及装饰者共有的方法。
 * 
 * @author 王浩
 *
 */
public abstract class HouseDecorator implements House {

	protected House house;

	public HouseDecorator(House house) {
		this.house = house;
	}

	@Override
	public void style() {
		house.style();
	}

}
