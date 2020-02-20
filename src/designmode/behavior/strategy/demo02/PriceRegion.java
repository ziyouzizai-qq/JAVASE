package designmode.behavior.strategy.demo02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 价格区间注解
 * @author 王浩
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PriceRegion {

	int min() default 0;

	int max() default Integer.MAX_VALUE;
}
