package designmode.behavior.strategy.demo02;

import java.math.BigDecimal;

/**
 * 普通用户
 * @author 王浩
 *
 */
@PriceRegion(max = 10000)
public class OrdinaryUser implements Price {

	@Override
	public BigDecimal getPrice(BigDecimal price) {
		return price;
	}

}
