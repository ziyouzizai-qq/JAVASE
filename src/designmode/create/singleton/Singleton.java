package designmode.create.singleton;

/**
 * 设计模式之单例模式
 * 通过一系列设计
 * 让当前这个Singleton类
 * 只能创建唯一的对象
 * @author 王浩
 *
 */
public class Singleton {
	
	// 1.当前里构造方法私有 
	private Singleton() {}
	
	// 2.私有(防止被改变)且唯一
	private static Singleton obj1 = new Singleton();
	
	// 3.对外界开放
	public static Singleton getSingleton1() {
		return obj1;
	}
	
	// ------------------以上是饿汉式
	// 上面的写法最简单，但如果很长时间不用浪费内存
	
	// 懒加载
	// 双重检测模型的基础上添加一个volatile修饰属性
	// 目的是为了保证属性的创建及赋值过程不会产生指令重排序
	// 发送一行代码  new Sington(); ---> 指令
	//	memory =allocate();    1：分配对象的内存空间 
	//	ctorInstance(memory);  2：初始化对象
	//	instance =memory;      3：instance指向刚分配的内存地址，此时对象还未初始化
	private static volatile Singleton obj2 = null; // 没有创建对象
	
	//	memory =allocate();    1：分配对象的内存空间 
	//	instance =memory;      3：instance指向刚分配的内存地址，此时对象还未初始化
	//	ctorInstance(memory);  2：初始化对象
	//	ThreadA调用 getInstance()方法执行完了1和3两条指令，此时对象未初始化但是mIntance已经指向了一块内存区域；
	//	ThreadB此时进入getIntance()方法，判定mIntance引用不为空，直接返回。
	//	ThreadB就会使用到未初始化的实例对象，产生不可预期的错误.即这是一个残缺的对象。
	public static Singleton getSingleton2() {
		if (obj2 == null) {
			synchronized (Singleton.class) {
				if (obj2 == null) {
					obj2 = new Singleton();
				}
			}
		}
		return obj2;
	}
	// 这种写法解决了内存浪费问题
	// 但是存在线程问题
	
	
	
	
	// 栈内存溢出：StackOverflowError
//	public Singleton obj = new Singleton();	
	
	public static void main(String[] args) {
		new Singleton();
	}
	
}
