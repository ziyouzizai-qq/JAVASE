package keyword.superkey;

/**
 * 父类
 * @author 王浩
 *
 */
public class Father {

	private String dna;
	
	private Double money;
	
	public String getDna() {
		return dna;
	}

	public void setDna(String dna) {
		this.dna = dna;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Father() {
		System.out.println("调用父类的无参构造函数");
	}

	public Father(String dna, Double money) {
		super();
		this.dna = dna;
		this.money = money;
	}
	
	public void lenB(){
		System.out.println("LenB");
	}
	
}
