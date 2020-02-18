package designmode.structure.proxy.dynamic.jdk;

import java.util.Random;

/**
 * 2. 真实主题
 * @author 王浩
 *
 */
public class Car implements Moveable {

	@Override
	public void move() throws Exception {
		Thread.sleep(new Random().nextInt(1000));  
        System.out.println("汽车行驶中…");  
	}

}
