package lambda;

/**
 * lambda表达式
 * 应用场景：1.匿名内部类  2.接口中只有一个抽象方法
 * @author 王浩
 *
 */
public class Demo01 {

	public static void main(String[] args) {
		// 多参数有返回值
		// 演示一：
		HelloService service01 = (String firstName, String lastName) -> {
			return "Hello " + firstName + " " +lastName;
		};
		System.out.println(service01.sayHello("hao", "wang"));
		// 演示二：参数类型不需要，根据参数列表顺序自动识别
		HelloService service02 = (firstName, lastName) -> {
			return "Hello " + firstName + " " +lastName;
		};
		System.out.println(service02.sayHello("hao", "wang"));
		// 演示三： 方法体多行代码，{}和return必须有
		HelloService service03 = (firstName, lastName) -> {
			System.out.println("...");
			return "Hello " + firstName + " " +lastName;
		};
		System.out.println(service03.sayHello("hao", "wang"));
		// 演示四： 方法体只有一行代码，{}不需要，return也不需要
		HelloService service04 = 
				(firstName, lastName) -> "Hello " + firstName + " " +lastName;
		System.out.println(service04.sayHello("hao", "wang"));
		
		
		
		// 多参数无返回值
		// 演示一：
//		HelloService service01 = (String firstName, String lastName) -> {
//			System.out.println("Hello " + firstName + " " +lastName);
//		};
//		service01.sayHello("hao", "wang");
//		// 演示二：参数类型不需要，根据参数列表顺序自动识别
//		HelloService service02 = (firstName, lastName) -> {
//			System.out.println("Hello " + firstName + " " +lastName);
//		};
//		service02.sayHello("hao", "wang");
//		// 演示三： 方法体多行代码，{}必须有
//		HelloService service03 = (firstName, lastName) -> {
//			System.out.println("...");
//			System.out.println("Hello " + firstName + " " +lastName);
//		};
//		service03.sayHello("hao", "wang");
//		// 演示四： 方法体只有一行代码，{}不需要
//		HelloService service04 = 
//				(firstName, lastName) -> System.out.println("Hello " + firstName + " " +lastName);
//		service04.sayHello("hao", "wang");	
		
		
		
		// 单参有返回值
		// 演示一：
//		HelloService service01 = (String name) -> {
//			return "Hello " + name;
//		};
//		System.out.println(service01.sayHello("world"));
//		// 演示二：参数类型不需要，根据参数列表顺序自动识别
//		HelloService service02 = (name) -> {
//			return "Hello " + name;
//		};
//		System.out.println(service02.sayHello("world"));
//		// 演示三：参数列表()不需要
//		HelloService service03 = name -> {
//			return "Hello " + name;
//		};
//		System.out.println(service03.sayHello("world"));
//		// 演示四：方法体多行代码，{}和return必须有
//		HelloService service04 = name -> {
//			System.out.println("...");
//			return "Hello " + name;
//		};
//		System.out.println(service04.sayHello("world"));
//		// 演示五：方法体只有一行代码，{}不需要，return也不需要
//		HelloService service05 = name -> "Hello " + name;
//		System.out.println(service05.sayHello("world"));
		
		
		
		// 单参无返回值
		// 演示一：
//		HelloService service01 = (String name) -> {
//			System.out.println("Hello " + name);
//		};
//		service01.sayHello("world");
//		// 演示二：参数类型不需要，根据参数列表顺序自动识别
//		HelloService service02 = (name) -> {
//			System.out.println("Hello " + name);
//		};
//		service02.sayHello("world");
//		// 演示三：参数列表()不需要
//		HelloService service03 = name -> {
//			System.out.println("Hello " + name);
//		};
//		service03.sayHello("world");
//		// 演示四：方法体多行代码，{}必须有
//		HelloService service04 = name -> {
//			System.out.println("...");
//			System.out.println("Hello " + name);
//		};
//		service04.sayHello("world");
//		// 演示五：方法体只有一行代码，{}不需要
//		HelloService service05 = name -> System.out.println("Hello " + name);
//		service05.sayHello("world");
		
	}

}
