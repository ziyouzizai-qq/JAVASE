package designmode.behavior.observer.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * 报社
 * @author 王浩
 *
 */
public class NewsPaperOffice {
	
	private String name;
	

	public String getName() {
		return name;
	}


	public NewsPaperOffice(String name) {
		this.name = name;
	}
	
	//===============================
	// 1.改变报社和读者的关系
	private List<Reader> readers = new ArrayList<Reader>();
	// 2.增删读者
	public void addReaders(Reader reader) {
		readers.add(reader);
	}

	public void removeReaders(Reader reader) {
		readers.remove(reader);
	}
	
	// 4.通知所有的观察者去做自己该做的事情(读报纸)
	public void notifyReader(NewsPaper paper) {
		readers.forEach(reader -> {
			reader.readPaper(paper);
		});
	}
	//===============================

	// 生产 刊发报纸
	public void sendPaper(){
		System.out.println(this.name + "报社发报纸了");
		NewsPaper paper = new NewsPaper("人民日报");
		notifyReader(paper);
	}
}
