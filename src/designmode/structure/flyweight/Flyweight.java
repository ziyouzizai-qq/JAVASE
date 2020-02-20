package designmode.structure.flyweight;

/**
 * 抽象享元类
 * @author 王浩
 *
 */
public interface Flyweight {

	void operation(UnsharedConcreteFlyweight state);
}
