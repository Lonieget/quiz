package com.example.quiz_1140818.response;

public class UserRes extends BasicRes {
	
	private String name;
	
	private String phone;
	
	private String email;
	
	private int age;
	
	private String gender;


	public UserRes(int code, String message) {
		super(code, message);
	}


	public UserRes(int code, String message, String name, String phone, String email, int age, String gender) {
		super(code, message);
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.gender = gender;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	

}
