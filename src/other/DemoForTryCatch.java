package other;

/**
 * JavaSE基础注意点：try - catch
 * @author 王浩
 *
 */
public class DemoForTryCatch {

	public static void main(String[] args) {
		System.out.println("Begin...");
		try {
			System.out.println("befor i");
			// try作用域中发生异常以下的代码不执行
			int i = 1/0;
			System.out.println("after i");
		} catch (Exception e) {
			System.out.println("catch到异常");
		} finally {
			System.out.println("finally");
		}
		System.out.println("End...");
	}

}
