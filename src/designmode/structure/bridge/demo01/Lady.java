package designmode.structure.bridge.demo01;

/**
 * 定义RefinedAbstraction类Lady
 * @author 王浩
 *
 */
public class Lady extends Person {
	
	public Lady() {
        setType("女人");
    }


	@Override
	public void dress() {
		Clothing clothing = getClothing();
        clothing.personDressCloth(this);
	}

}
