package designmode.behavior.strategy.demo02;

import java.math.BigDecimal;

/**
 * 会员用户
 * @author 王浩
 *
 */
@PriceRegion(min = 10000,max = 20000)
public class MemberUser implements Price {

	@Override
	public BigDecimal getPrice(BigDecimal price) {
		return price.multiply(new BigDecimal(0.6 + ""));
	}

}
