package designmode.structure.bridge.demo03;

/**
 * 携程
 * @author 王浩
 *
 */
public class CtripProvider extends Provider {

	public CtripProvider(Payment payment) {
		super(payment);
	}

	@Override
	public void provider() {
		System.out.println("在携程下单");
		getPayment().payment();
	}

}
