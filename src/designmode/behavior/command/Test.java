package designmode.behavior.command;

/**
 * 命令模式测试
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) {
		// 士兵
		Receiver receiver = new Receiver();
		// 命令
		Command command = new MyCommand(receiver);
		// 司令员
		Invoker invoker = new Invoker(command);
		invoker.action(); // 发号命令
	}

}
