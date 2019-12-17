package keyword.superkey;

import java.lang.reflect.Field;

/**
 * 测试类
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) throws Exception {
		Son son01 = new Son();
		System.out.println(son01.getMoney());
		System.out.println("=========");
		Son son02 = new Son("xy",2000.0,"xm",18);
		
		System.out.println("=========");
		son01.setDna("xy");
		son01.setMoney(200.0);
		son01.setAge(new Integer(18));
		son01.setName("hao.wang");
		
		son02 = new Son();
		son02.setDna(son01.getDna());
		son02.setMoney(son01.getMoney());
		son02.setAge(son01.getAge());
		son02.setName(son01.getName());
		System.out.println(son01 == son02);
		// 两个不同对象中的成员变量引用指向同一个对象
		System.out.println(son01.getAge() == son02.getAge());
		System.out.println(son01.getDna() == son02.getDna());
		System.out.println(son01.getName() == son02.getName());
		System.out.println(son01.getMoney() == son02.getMoney());
		
		System.out.println("=========");
		// Integer常量池原因
		son02.setAge(new Integer(18));
		System.out.println(son01.getAge() == son02.getAge());
		// 由于son02的引用指向另一个对象，所以不一样
		son02.setAge(new Integer(20));
		System.out.println(son01.getAge() == son02.getAge());
		
		System.out.println("=========");
		// 两个引用指向同一个对象，设想改变该对象的值，是不是两个son所对应的变量值做出改变
		System.out.println(son01.getName() == son02.getName());
		// 可见是同一个引用，字符串由于底层是数组，private final char value[];
		// 定长而且被final修饰，所以不可变，但是我们可以通过强大的反射技术来修改字符串内容
		// 修改son01的name
		System.out.println(son01.getName());
		Class<?> clazz = son01.getName().getClass();
		Field value = clazz.getDeclaredField("value");
		value.setAccessible(true);
		char[] arr = (char[])value.get(son01.getName());
		arr[3] = 'S';
		System.out.println(son02.getName());
		System.out.println(son01.getName() == son02.getName());
		
		System.out.println("=========");
		Son son03 = new Son();
		son03.setDna("abc");
		Son son04 = son03;
		son04.setDna("dna");
		System.out.println(son03.getDna());
		System.out.println(son03 == son04);
		System.out.println(son03.getDna() == son04.getDna());
		System.out.println(son03.getDna().equals(son04.getDna()));
	}
	
}
