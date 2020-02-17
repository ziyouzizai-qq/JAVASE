package designmode.structure.bridge.demo02;

/**
 * 测试类
 * @author 王浩
 *
 */
public class MainTest {

	public static void main(String[] args) {
		Car car = new Bus(new Engine2200());
		car.engine();
	}

}
