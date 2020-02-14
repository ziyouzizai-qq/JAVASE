package designmode.create.abstractfactory;

/**
 * 为宝马320系列生产配件
 * @author 王浩
 *
 */
public class FactoryBMW320 implements AbstractFactory {

	@Override
	public Engine createEngine() {
		return new EngineA(); 
	}

	@Override
	public Aircondition createAircondition() {
		return new AirconditionA();
	}

}
