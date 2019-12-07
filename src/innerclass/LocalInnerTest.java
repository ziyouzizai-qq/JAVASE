package innerclass;

/**
 * 局部内部类(这种写法不常见)
 * @author 王浩
 *
 */
public class LocalInnerTest {
	
	private String str1;
	
	private static String str2;
	
	public void method(){
		/**
		 * 局部内部类(和局部变量一个等级)
		 * 1.不能使用访问控制修饰符（public、private 和 protected）和 static 修饰符修饰。
		 * 试想一下：局部变量能用这些修饰符吗？
		 * 2.局部内部类只在当前方法中有效。
		 * 3.局部内部类中不能定义 static 成员。
		 * 4.局部内部类中还可以包含内部类，但是这些内部类也不能使用访问控制修饰符（public、 private 和 protected）
		 * 	 和 static 修饰符修饰
		 * 5.在局部内部类中可以访问外部类的所有成员。
		 * 6.在局部内部类中只可以访问当前方法中 final 类型的参数与变量。如果方法中的成员与外部类中的成员同名，
		 * 	 则可以使用 <OuterClassName>.this.<MemberName> 的形式访问外部类中的成员。
		 * @author 王浩
		 *
		 */
		class Inner {
			private String a;
		}
	}
	

	public static void main(String[] args) {
		class Inner {
			private Inner i;
		}
	}

}
