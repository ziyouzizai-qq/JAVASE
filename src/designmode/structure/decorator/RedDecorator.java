package designmode.structure.decorator;

/**
 * 
 * @author 王浩
 *
 */
public class RedDecorator extends HouseDecorator {

	public RedDecorator(House house) {
		super(house);
	}
	
	public void style() {
		house.style();
		System.out.println("红色装饰墙");
	}


}
