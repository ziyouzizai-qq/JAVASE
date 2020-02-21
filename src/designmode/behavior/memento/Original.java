package designmode.behavior.memento;

/**
 * 原始类
 * @author 王浩
 *
 */
public class Original {

	private String value;  
    
    public String getValue() {  
        return value;  
    }  
  
    public void setValue(String value) {  
        this.value = value;  
    }  
  
    public Original(String value) {  
        this.value = value;  
    }  
  
    /**
     * 创建一个备忘录类
     * @return 备忘录对象
     */
    public Memento createMemento(){  
        return new Memento(value);  
    }  
    
    /**
     * 重新从备忘录里面获取值
     * @param memento
     */
    public void restoreMemento(Memento memento){  
        value = memento.getValue();  
    }  
}
