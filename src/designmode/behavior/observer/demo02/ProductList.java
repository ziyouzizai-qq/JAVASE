package designmode.behavior.observer.demo02;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式
 * 这个demo还是有问题的
 * 	1.ProductList单例写法，参考单例懒加载
 * 	2.addProduct调试有疑惑，输出语句有黑色并非第一行的情况，有多线程问题
 *
 */
public class ProductList extends Observable {

	// 产品列表
	private List<String> productList = null;
	
	// 类唯一实例
	private static ProductList instance;
	
	private ProductList() {}
	
	/**
	 * 取得唯一实例
	 * @return 产品列表唯一实例
	 */
	public static ProductList getInstance(){
		if (instance == null){
			instance = new ProductList();
			instance.productList = new ArrayList<String>();
		}
		return instance;
	}
	
	/**
	 * 增加观察者
	 * @param observer 观察者
	 */
	public void addProductListObservable(Observer observer){
		this.addObserver(observer);
	}
	
	/**
	 * 新增产品
	 * @param newProduct 新产品
	 */
	public void addProduct(String newProduct){
		productList.add(newProduct);
		System.out.println("产品列表新增了产品：" + newProduct);
		this.setChanged(); // 设置被观察对象发生变化
		this.notifyObservers(newProduct);// 通知观察者，并传递新产品
	}
}
