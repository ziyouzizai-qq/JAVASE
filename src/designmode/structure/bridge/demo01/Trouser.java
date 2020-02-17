package designmode.structure.bridge.demo01;

/**
 * 定义ConcreteImplementor类 Trouser
 * @author 王浩
 *
 */
public class Trouser extends Clothing {

	@Override
	public void personDressCloth(Person person) {
		System.out.println(person.getType() + "穿裤子");
	}

}
