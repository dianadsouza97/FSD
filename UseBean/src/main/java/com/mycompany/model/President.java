package com.mycompany.model;

import java.io.Serializable;

public class President implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7248489007368881753L;
	private String presidentName;
	private int age;
	
	public President() {
		super();
	}
	public String getPresidentName() {
		return presidentName;
	}
	public void setPresidentName(String presidentName) {
		this.presidentName = presidentName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "President [presidentName=" + presidentName + ", age=" + age + "]";
	}
	
}
