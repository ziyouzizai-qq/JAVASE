package keyword.superkey;

/**
 * 子类
 * 子类构造函数必定调用父类一种构造函数
 * @author 王浩
 *
 */
public class Son extends Father{
	

	private String name;

	private int age;
	
	public Son(){
//		super();
		// 构造子类的构造函数肯定会先调用父类的构造函数
		System.out.println("调用子类的无参构造函数");
	}

	public Son(String dna, Double money, String name, int age) {
//		super(dna, money);
//		this(dna,money,name);
		// 上面两行代码不能同时，不然父类构造函数调用两次
		// 尽管没写，默认调用父类无参构造
	}

	public Son(String dna, Double money, String name) {
		this(dna, money,18);
		this.name = name;
	}

	public Son(String dna, Double money, int age) {
		super(dna, money);
		this.age = age;
	}
	
	public void test(){
		// super也不能是调用父类私有的属性和方法
//		System.out.println(super.dna);
		lenB();
		// =>编译后
		//  this.lenB();也可以super.lenB();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
