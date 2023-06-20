package com.java.www;

public class Member {

	public Member() {
	}

	public Member(String id, String pw, String name, String phone, String gender, String hobby) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.gender = gender;
		this.hobby = hobby;
	}

	private String id;
	private String pw;
	private String name;
	private String phone;
	private String gender;
	private String hobby;


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return this.pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHobby() {
		return this.hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
}