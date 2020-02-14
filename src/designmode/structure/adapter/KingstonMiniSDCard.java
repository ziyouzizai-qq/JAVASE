package designmode.structure.adapter;

/**
 * Mini SD卡
 * @author 王浩
 *
 */
public class KingstonMiniSDCard implements MiniSDCard {

	// 读取
	public void readMiniSDCard() {
		System.out.println("读取MiniSD卡");
	}
	
	// 写入
	public void writeMiniSDCard() {
		System.out.println("写入MiniSD卡");
	}
}
