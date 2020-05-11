package com.learning.mvc.ForntController;

import org.springframework.stereotype.Component;

@Component
public class UserModels {
	private int id;
	private String Name;
	private String Email;
	private String Addr;
	private String Phone;
	@Override
	public String toString() {
		return "UserModels [id=" + id + ", Name=" + Name + ", Email=" + Email + ", Addr=" + Addr + ", Phone=" + Phone
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddr() {
		return Addr;
	}
	public void setAddr(String addr) {
		Addr = addr;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	
	

}
