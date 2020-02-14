package designmode.create.prototype;

public class Test {

	public static void main(String[] args) {
        //创建manager实例，完成实例注册
        Manager manager = new Manager();
        UnderlinePen uPen = new UnderlinePen('~');
        uPen.setStr(new String("hao.wang"));
        MessageBox mBox1 = new MessageBox('*');
        MessageBox mBox2 = new MessageBox('/');
        manager.register("strong name", uPen);
        manager.register("warning box", mBox1);
        manager.register("slash box", mBox2);

        //通过注册信息中的实例复制实例，然后才能使用实例功能
        Product p1 = manager.create("strong name");
        p1.use("hello world");
        Product p2 = manager.create("warning box");
        p2.use("hello world");
        Product p3 = manager.create("slash box");
        p3.use("hello world");
        System.out.println(p1);
        System.out.println(uPen);
        UnderlinePen p11 = (UnderlinePen) p1;
        System.out.println(p1.equals(p11));
        // 浅克隆：对象不一样但是里面的属性对象还是指的同一个
        // 深克隆和浅克隆在设计模式中不详细说明。
        System.out.println(p11.getStr() == uPen.getStr());
	}

}
