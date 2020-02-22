package designmode.behavior.mediator.demo02;

/**
 * 显卡类，一个同事类
 * @author 王浩
 *
 */
public class VideoCard extends Colleague {

	public VideoCard(Mediator mediator) {
		super(mediator);
	}

	/**
	 * 显示视频数据
	 */
	public void display(String data) {
		System.out.println("您正在观看的是：" + data);
	}
}
