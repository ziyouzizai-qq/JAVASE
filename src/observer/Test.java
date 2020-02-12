package observer;

/**
 * 设计者模式-测试
 * JDK也对观察者模式进行封装
 * 		参考：java.util.Observable
 * 			  java.util.Observer
 * @author 王浩
 *
 */
public class Test {
	
	public static void main(String[] args) {
		NewsPaperOffice office = new NewsPaperOffice("新华社");
		ReaderOne one = new ReaderOne("读者甲");
		ReaderTwo two = new ReaderTwo("读者乙");
		ReaderThree three = new ReaderThree("读者丙");
//		one.readPaper(office);
//		two.readPaper(office);
//		three.readPaper(office);
		
		// 创建对象很麻烦（目前为止处理不了，以后可以通过Ioc设计思想）
		// 每一个对象都需要主动做事，读者多
		// 观察者设计思想
		// 观察者：读者
		// 当报社发报，自动read
		// 观察者(一堆)读者  目标对象(一个)报社
		office.addReaders(one);
		office.addReaders(two);
		office.addReaders(three);
		office.sendPaper();
	}
}
