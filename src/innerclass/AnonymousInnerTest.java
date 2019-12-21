package innerclass;

/**
 * 匿名内部类
 * @author 王浩
 *
 */
public class AnonymousInnerTest {

	public static void test01(AA a) {
		a.aa();
	}
	
	public static void main(String[] args) {
		test01(new AA() {
			@Override
			public void aa() {
				System.out.println("TestAnonymousInnerClass.main(...).new AA() {...}.aa()");
			}
			
		});		
	}

}

interface AA{ 
	void aa();
}