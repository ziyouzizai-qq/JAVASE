package designmode.structure.adapter;

public class USBCard extends USBCardReader {

	public void readSDCard() {
		System.out.println("读取USBCard");
	}
	
	public void writeSDCard() {
		System.out.println("写入USBCard");
	}
	
	public void readMiniSDCard() {
		System.out.println("读取USBMiniCard");
	}
}
