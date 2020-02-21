package designmode.behavior.visitor;

public interface Subject {

	// 接受将要访问它的对象
	void accept(Visitor visitor); 
	
	// 获取将要被访问的属性
    String getSubject();
}
