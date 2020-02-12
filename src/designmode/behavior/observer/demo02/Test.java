package designmode.behavior.observer.demo02;

public class Test {

	public static void main(String[] args) {
		ProductList observable = ProductList.getInstance();
		TaoBaoObserver tb = new TaoBaoObserver();
		JingDongObserver jd = new JingDongObserver();
		observable.addObserver(tb);
		observable.addObserver(jd);
		observable.addProduct("新增产品1");
	}

}
