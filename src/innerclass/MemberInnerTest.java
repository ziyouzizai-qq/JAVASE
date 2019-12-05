package innerclass;

/**
 * 一个类可以定义在另外一个类的内部，定义在类内部的类称之为Inner，其所在的类称为Outer；
 * 成员内部类(依附于外部类，唇亡齿寒的关系)
 * 
 * java类加载时，先执行加载外部类，再加载内部类，最后初始化内部类中的变量。
 * java中要加载内部类必须在实例化外部类之后完成，而这个时候如果内部类中的变量
 * 是静态的就会在外部类加载时被提前初始化。这与先实例化外部类对象相矛盾
 * 
 * 因此外部类不可以用静态方法获取成员内部类对象
 * 
 * 而java常量放在内存中常量池，它的机制与变量是不同的，编译时，
 * 加载常量是不需要加载类的，所以就没有上面那种矛盾。
 * @author 王浩
 *
 */
public class MemberInnerTest {
	
	private int time;
	
	public static int age = 18;
	
	public static final String GET = "GET";
	
	private static String getConst(){
		return GET;
	}
	
	public int getTime() {
		return time;
//		Inner inner = new Inner();
//		return inner.stackOverflow();
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public String getName() {
		// 外部类按照常规的类访问方式使用内部类，唯一的差别是
		// 外部类可以访问成员内部类的所有方法与属性，包括私有方法与属性。
		return new Inner().name;
	}
	
	/**
	 * 对外开放获取内部类的方法
	 * @return 内部类对象
	 */
	public Inner getInner() {
		// 外部类不管内部类权限，直接new对象
		return new Inner();
	}

	/**
	 * 成员内部类编译后的名字：Outer$Inner，和外部类在同一目录下
	 * 和成员变量同级别，则叫成员内部类
	 * 
	 * 权限设置： private 只能外部类使用
	 *           public 可以通过外部类对象获取内部类对象(参照Test类测试一)
	 */
	private class Inner {
		// 内部类中变量名如果和外部类成员变量一样,默认this.自身变量
		private int time;
		
		/**
		 * 成员内部类是非静态的。所以在成员内部类中，不能定义静态字段、静态方法和静态内部类，
		 * 因为成员内部类需要先创建外部类的实例对象，才能创建自己的对象；但是可以定义非静态字段、
		 * 非静态方法和非静态内部类。
		 */
//		public static int age = 18;
		
		private String name = "hao.wang";
		
		// 成员内部类可以定义静态常量的
		public static final String POST = "POST";
		
		public void timeInc() {
			// 内部类time 和外部类一致，可以通过以下方式访问
			MemberInnerTest.this.time++;
			// 内部类可以调用外部类private修饰的变量
			time++;
			// => Outer.class编译后如下
//			Outer.this.time++;
			// => Outer$Inner.class编译后如下
//			Outer.access$1(this.this$0, Outer.access$0(this.this$0) + 1);
			// 由此可以得出，当内部类访问外部类private变量或方法时，都是Outer.access$X方式打开访问权限
		}
		
		public String getName() {
			return name;
		}

		// Outer.this这种通过外部类获取对象来调用所对应的方法只会在有内部类的情况才能点出this
		public int stackOverflow() {
			return getTime();
			// => Outer.class编译后如下
//			return Outer.this.getTime();
			// => Outer$Inner.class编译后如下
//			return this.this$0.getTime();
		}
		
		private void test() {
			// 内部类是可以调用外部类的静态方法的，因为静态方法在初始化就已经存在了
			System.out.println(getConst());
			// => Outer.class编译后如下
//			System.out.println(Outer.getConst());
			// => Outer$Inner.class编译后如下
//			System.out.println(Outer.access$2());
		}
	}
	
	/**
	 * 进行测试
	 */
	public static void main(String[] args) {
		MemberInnerTest outer = new MemberInnerTest();
		System.out.println(outer.getTime());
		// 内部类对象必须依附外部类
		MemberInnerTest.Inner inner = outer.new Inner();
		// => 编译后(这里编译还是很难理解的)
//		Outer.Inner inner = outer.new Inner((Outer.Inner)null);
		System.out.println(inner.stackOverflow());
		
		// 其实上面这种方式获取内部类对象的方式不易理解，可以在外部类添加方法
		inner = outer.getInner();
		// 定义内部类就是专门为外部类服务的，一般都是private修饰的，
		// 可以看出内部类的方法没有在外部类中调用会报警告
	}

}
