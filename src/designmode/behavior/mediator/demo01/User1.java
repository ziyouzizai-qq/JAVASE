package designmode.behavior.mediator.demo01;

/**
 * 具体用户1
 * @author 王浩
 *
 */
public class User1 extends User {

	public User1(Mediator mediator) {
		super(mediator);
	}

	@Override
	public void work() {
		System.out.println("user1 exe!");
	}

}
