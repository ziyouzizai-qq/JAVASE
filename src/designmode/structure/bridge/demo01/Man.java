package designmode.structure.bridge.demo01;

/**
 * 定义RefinedAbstraction类Man
 * @author 王浩
 *
 */
public class Man extends Person {
	
	public Man() {
        setType("男人");
    }


	@Override
	public void dress() {
		Clothing clothing = getClothing();
        clothing.personDressCloth(this);
	}

}
