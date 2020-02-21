package designmode.behavior.templatemethod;

/**
 * 模板方法模式测试
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) {
		AbstractCalculator plus = new Plus();
		System.out.println(plus.calculate("1.2", "\\.")); // 3
	}

}
