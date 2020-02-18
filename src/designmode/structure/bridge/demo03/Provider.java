package designmode.structure.bridge.demo03;

/**
 * 售票平台
 * 
 * @author 王浩
 *
 */
public abstract class Provider {

	// 平台售票是不是可以有不同方式支付
	private Payment payment;

	public Provider(Payment payment) {
		setPayment(payment);
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public abstract void provider();
}
