package designmode.behavior.responsibilitychain.chain.demo02;

/**
 * 责任链模式测试
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) {
		MyHandler handler1 = new MyHandler("1");
		MyHandler handler2 = new MyHandler("2");
		MyHandler handler3 = new MyHandler("3");
		handler1.setHandler(handler2);
		handler2.setHandler(handler3);
		handler1.operator();
	}

}
