package designmode.structure.bridge.demo03;

/**
 * 购买火车票
 * @author 王浩
 *
 */
public class BuyTrainTicket extends Buy {

	public BuyTrainTicket(Provider provider) {
		super(provider);
	}

	@Override
	public void buy() {
		System.out.println("购买火车票");
	    getProvider().provider();
	}

}
