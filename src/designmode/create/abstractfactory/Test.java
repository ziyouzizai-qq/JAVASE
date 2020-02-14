package designmode.create.abstractfactory;

/**
 * 测试
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) {
		//生产宝马320系列配件
        FactoryBMW320 factoryBMW320 = new FactoryBMW320();  
        factoryBMW320.createEngine();
        factoryBMW320.createAircondition();
          
        //生产宝马523系列配件  
        FactoryBMW523 factoryBMW523 = new FactoryBMW523();  
        factoryBMW523.createEngine();
        factoryBMW523.createAircondition();
	}
}
