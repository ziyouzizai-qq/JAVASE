package designmode.structure.bridge.demo02;

/**
 * ConcreteImplementor接口实现类
 * 具体实现类，真正实现Implementor接口的对象。
 * @author 王浩
 *
 */
public class Engine2000 implements Engine {

	@Override
	public void engine() {
		System.out.println("安装2000cc发动机");
	}


}
