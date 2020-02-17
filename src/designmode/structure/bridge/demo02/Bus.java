package designmode.structure.bridge.demo02;

/**
 * RefinedAbstraction：扩充抽象类
 * 扩充抽象类，扩展抽象部分的接口，通常在这些对象里面，
 * 定义跟实际业务相关的方法，这些方法的实现通常会
 * 使用Abstraction中定义的方法，也可能需要调用实现部分的对象来完成。
 * @author 王浩
 *
 */
public class Bus extends Car {

	public Bus(Engine engine) {
		super(engine);
	}

	@Override
	public void engine() {
		System.out.println("Bus:");
		getEngine().engine();
	}

}
