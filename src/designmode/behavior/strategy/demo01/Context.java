package designmode.behavior.strategy.demo01;

/**
 * 统一策略管理类
 * 真实的环境下，可以通过外部配置动态传入和管理
 * @author 王浩
 *
 */
public class Context {

	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	// 统一的操作算法入口，外部调用的时候，根据不同的实例进行调用就可以得到不同的结果
	public void operate() {
		strategy.operate();
	}

	public int add(int numA, int numB) {
		return strategy.add(numA, numB);
	}

	public int minus(int numA, int numB) {
		return strategy.minus(numA, numB);
	}
}
