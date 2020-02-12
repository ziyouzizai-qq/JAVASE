package observer;

/**
 * 读者
 * @author 王浩
 *
 */
public class ReaderOne implements Reader {
	
	private String name;

	public ReaderOne(String name) {
		this.name = name;
	}
	
	// 读报纸
	public void readPaper(NewsPaper paper) {
		System.out.println(this.name + "读取了" + paper.getName());
	}
}