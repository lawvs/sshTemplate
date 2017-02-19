package edu.jmu.action;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.jmu.pojo.User;
import edu.jmu.service.IUserService;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	IUserService userService;
	String username;
	String password;

	public LoginAction() {
		// TODO 自动生成的构造函数存根
	}

	@Action(value = "dologin", results = { @Result(name = "success", location = "/dashboard", type = "redirect"),
			@Result(name = "login", location = "/login.jsp", type = "redirect") })
	public String dologin() {
		String ip = ServletActionContext.getRequest().getRemoteAddr();
		LogManager.getRootLogger().info("登录IP：" + ip);
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		User user;
		user = userService.login(username, password);
		if (user != null) {
			session.put("user", user);
			return SUCCESS;
		}
		session.put("msg", "用户名或密码错误");
		return LOGIN;
	}

	@Action(value = "dashboard*", results = {
			@Result(name = "success", location = "/WEB-INF/jsp/dashboard.jsp", type = "dispatcher"),
			@Result(name = "login", location = "/login.jsp", type = "redirect") })
	public String dashboard() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		if (session.get("user") != null) {
			return SUCCESS;
		}
		session.put("msg", "请先登录");
		return LOGIN;
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

}
