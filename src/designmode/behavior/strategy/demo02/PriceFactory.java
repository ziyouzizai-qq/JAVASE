package designmode.behavior.strategy.demo02;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 统一管理策略池
 * 
 * @author 王浩
 *
 */
public class PriceFactory {

	/**
	 * 单例工厂
	 */
	private static final PriceFactory FACTORY = new PriceFactory();

	/**
	 * 策略类集合
	 */
	private List<Class<? extends Price>> priceList = new ArrayList<>();

	/**
	 * 获取包路径下所有的策略实现类
	 */
	@SuppressWarnings("unchecked")
	public void getClassNames() {
		try {
			String packageName = "designmode.behavior.strategy.demo02";
			Set<String> classNames = ClassUtils.getClassName(packageName, false);
			for (String single : classNames) {
				// 这边要筛选出Price的实现类对象
				Class<?> classObj = Class.forName(single).getClassLoader().loadClass(single);
				if (Price.class.isAssignableFrom(classObj) // 判断是否是Price的子类
						&& !classObj.isInterface() // 判断是否是接口或者注解
						&& !(classObj.getModifiers() == 1025)) { // 判断是否是抽象类
					// 按理说只放Price的实现类
					priceList.add((Class<? extends Price>) classObj);
				}
			}

			// 遍历集合看看放了哪些元素
			for (Class<? extends Price> clazz : priceList) {
				System.out.println(clazz);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 策略业务池私有
	 */
	private PriceFactory() {
		// 实例化之前做操作
		getClassNames();
	}

	/**
	 * 获取对应金额的策略类
	 * 
	 * @param price
	 *            金额
	 * @return Price
	 * @throws Exception
	 *             classNotFound
	 */
	public Price getPrice(BigDecimal price) throws Exception {
		// 遍历所有的Price实现类对象
		for (Class<? extends Price> clazz : priceList) {
			// 获取注解信息
			PriceRegion priceRegion = clazz.getAnnotation(PriceRegion.class);
			// 来判断是哪一个用户级别
			if (priceRegion != null // 防止空指针，按照设计来讲这边不应该私自处理这样的错误，应抛出给程序员提示没有遵循规范
					&& Price.class.isAssignableFrom(clazz) // 判断是否是Price的子类
					&& !clazz.isInterface() // 判断是否是接口或者注解
					&& !(clazz.getModifiers() == 1025)) { // 判断是否是抽象类
				if (price.compareTo(new BigDecimal(priceRegion.max())) < 0
						&& price.compareTo(new BigDecimal(priceRegion.min())) > 0) {
					// 返回对应的用户实例
					return clazz.newInstance();
				}
			}
		}
		return null;
	}

	/**
	 * 获取策略业务池
	 * 
	 * @return 单例策略业务池
	 */
	public static PriceFactory getInstance() {
		return FACTORY;
	}
}
