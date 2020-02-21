package designmode.behavior.responsibilitychain.chain.demo02;

public abstract class AbstractHandler {

	private Handler handler;  
	  
    public Handler getHandler() {  
        return handler;  
    }  
  
    public void setHandler(Handler handler) {  
        this.handler = handler;  
    }
}
