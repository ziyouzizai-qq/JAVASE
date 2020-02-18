package designmode.structure.bridge.demo03;

/**
 * 测试
 * 
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) {
		// 加载支付方式
		Payment wp = new WechatPayment(); // 微信支付
		Payment ap = new AliPayment(); // 支付宝支付

		// 加载供应商，配置不同的支付方式
		Provider ctripWp = new CtripProvider(wp); // 携程
		Provider ctripAp = new CtripProvider(ap); 
		Provider elongWp = new Elongprovider(wp); // 艺龙
		Provider elongAp = new Elongprovider(ap);

		// 加载购票种类，配置不同的供应商
		Buy buyTcw = new BuyTrainTicket(ctripWp); // 买火车票
		Buy buyTca = new BuyTrainTicket(ctripAp);
		Buy buyTew = new BuyTrainTicket(elongWp); // 买机票
		Buy buyTea = new BuyTrainTicket(elongAp);

		Buy buyAcw = new BuyAirTicket(ctripWp);
		Buy buyAca = new BuyAirTicket(ctripAp);
		Buy buyAew = new BuyAirTicket(elongWp);
		Buy buyAea = new BuyAirTicket(elongAp);

		System.out.println("-------*******************-------");
		buyTcw.buy();
		System.out.println("-------*******************-------");
		buyTca.buy();
		System.out.println("-------*******************-------");
		buyTew.buy();
		System.out.println("-------*******************-------");
		buyTea.buy();
		System.out.println("-------*******************-------");
		buyAcw.buy();
		System.out.println("-------*******************-------");
		buyAca.buy();
		System.out.println("-------*******************-------");
		buyAew.buy();
		System.out.println("-------*******************-------");
		buyAea.buy();
		System.out.println("-------*******************-------");

	}
}
