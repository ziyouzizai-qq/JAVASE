package innerclass;

/**
 * 测试内部类访问权限
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) {
		// 测试一(成员内部类)
		Outer outer = new Outer();
		System.out.println(outer.getTime());
//		Outer.Inner inner = outer.new Inner();
//		System.out.println(inner.stackOverflow());
	}

}
