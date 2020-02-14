package designmode.structure.adapter;

/**
 * 外部转换器
 * 实现好多规则
 * 具体的卡去选择性的挑选，自己去实现
 * @author 王浩
 *
 */
public abstract class USBCardReader implements SDCard,MiniSDCard {

	// 默认全是空方法
	public void readSDCard() {
		
	}
	
	public void writeSDCard() {
		
	}
	
	public void readMiniSDCard() {
		
	}
	
	public void writeMiniSDCard() {
		
	}
}
