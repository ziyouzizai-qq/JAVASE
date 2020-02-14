package designmode.create.abstractfactory;

/**
 * 创建工厂的接口
 * @author 王浩
 *
 */
public interface AbstractFactory {

	// 制造发动机
	Engine createEngine();
	
	
	// 制造空调
	Aircondition createAircondition();
}
