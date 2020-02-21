package designmode.behavior.command;

/**
 * 命令的具体实现
 * @author 王浩
 *
 */
public class MyCommand implements Command {
	
	private Receiver receiver;  
    
    public MyCommand(Receiver receiver) {  
        this.receiver = receiver;  
    }  

	@Override
	public void exe() {
		receiver.action();
	}

}
