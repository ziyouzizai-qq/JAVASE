package designmode.structure.bridge.demo03;

/**
 * 购买飞机票
 * @author 王浩
 *
 */
public class BuyAirTicket extends Buy {

	public BuyAirTicket(Provider provider) {
		super(provider);
	}

	@Override
	public void buy() {
		System.out.println("购买飞机票");
		getProvider().provider();
	}

}
