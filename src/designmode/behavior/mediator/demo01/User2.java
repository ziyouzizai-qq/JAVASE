package designmode.behavior.mediator.demo01;

/**
 * 具体用户2
 * @author 王浩
 *
 */
public class User2 extends User {

	public User2(Mediator mediator) {
		super(mediator);
	}

	@Override
	public void work() {
		System.out.println("user2 exe!");
	}

}
