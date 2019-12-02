package lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * lambda表达式
 * 应用场景：集合类
 * @author 王浩
 *
 */
public class Demo02 {

	public static void main(String[] args) {
		// 三种常用集合类
		// list
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.forEach(v -> System.out.println(v));
		
		System.out.println("=============");
		
		// set
		Set<String> set = new HashSet<String>();
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("4");
		set.add("5");
		set.forEach(v -> System.out.println(v));
		
		System.out.println("=============");
		
		// map
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");
		map.put("4", "four");
		map.put("5", "five");
		map.forEach((k, v) -> System.out.println(k + ":" + v));
		map.keySet().forEach(k -> 
			System.out.println(map.get(k))
		);
	}

}
