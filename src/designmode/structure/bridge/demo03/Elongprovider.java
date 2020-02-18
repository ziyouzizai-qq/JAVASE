package designmode.structure.bridge.demo03;

/**
 * 艺龙
 * @author 王浩
 *
 */
public class Elongprovider extends Provider {
	
	public Elongprovider(Payment payment) {
	    super(payment);
	}

	@Override
	public void provider() {
		System.out.println("在艺龙下订单");
	    getPayment().payment();
	}

}
