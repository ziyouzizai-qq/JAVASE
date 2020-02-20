package designmode.behavior.strategy.demo01;

/**
 * 策略模式测试
 * @author 王浩
 *
 */
public class Test {
	
	public static void main(String[] args) {
        Context context;

        System.out.println("操作工1准备开工-------------");
        context = new Context(new Worker1());
        context.operate();

        System.out.println("操作工2准备开工-------------");
        context = new Context(new Worker2());
        context.operate();

        System.out.println("操作工3准备开工-------------");
        context = new Context(new Worker3());
        System.out.println(context.add(3,3));

    }

}
