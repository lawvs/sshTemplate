package edu.jmu.action;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.jmu.pojo.User;
import edu.jmu.service.IUserService;

@ParentPackage(value = "default")
public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	IUserService userService;
	private String username;
	private String password;

	public LoginAction() {
		// TODO 自动生成的构造函数存根
	}

	@Action(value = "dologin", results = { @Result(name = "success", location = "/dashboard", type = "redirect"),
			@Result(name = "login", location = "/login.jsp", type = "redirect") })
	public String dologin() {
		String ip = ServletActionContext.getRequest().getRemoteAddr();
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		if (username == null || username.equals("") || password == null || password.equals("")) {
			session.put("msg", "请输入用户名和密码");
			LogManager.getRootLogger().info("登录失败 IP:" + ip);
			return LOGIN;
		}
		User user;
		user = userService.login(username, password);
		if (user != null) {
			session.put("user", user);
			LogManager.getRootLogger().info("登录成功 IP:" + ip);
			return SUCCESS;
		}
		LogManager.getRootLogger().info("登录失败 IP:" + ip);
		session.put("msg", "用户名或密码错误");
		return LOGIN;
	}

	@Action(value = "dashboard", interceptorRefs = { @InterceptorRef("loginStack") }, results = {
			@Result(name = "success", location = "/WEB-INF/jsp/dashboard.jsp", type = "dispatcher"), })
	public String dashboard() {
		return SUCCESS;
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
