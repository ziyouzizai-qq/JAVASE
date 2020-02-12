package designmode.behavior.observer.demo01;

/**
 * 读者
 * @author 王浩
 *
 */
public class ReaderThree implements Reader {
	
	private String name;

	public ReaderThree(String name) {
		this.name = name;
	}
	
	// 读报纸
	public void readPaper(NewsPaper paper) {
		System.out.println(this.name + "随便读取" + paper.getName());
	}
}