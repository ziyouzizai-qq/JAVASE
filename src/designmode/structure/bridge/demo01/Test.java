package designmode.structure.bridge.demo01;

/**
 * 桥接模式-测试类
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) {
		Person man = new Man();
		 
		Person lady = new Lady();
 
		Clothing jacket = new Jacket();
 
		Clothing trouser = new Trouser();
 
		jacket.personDressCloth(man);
		trouser.personDressCloth(man);
 
		jacket.personDressCloth(lady);
		trouser.personDressCloth(lady);
	}
}
