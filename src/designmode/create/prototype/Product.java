package designmode.create.prototype;

/**
 * 接口实现Cloneable接口，实现标记接口，实现的子类实例可使用clone方法
 * @author 王浩
 *
 */
public interface Product extends Cloneable {

	void use(String s);
	
	Product creactClone();
}
