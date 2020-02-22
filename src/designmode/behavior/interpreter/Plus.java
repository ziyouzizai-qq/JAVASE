package designmode.behavior.interpreter;

/**
 * 具体表达式Plus
 * 
 * @author 王浩
 *
 */
public class Plus implements Expression {

	@Override
	public int interpret(Context context) {
		return context.getNum1() + context.getNum2();
	}

}
