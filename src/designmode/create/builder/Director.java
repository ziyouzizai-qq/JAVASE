package designmode.create.builder;

/**
 * 导演者类
 * @author 王浩
 *
 */
public class Director {

	/**
	 * 需要使用的当前建造者对象
	 */
	private Builder builder;
 
	public Director(Builder builder) {
		this.builder = builder;
	}
	
	/**
	 * 产品构造方法，负责调用各个零件构造方法
	 */
	public void  buildProduct(){
		builder.buildPart1();
		builder.buildPart2();
	}

}
