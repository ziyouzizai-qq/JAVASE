package number;

/**
 * 自动拆装箱
 * Java1.5推出的特性
 * @author 王浩
 *
 */
public class DemoForInteger {

	public static void main(String[] args) {
		int i = 1;
		// 自动装箱(编译后代码为Integer.valueOf(i))
		Integer integer = i;
		// 自动拆箱(编译后为i = integer.intValue())
		// 疑问一：下面这行代码被编译后是int i = integer;并未调用intValue方法
		i = integer;
		// 疑问二：下面自动拆装箱编译后是直接赋值的
		double d = 1.0;
		Double db = d;
		d = db;
	}
}
