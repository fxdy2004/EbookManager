package service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
//	UUID。。。对不起，做不到
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//	用于统一日期格式
	private String role;
	private int userId;
	private String userName;
	private String password;	//密码可以使用MessageDigest方法加密,但是 **懒**
	private String email;
	private String phone;
	private LocalDate birthday;
	private LocalDateTime registerTime;
	
	public User() {
		this.registerTime=LocalDateTime.now();
	}
	public String getRole() {
		return role;
	}
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public LocalDateTime getRegisterTime() {
		return registerTime;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setRegisterTime(LocalDateTime registerTime) {
		this.registerTime = registerTime;
	}
	@Override
    public String toString() {
		return getUserName()+getUserId();
	}
}
