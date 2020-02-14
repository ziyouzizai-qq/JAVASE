package designmode.structure.adapter;

/**
 * SD卡
 * @author 王浩
 *
 */
public class KingstonSDCard implements SDCard {

	// 读取
	public void readSDCard() {
		System.out.println("读取SD卡");
	}
	
	// 写入
	public void writeSDCard() {
		System.out.println("写入SD卡");
	}
}
