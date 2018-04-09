package com.lanou.entity;

public class User {

	private int userId;
	private String userPhone;
	private String userPassword;
	private String checkPassword;
	private String MD5Password;
	private String address;
	private String userName;
	public User() {

	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getCheckPassword() {
		return checkPassword;
	}

	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}

	public String getMD5Password() {
		return MD5Password;
	}

	public void setMD5Password(String MD5Password) {
		this.MD5Password = MD5Password;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", userPhone='" + userPhone + '\'' +
				", userPassword='" + userPassword + '\'' +
				", checkPassword='" + checkPassword + '\'' +
				", MD5Password='" + MD5Password + '\'' +
				", address='" + address + '\'' +
				", userName='" + userName + '\'' +
				'}';
	}
}

