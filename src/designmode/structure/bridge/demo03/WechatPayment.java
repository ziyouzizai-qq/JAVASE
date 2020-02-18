package designmode.structure.bridge.demo03;

/**
 * 微信支付
 * @author 王浩
 *
 */
public class WechatPayment extends Payment {

	@Override
	public void payment() {
		System.out.println("使用微信支付");
	}

}
