package designmode.create.factorymethod.common;

/**
 * 抽象工厂实现
 * @author 王浩
 *
 */
public class ConcreteCreator implements Creator {

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Product> T createProduct(Class<T> c) {
		Product product=null;
        try {
            product = (Product)Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            //异常处理
        }
        return (T)product;
	}

}
