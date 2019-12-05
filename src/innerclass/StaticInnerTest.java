package innerclass;

/**
 * 静态内部类(不需要依附外部类)
 * static来修饰一个内部类,则这个内部类就属于外部类本身,不属于外部类对象.
 * 所以用static修饰的内部类被称为静态内部类.
 * 
 * static关键字不可修饰外部类，但可修饰内部类。
 * @author 王浩
 *
 */
public class StaticInnerTest {
	private int prop1 = 5;
	private static int prop2 = 9;
	
	public void test01(){
		System.out.println("test");
		// 外部类依然不能直接访问静态内部类的成员，但可以使用静态内部类的类名
		// 作为调用者来访问静态内部类的类成员，也可以使用静态内部类对象作为调用
		// 者来访问静态内部类的实例成员。
		System.out.println(Inner.age);
		System.out.println(new Inner().name);
		new Inner().accessOuterProp();
	}
	
	public static void test02(){
		System.out.println(Inner.age);
		System.out.println(new Inner().name);
	}
	
	public static class Inner {
		//静态内部类可以包含静态成员，也可以包含非静态成员。
		private String name;
		private static int age;
		public void accessOuterProp() {
			// 下面代码出现错误：
			// 静态内部类无法访问外部类的实例变量，同理，成员方法也一样
//			System.out.println(prop1);
//			test01();
			// 下面代码正常，只能访问静态成员
			System.out.println(prop2);
		}
	}

}
