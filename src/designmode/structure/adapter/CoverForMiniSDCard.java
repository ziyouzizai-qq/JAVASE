package designmode.structure.adapter;

/**
 * Mini卡的适配器
 * @author 王浩
 *
 */
public class CoverForMiniSDCard implements SDCard {

	// 适配的对象
	private MiniSDCard miniSDCard;
	
	
	public CoverForMiniSDCard(MiniSDCard miniSDCard) {
		this.miniSDCard = miniSDCard;
	}

	@Override
	public void readSDCard() {
		miniSDCard.readMiniSDCard();
	}

	@Override
	public void writeSDCard() {
		miniSDCard.writeMiniSDCard();
	}

	
}
