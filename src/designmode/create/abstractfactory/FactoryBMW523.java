package designmode.create.abstractfactory;

/**
 * 宝马523系列
 * @author 王浩
 *
 */
public class FactoryBMW523 implements AbstractFactory {

	@Override
	public Engine createEngine() {
		return new EngineB();
	}

	@Override
	public Aircondition createAircondition() {
		return new AirconditionB();
	}

}
