package designmode.behavior.strategy.demo02;

import java.math.BigDecimal;

/**
 * 对外提供统一管理策略类
 * @author 王浩
 *
 */
public class PriceEnvironment {

	public BigDecimal getPrice(BigDecimal costPrice) throws Exception {
		// 根据消费金额生成所对应的人员实例
        Price price = PriceFactory.getInstance().getPrice(costPrice);
        // 返回打折后的价格
        return price.getPrice(costPrice);
    }
}
