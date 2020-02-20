package designmode.behavior.strategy.demo02;

import java.math.BigDecimal;

/**
 * 价格策略接口
 * @author 王浩
 *
 */
public interface Price {

	BigDecimal getPrice(BigDecimal price);
}
