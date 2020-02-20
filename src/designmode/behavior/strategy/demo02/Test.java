package designmode.behavior.strategy.demo02;

import java.math.BigDecimal;

/**
 * 策略模式测试
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) throws Exception {
		PriceEnvironment priceContext = new PriceEnvironment();
        System.out.println(priceContext.getPrice(new BigDecimal(567)));
        System.out.println(priceContext.getPrice(new BigDecimal(12200)));
        System.out.println(priceContext.getPrice(new BigDecimal(30000)));
	}
}
