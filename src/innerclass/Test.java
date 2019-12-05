package innerclass;

// 直接获取静态内部类(不需要依附于外部类)
import innerclass.StaticInnerTest.Inner;

/**
 * 测试内部类访问权限
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) {
		// 测试一(成员内部类)
		MemberInnerTest memberInner = new MemberInnerTest();
		System.out.println(memberInner.getTime());
//		Outer.Inner inner = memberInner.new Inner();
//		System.out.println(inner.stackOverflow());
		
		// 测试二(静态内部类)
		Inner inner = new Inner();
		StaticInnerTest staticInner = new StaticInnerTest();
		new StaticInnerTest.Inner();
		
		// 总结：成员内部类和静态内部类直接用静态的和非静态的思想去理解
		// 唯一有争议的是外部类和内部类互相访问，需要多多的斟酌
	}

}
