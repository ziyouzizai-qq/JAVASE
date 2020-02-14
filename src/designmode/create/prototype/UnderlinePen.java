package designmode.create.prototype;

public class UnderlinePen implements Product {
	
	private String str;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	private char ulchar;

	public UnderlinePen(char ulchar) {
		// TODO Auto-generated constructor stub
		this.ulchar = ulchar;
	}

	@Override
	public void use(String s) {
		// TODO Auto-generated method stub
		int lenght = s.getBytes().length;
		System.out.println("\"" + s + "\"");
		for (int i = 0; i < lenght; i++) {
			System.out.print(ulchar);
		}
		System.out.println("");

	}

	@Override
	public Product creactClone() {
		// TODO Auto-generated method stub
		Product p = null;
		try {
			p = (Product) clone();
		} catch (CloneNotSupportedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return p;
	}

}
