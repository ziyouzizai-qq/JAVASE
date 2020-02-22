package designmode.behavior.mediator.demo01;

/**
 * 抽象用户类
 * @author 王浩
 *
 */
public abstract class User {

	private Mediator mediator;  
    
    public Mediator getMediator(){  
        return mediator;  
    }  
      
    public User(Mediator mediator) {  
        this.mediator = mediator;  
    }  
  
    public abstract void work();
}
