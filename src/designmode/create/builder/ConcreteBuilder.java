package designmode.create.builder;

/**
 * 具体建造者类
 * @author 王浩
 *
 */
public class ConcreteBuilder implements Builder {
	
	private Product product = new Product();

	@Override
	public void buildPart1() {
		product.setPart1("build part1...");
	}

	@Override
	public void buildPart2() {
		product.setPart2("build part2...");
	}

	@Override
	public Product getResult() {
		return product;
	}

}
