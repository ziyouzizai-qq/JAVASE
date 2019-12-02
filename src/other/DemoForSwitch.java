package other;

/**
 * JavaSE基础注意点：switch - case
 * @author 王浩
 *
 */
public class DemoForSwitch {

	public static void main(String[] args) {
		Integer i = 1;
		switch (i) {
		case 1:
			System.out.println("1");
			// 注意一定要break，不然不会停下，直到运行到break或者程序结束
//			break;
		case 2:
			System.out.println("2");
			break;
		case 3:
			System.out.println("3");
			break;
					
		default:
			System.out.println("default");
			break;
		}
	}

}
