package designmode.structure.bridge.demo02;

/**
 * Implementor接口类
 * 实现类接口，定义实现部分的接口，这个接口不用和Abstraction
 * 里面的方法一致，通常是由Implementor接口提供基本的操作，而
 * Abstraction里面定义的是基于这些基本操作的业务方法，也就是
 * 说Abstraction定义了基于这些基本操作的较高层次的操作。
 * @author 王浩
 *
 */
public interface Engine {
	void engine();
}
