package map.hashmap.grammar;

/**
 * grammar包下主要是将源码有点意思的部分语法抽出来
 * 便于理解
 * @author 王浩
 *
 */
public class DemoForTest01 {

	public static void main(String[] args) {
		for (Integer x = 0,next; x != 8; x = next) {
			next = ++x;
			System.out.println(next);
		}

	}

}
