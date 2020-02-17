package designmode.structure.bridge.demo01;

/**
 * 定义ConcreteImplementor类Jacket
 * @author 王浩
 *
 */
public class Jacket extends Clothing {

	@Override
	public void personDressCloth(Person person) {
		System.out.println(person.getType() + "穿马甲");
	}

}
