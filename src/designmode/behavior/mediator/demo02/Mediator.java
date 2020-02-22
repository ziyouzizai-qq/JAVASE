package designmode.behavior.mediator.demo02;

/**
 * 中介者接口
 * @author 王浩
 *
 */
public interface Mediator {

	/**
	 * 同事对象在自身改变的时候来通知中介者的方法 让中介者去负责相应的与其他同事对象的交互
	 */
	void changed(Colleague c);
}
