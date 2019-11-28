package com.jswl.travel.pojo;

import java.io.Serializable;

public class User implements Serializable {
	
	
	private Integer uid;    // �û�id
	private String username;  // �û���
	private String password;  // 
	private String name;   // ��ʵ����
	private String birthday;   //����
	private String sex;     // �Ա�
	private String telephone;  // �绰����
	private String email;     // ����
	private String status;    // ״̬��
	private String code;     // ��֤��
	
	
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", birthday=" + birthday + ", sex=" + sex + ", telephone=" + telephone + ", email=" + email
				+ ", status=" + status + ", code=" + code + "]";
	}
	
	
	
	public User() {
		
	}



	public User(Integer uid, String username, String password, String name, String birthday, String sex,
			String telephone, String email, String status, String code) {
	
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
		this.telephone = telephone;
		this.email = email;
		this.status = status;
		this.code = code;
	}



	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	
	

	
	
	

}
