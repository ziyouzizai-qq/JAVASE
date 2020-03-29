package lock.count.down;

/**
 * 国家
 * @author 王浩
 *
 */
public enum CountryEnum {

	ONE(1, "齐"), TWO(2, "楚"), THREE(3, "燕"), FOUR(4, "赵"), FIVE(5, "魏"), SIX(6, "韩");

	private int code;
	
	private String name;

	CountryEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public static CountryEnum forEach_CountryEnum(int index) {
		CountryEnum[] arr = CountryEnum.values();
		for (CountryEnum countryEnum : arr) {
			if (index == countryEnum.getCode()) {
				return countryEnum;
			}
		}
		return null;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	
}
