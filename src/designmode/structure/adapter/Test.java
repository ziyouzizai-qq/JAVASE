package designmode.structure.adapter;

/**
 * 设计模式-适配器模式 测试
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) {
		System.out.println("====对象适配器测试====");
		// 1.创建一个电脑
		Computer computer = new Computer();
		// 2.创建一张SDCard
		KingstonSDCard SDCard = new KingstonSDCard();
		// 3.电脑做事，读取SDCard
		computer.readAndWriteSDCard(SDCard);
		
		MiniSDCard miniSDCard = new KingstonMiniSDCard();
		// 做一个适配器(转换器)
		CoverForMiniSDCard cover = new CoverForMiniSDCard(miniSDCard);
		computer.readAndWriteSDCard(cover);
		
		System.out.println("====类适配器测试====");
		// 类适配器测试
		SDCard special = new SpecialMiniSDCard();
		computer.readAndWriteSDCard(special);
		
		System.out.println("====缺省适配器测试====");
		// 缺省适配器测试
		USBCardReader usbCard = new USBCard();
		computer.readAndWriteUSBCard(usbCard);
	}

}
