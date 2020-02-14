package designmode.structure.adapter;

/**
 * 电脑
 * @author 王浩
 *
 */
public class Computer {

	/**
	 * 可以读写SDCard
	 * @param card 卡
	 */
	public void readAndWriteSDCard(SDCard card) {
		card.readSDCard();
		card.writeSDCard();
	}
	
	/**
	 * 可以读写USBCard
	 * @param card 卡
	 */
	public void readAndWriteUSBCard(USBCardReader card) {
		card.readSDCard();
		card.writeSDCard();
		card.readMiniSDCard();
		card.writeMiniSDCard();
	}
	
	// 可以想到这么写，但不好
//	public void readAndWriteMini(KingstonMiniSDCard card) {
//		card.read();
//		card.write();
//	}
	
	// 我们需要做一个适配(转换)
	// MiniSDCard -- 适配 -- SDCard
	// 1.对象适配器
	// 2.类适配器
	// 3.缺省适配器(USB连接的万能读卡器)
	
}
