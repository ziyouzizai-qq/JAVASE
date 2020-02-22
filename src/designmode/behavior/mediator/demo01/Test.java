package designmode.behavior.mediator.demo01;

/**
 * 中介者模式测试
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) {
		Mediator mediator = new MyMediator();  
        mediator.createMediator();  
        mediator.workAll();
	}

}
