package number;

import java.math.BigDecimal;

/**
 * float(高精度)
 * 用于：防止精度丢失
 * @author 王浩
 *
 */
public class DemoForBigDecimal {

	public static void main(String[] args) {
		// 精度丢失
		double money = 3.0;
		double price = 2.9;
		System.out.println(money - price);
		// 防止精度丢失
		BigDecimal b1 = new BigDecimal("3.011");
	    BigDecimal b2 = new BigDecimal("2.9");
	    System.out.println(b1.subtract(b2));
	    // ...BigDecimal给我们提供了很多API，详情可看官方文档
	}

}
