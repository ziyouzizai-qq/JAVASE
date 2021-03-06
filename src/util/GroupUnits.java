package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import util.ex.IsEmptyExeception;

/**
 * 工具类Group
 * @author 王浩
 * 说明：线程不安全
 * 
 * 遗留问题:1.fastjson必须要写get方法，还有个就是对null的属性是不参与转json字符串的，不影响分组
 * 		   2.includes有可能存在clazz不存在的属性，但是不影响转json
 * @param <T>
 */
public class GroupUnits<T> {
	
	private final Class<T> clazz;
	
	private final SimplePropertyPreFilter simplePropertyPreFilter = new SimplePropertyPreFilter(this.clazz);
	
	private final Set<String> includes = simplePropertyPreFilter.getIncludes();
	
	public GroupUnits(Class<T> clazz,String ... args) {
		super();
		// 构造器中必须指明类型
		if (Objects.isNull(clazz)) {
			throw new NullPointerException();
		}
		this.clazz = clazz;
		// 允许构造器初期化的属性注入，排除null和空字符
		setIncludes(args);
	}

	/**
	 * 对已有的属性进行分组
	 * @param arr
	 * @return
	 */
	public Map<String, List<T>> groupsByFields(T[] arr) {
		if (Objects.isNull(arr) || arr.length < 1) {
			throw new IsEmptyExeception("Target Array");
		}
		if (includes.isEmpty()) {
			throw new IsEmptyExeception("Field");
		}
		Map<String, List<T>> map = new HashMap<String, List<T>>();
		for (T dat : arr) {
			String groupName = getGroupName(dat);
			List<T> list;
			if (map.containsKey(groupName)) {
				list = map.get(groupName);
				list.add(dat);
			} else {
				list = new ArrayList<T>();
				list.add(dat);
				map.put(groupName, list);
			}
		}
		return map;
	}
	
	/**
	 * 根据属性分组
	 * @param arr
	 * @param args
	 * @return
	 */
	public Map<String, List<T>> groupsByFields(T[] arr, String ... args) {
		if (Objects.isNull(arr) || arr.length < 1) {
			throw new IsEmptyExeception("Target Array");
		}
		setIncludes(args);
		return groupsByFields(arr);
	}
	
	/**
	 * 找出目标数组中与dat元素一组的数据
	 * @param dat
	 * @param arr
	 * @return
	 */
	public List<T> getGroupByCondition(T dat, T[] arr) {
		return getGroupByCondition(dat, groupsByFields(arr));
	}
	
	/**
	 * 已经分配好的map，根据数据获取对应分组里面的所有数据
	 * @param dat
	 * @param map
	 * @return
	 */
	public List<T> getGroupByCondition(T dat, Map<String, List<T>> map) {
		String groupName = getGroupName(dat);
		if (map.containsKey(groupName)) {
			return map.get(groupName);
		}
		return null;
	}
	
	
	/**
	 * 设置当前字段信息
	 * @return
	 */
	public boolean setInclude(String field) {
		// field为null或者空字符串无意义
		if (checkNullOrEmptyField(field)) {
			return includes.add(field);
		}
		return false;
	}
	
	/**
	 * 移除属性
	 * @param args
	 * @return 
	 * @return
	 */
	public boolean removeIncludes(String ... fields) {
		boolean modified = false;
		if (Objects.nonNull(fields)) 
			for (String field : fields) 
				if (checkNullOrEmptyField(field))
					if (includes.remove(field))
						modified = true;
		return modified;
	}
	
	/**
	 * 选择正常的field名称
	 * @param args
	 */
	public boolean setIncludes(String ... args) {
		boolean modified = false;
		// 确保args不为null
		if (Objects.nonNull(args)) 
			for (String field : args) 
				if (setInclude(field)) 
					modified = true;
		return modified;
	}
	
	/**
	 * field信息
	 * @return
	 */
	public String getIncludesInfo() {
		return includes.toString();
	}
	
	/**
	 * 清理field信息
	 * @return
	 */
	public void clearIncludes() {
		includes.clear();
	}
	
	/**
	 * 对象转json字符串作为分组名
	 * @param obj 
	 * @return
	 */
	private String getGroupName(Object obj) {
		return JSON.toJSONString(obj, simplePropertyPreFilter);
	}
	
	/**
	 * 将属性为null
	 * @param field
	 * @return
	 */
	private boolean checkNullOrEmptyField(String field){
		return Objects.nonNull(field) && !"".equals(field);
	}
	
}
