package designmode.structure.bridge.demo02;

/**
 * Abstraction抽象类
 * 抽象部分的接口。通常在这个对象里面，要维护一个实现部分的对象引用，
 * 在抽象对象里面的方法，需要调用实现部分的对象来完成。这个对象里面
 * 的方法，通常都是跟具体的业务相关的方法。
 * @author 王浩
 *
 */
public abstract class Car {

	private Engine engine;

	public Car(Engine engine) {
		setEngine(engine);
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public abstract void engine();
}
