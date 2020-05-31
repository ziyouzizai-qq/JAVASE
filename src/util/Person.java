package util;

import java.io.Serializable;

public class Person extends Father implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private Integer age;
	
	private String address;



	public Person(String name, Integer age, String address, String money) {
		super(money);
		this.name = name;
		this.age = age;
		this.address = address;
	}



	public String getName() {
		return name;
	}






	public Integer getAge() {
		return age;
	}







	public String getAddress() {
		return address;
	}






	
	
	
}
