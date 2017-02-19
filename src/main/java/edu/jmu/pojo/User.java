package edu.jmu.pojo;

public class User {
	private String username;// 用户名
	private String password;// 密码
	private String realname;// 真实姓名
	private String registrationTime;// 注册时间
	private String token;// 令牌
	private String lastLoginTime;// 上一次登录时间
	private String lastLoginIp;// 上一次登录IP

	public User() {
		return;
	}

	public User(String username) {
		this.username = username;
		return;
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

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(String registrationTime) {
		this.registrationTime = registrationTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", realname=" + realname
				+ ", registrationTime=" + registrationTime + ", token=" + token + ", lastLoginTime=" + lastLoginTime
				+ ", lastLoginIp=" + lastLoginIp + "]";
	}

}
