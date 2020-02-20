package designmode.behavior.strategy.demo01;

/**
 * 策略接口
 * @author 王浩
 *
 */
public interface Strategy {

	void operate();
	
    int add(int numA,int numB);

    int minus(int numA,int numB);
}
