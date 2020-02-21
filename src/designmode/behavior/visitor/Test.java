package designmode.behavior.visitor;

/**
 * 访问者模式测试
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) {
		// 受访问对象
		Subject sub = new MySubject();
		// 访问者
		Visitor visitor = new MyVisitor();
		
		sub.accept(visitor);
	}
}
