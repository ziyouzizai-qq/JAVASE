package designmode.create.builder;

/**
 * 测试类
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) {
		Builder builder = new ConcreteBuilder();
		Director director = new  Director(builder);
		director.buildProduct();
		Product product = builder.getResult();
		System.out.println(product.getPart1());
		System.out.println(product.getPart2());

	}

}
