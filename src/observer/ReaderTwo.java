package observer;

/**
 * 读者
 * @author 王浩
 *
 */
public class ReaderTwo implements Reader {
	
	private String name;

	public ReaderTwo(String name) {
		this.name = name;
	}
	
	// 读报纸
	public void readPaper(NewsPaper paper) {
		System.out.println(this.name + "不读取" + paper.getName());
	}
}