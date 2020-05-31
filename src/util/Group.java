package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import util.ex.IsEmptyExeception;

/**
 * 工具类Group
 * @author 王浩
 * 说明：线程不安全
 * 
 * 遗留问题:1.不能查询父类属性
 * @param <T>
 */
public class Group<T> {
	
	private final SimplePropertyPreFilter simplePropertyPreFilter;
	
	private final Class<T> clazz;
	
	private final Map<String, Boolean> fields = new ConcurrentHashMap<String, Boolean>();
	
//	private final Map<String, Boolean> fields = new HashMap<String, Boolean>();
	
	
	public Group(Class<T> clazz,String ... args) {
		super();
		// 构造器中必须指明类型
		if (Objects.isNull(clazz)) {
			throw new NullPointerException();
		}
		// 允许构造器初期化的属性注入，排除null和空字符，包括已存在map中
		setFields(args);
		this.clazz = clazz;
		// fastjson 属性过滤器，指明只生成上面
		simplePropertyPreFilter = new SimplePropertyPreFilter(this.clazz, fields.keySet().toArray(new String[fields.size()]));
	}

	/**
	 * 根据属性分组
	 * @param arr
	 * @param args
	 * @return
	 */
	public Map<String, List<T>> groupsByField(T[] arr, String ... args) {
		if (Objects.isNull(arr) || arr.length < 1) {
			throw new IsEmptyExeception("Target Array");
		}
		if (fields.isEmpty() && (Objects.isNull(args) || args.length < 1)) {
			throw new IsEmptyExeception("Field");
		} else {
			setFields(args);
		}

		checkFieldsAndPropertyPreFilterClean();
		
//		fieldsSynToIncludes();
		
		Map<String, List<T>> map = new HashMap<String, List<T>>();
		for (T dat : arr) {
			String key = makeKeyByJsonString(dat);
			List<T> list;
			if (map.containsKey(key)) {
				list = map.get(key);
				list.add(dat);
			} else {
				list = new ArrayList<T>();
				list.add(dat);
				map.put(key, list);
			}
		}
		return map;
	}
	
	/**
	 * 找出目标数组中与dat元素一组的数据
	 * @param dat
	 * @param arr
	 * @return
	 */
	public List<T> getGroupByData(T dat, T[] arr) {
		Map<String, List<T>> map = groupsByField(arr, "");
		String key = makeKeyByJsonString(dat);
		if (map.containsKey(key)) {
			return map.get(key);
		}
		return null;
	}
	
	/**
	 * 查看当前字段信息
	 * @return
	 */
	public Set<String> getFields() {
		return fields.keySet();
	}
	
	/**
	 * 设置当前字段信息
	 * @return
	 */
	public boolean setField(String field) {
		// field为null或者空字符串无意义
		if (checkNullOrEmptyField(field)) {
			// 不重复放属性名称，防止覆盖
			if (!fields.containsKey(field)) {
				fields.put(field,false);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 移除属性
	 * @param args
	 * @return
	 */
	public void removeFields(String ... fields) {
		for (String field : fields) 
			if (checkNullOrEmptyField(field))
				if (this.fields.containsKey(field)) 
					this.fields.remove(field);
		
	}
	
	/**
	 * 选择正常的field名称
	 * @param args
	 */
	public void setFields(String ... args) {
		// 确保args不为null
		if (Objects.nonNull(args)) {
			for (String field : args) {
				setField(field);
			}
		}
	}
	
	/**
	 * json字符串
	 * @param args
	 * @return
	 */
	private String makeKeyByJsonString(Object obj) {
		return JSON.toJSONString(obj, simplePropertyPreFilter);
	}
	
	/**
	 * 检查属性是否存在，clean无关属性
	 */
	private void checkFieldsAndPropertyPreFilterClean() {
//		fields.forEach((k, v) -> {
//			// 查看是否曾经被检查flag，如果检查过没有必要再检查
//			if (!v) {
//				try {
//					// 该字段从未被检查，先从自身属性查起
//					clazz.getDeclaredField(k);
//					entry.setValue(!v);
//				} catch (Exception e1) {
//					// 如果自身属性没有，看看是不是继承来的
//					try {
//						// TODO:父类属性只能接受public，有点问题
//						clazz.getField(k);
//						entry.setValue(!v);
//					} catch (Exception e2) {
//						// 还没有，这个属性移除
//						fields.remove(k);
//						// 由于simplePropertyPreFilter在构造器中是没有检查的，但是可以确定的是其中的属性肯定是fields的子集
//						if (simplePropertyPreFilter.getIncludes().contains(k)) {
//							simplePropertyPreFilter.getIncludes().remove(k);
//						}
//					}
//				}
//			}
//		});
		Iterator<Entry<String, Boolean>> it = fields.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Boolean> entry = it.next();
			String k = entry.getKey();
			Boolean v = entry.getValue();
			// 查看是否曾经被检查flag，如果检查过没有必要再检查
			if (!v) {
				try {
					// 该字段从未被检查，先从自身属性查起
					clazz.getDeclaredField(k);
					entry.setValue(!v);
				} catch (Exception e1) {
					// TODO:父类属性只能接受public，有点问题
					// 如果自身属性没有，看看是不是继承来的
					try {
						clazz.getField(k);
						entry.setValue(!v);
					} catch (Exception e2) {
						// 还没有，这个属性移除
						fields.remove(k);
						// 由于simplePropertyPreFilter在构造器中是没有检查的，但是可以确定的是其中的属性肯定是fields的子集
						if (simplePropertyPreFilter.getIncludes().contains(k)) {
							simplePropertyPreFilter.getIncludes().remove(k);
						}
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * @param field
	 * @return
	 */
	private boolean checkNullOrEmptyField(String field){
		return Objects.nonNull(field) && !"".equals(field);
	}
	
	/**
	 * 最新fields同步到属性过滤器包含集合中
	 */
	private void fieldsSynToIncludes(){
		Set<String> includes = simplePropertyPreFilter.getIncludes();
		includes.clear();
		// 最新的属性同步到PropertyPreFilter中
		includes.addAll(fields.keySet());
		System.out.println("simplePropertyPreFilter:"+includes);
	}

	
}
