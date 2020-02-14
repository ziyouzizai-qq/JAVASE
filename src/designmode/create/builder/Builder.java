package designmode.create.builder;

/**
 * 抽象建造者
 * @author 王浩
 *
 */
public interface Builder {

	/**
     * 产品零件构造方法1
     * 
     */
    void buildPart1();
    /**
     * 产品零件构造方法2
     * 
     */
    void buildPart2();
    
    /**
     * 产品返还
     * @return
     */
    Product getResult();
}
