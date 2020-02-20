package designmode.behavior.strategy.demo02;

import java.math.BigDecimal;

/**
 * 金牌会员
 * @author 王浩
 *
 */
@PriceRegion(min = 20000)
public class SuperUser implements Price {

	@Override
	public BigDecimal getPrice(BigDecimal price) {
		return price.multiply(new BigDecimal(0.4+""));
	}

}
