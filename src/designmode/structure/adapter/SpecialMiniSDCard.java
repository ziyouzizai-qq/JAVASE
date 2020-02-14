package designmode.structure.adapter;

/**
 * 特别的小卡
 * @author 王浩
 *
 */
public class SpecialMiniSDCard extends KingstonMiniSDCard implements SDCard{

	// 一张特别的小卡，所以继承
	// 特别体现在可以折叠，折叠后根大卡一样
	
	@Override
	public void readSDCard() {
		this.readMiniSDCard();
	}

	@Override
	public void writeSDCard() {
		this.writeMiniSDCard();
	}

	
}
