package designmode.create.prototype;

public class MessageBox implements Product {

	private char decochar;

	public MessageBox(char decochar) {
		// TODO Auto-generated constructor stub
		this.decochar = decochar;
	}

	@Override
	public void use(String s) {
		// TODO Auto-generated method stub
		int lenght = s.getBytes().length;
		for (int i = 0; i < lenght + 4; i++) {
			System.out.print(decochar);
		}
		System.out.println("");
		System.out.println(decochar + "" + s + "" + decochar);
		for (int i = 0; i < lenght + 4; i++) {
			System.out.print(decochar);
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
