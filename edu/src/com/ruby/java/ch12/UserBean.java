package com.ruby.java.ch12;

import java.io.Serializable;

public class UserBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private String id;
	private String name;
	private String tel;
	private String address;
	
	public UserBean() {
	}
	
	public UserBean(String id, String name, String tel, String adress) {
		super(); //여기 왜 기본 생성자??
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String Id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName() {
		this.name = name;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "UserBean [id=" + id + ", name=" + name + ", tel=" + tel + ", address=" + address + "]"; 
	}
	
}
