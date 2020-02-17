package designmode.structure.bridge.demo02;

public class Jeep extends Car {

	public Jeep(Engine engine) {
		super(engine);
	}
 
	@Override
	public void engine() {
		System.out.println("Jeep:");
		getEngine().engine();
	}


}
