package designmode.structure.flyweight;

/**
 * 非享元角色
 * 
 * @author 王浩
 *
 */
public class UnsharedConcreteFlyweight {

	private String info;

	public UnsharedConcreteFlyweight(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
