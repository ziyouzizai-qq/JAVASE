package designmode.structure.bridge.demo03;

/**
 * 支付宝支付
 * @author 王浩
 *
 */
public class AliPayment extends Payment {

	@Override
	public void payment() {
		System.out.println("支付宝支付");
	}

}
