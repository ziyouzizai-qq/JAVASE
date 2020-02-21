package designmode.behavior.memento;

/**
 * 备忘录类
 * @author 王浩
 *
 */
public class Memento {

	private String value;  
	  
    public Memento(String value) {  
        this.value = value;  
    }  
  
    public String getValue() {  
        return value;  
    }  
  
    public void setValue(String value) {  
        this.value = value;  
    }
}
