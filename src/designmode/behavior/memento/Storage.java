package designmode.behavior.memento;

/**
 * 存储备忘录的类，持有Memento类的实例
 * @author 王浩
 *
 */
public class Storage {

	private Memento memento;  
    
    public Storage(Memento memento) {  
        this.memento = memento;  
    }  
  
    public Memento getMemento() {  
        return memento;  
    }  
  
    public void setMemento(Memento memento) {  
        this.memento = memento;  
    }
}
