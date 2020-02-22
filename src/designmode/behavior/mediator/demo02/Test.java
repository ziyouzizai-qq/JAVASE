package designmode.behavior.mediator.demo02;

/**
 * 中介者测试
 * @author 王浩
 *
 */
public class Test {

	public static void main(String[] args) {
		// 主板(中介者)
		MainBoard mediator = new MainBoard();
		
		// 创建同事类
		// 光驱，注入中介者
		CDDriver cdDriver = new CDDriver(mediator);
		// CPU，注入中介者
		CPU cpu = new CPU(mediator);
		// 显卡，注入中介者
		VideoCard videoCard = new VideoCard(mediator);
		// 声卡，注入中介者
		AudioCard audioCard = new AudioCard(mediator);
		
		// 中介者注入其他同事
		mediator.setCdDriver(cdDriver);
		mediator.setCpu(cpu);
		mediator.setVideoCard(videoCard);
		mediator.setAudioCard(audioCard);
		
		cdDriver.readCD("Hello,World！");
	}

}
