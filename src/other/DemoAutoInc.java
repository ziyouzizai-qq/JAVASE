package other;

/**
 * JavaSE基础注意点：自动递增和递减
 * @author 王浩
 *
 */
public class DemoAutoInc {

	public static void main(String[] args) {
		int i = 1;
		// 优先级问题
		System.out.println("i :" + i);
		System.out.println("++i :" + ++i); // Pre-increment
		System.out.println("i++ :" + i++); // Post-increment
		System.out.println("i :" + i);
		System.out.println("--i :" + --i); // Pre-decrement
		System.out.println("i-- :" + i--); // Post-decrement
		System.out.println("i :" + i);
	}

}
