package designmode.behavior.observer.demo02;

import java.util.Observable;
import java.util.Observer;

public class JingDongObserver implements Observer {

	@Override
	public void update(Observable o, Object product) {
		String newProduct = (String) product;
		System.err.println("�����²�Ʒ��"+ newProduct +"��ͬ���������̳�");
	}

}
