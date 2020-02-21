package designmode.behavior.command;

/**
 * 调用者（司令员）
 * @author 王浩
 *
 */
public class Invoker {

	private Command command;  
    
    public Invoker(Command command) {  
        this.command = command;  
    }  
  
    public void action(){  
        command.exe();  
    } 
}
