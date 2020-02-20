package designmode.behavior.strategy.demo01;

/**
 * 策略接口实现类
 * 
 * @author 王浩
 *
 */
public class Worker1 implements Strategy {

	@Override
	public void operate() {
		System.out.println("第一个操作工的工序");

	}

	@Override
	public int add(int numA, int numB) {
		return numA + numB + 1;
	}

	@Override
	public int minus(int numA, int numB) {
		return numA - numB - 1;
	}

}
