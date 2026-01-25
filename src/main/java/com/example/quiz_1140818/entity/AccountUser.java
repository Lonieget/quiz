package com.example.quiz_1140818.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class AccountUser extends Account {
	
	
	@Column(name = "name")
	private String name ;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "gender")
	private String gender;

	
	// 在 AccountUser 類別中新增此建構子
	public AccountUser(String account, String password, String name, String phone, String email, int age, String gender) {
	    // 呼叫父類別 Account 的建構子 (假設 Account 有對應的建構子)

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
