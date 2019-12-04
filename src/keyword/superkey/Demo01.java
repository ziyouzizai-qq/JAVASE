package keyword.superkey;

/**
 * 所有的子类都必须先初始化好父类的属性才能初始化自己的属性，也就是说
 * super()系列的方法调完之后才能初始化自己的属性
 * 
 * 如果父类在初始化中发现子类重写了自身的方法，自动调用子类的重写方法，
 * 因为编译的时候是this.test()，this这个对象指的就是子类对象
 * @author 王浩
 *
 */
public class Demo01 {

	public static void main(String[] args) {
		/**
		 * 继承过后，对象的实例化过程
		 */
		new Sub();
		
	}

}
class Sub extends Super{
	int a = 6;
	public Sub(){
		super();
		System.out.println("初始化完毕");
	}
	public void test(){
		// 由于父类还没有初始化完，所以a还没有赋上6，所以是默认值0
		System.out.println(a);
		// 由于父类的父类初始化完了，所以super.a为5
		System.out.println(super.a);
	}
}
class Super{
	// 如果a没有赋值，就不会调完super();赋值0
//	int a
	int a = 5;
	public Super(){
		super();
		// 调用重写方法
		test();
	}
	// 该方法不会调用
	public void test(){
		System.out.println("123");
	}
}