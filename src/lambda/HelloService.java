package lambda;

/**
 * 定义一个函数式接口
 * @FunctionalInterface 该注解用来规范该接口只能存在一个抽象方法
 * @author 王浩
 *
 */
@FunctionalInterface
public interface HelloService {
	
	// 多参数有返回值
	String sayHello(String firstName, String lastName);
	
	// 多参数无返回值
//	void sayHello(String firstName, String lastName);
	
	// 单参有返回值
//	String sayHello(String name);
	
	// 单参无返回值
//	void sayHello(String name);
	
	static void fn1(){
		// 支持静态方法存在
	}
	
	default void fn2(){
		// 支持默认方法存在
	}
	
}
