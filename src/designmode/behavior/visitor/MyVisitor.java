package designmode.behavior.visitor;

/**
 * 存放要访问的对象
 * @author 王浩
 *
 */
public class MyVisitor implements Visitor {

	@Override
	public void visit(Subject sub) {
		System.out.println("visit the subject："+sub.getSubject());
		// 不能调，死循环，造成栈溢出
//		sub.accept(this);
	}

}
