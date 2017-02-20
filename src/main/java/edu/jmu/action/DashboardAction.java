package edu.jmu.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "default")
@Namespace("/dashboard")
@InterceptorRefs(@InterceptorRef("loginStack"))
public class DashboardAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DashboardAction() {
		// TODO 自动生成的构造函数存根
	}
	
	@Action(value = "", results = {
			@Result(name = "success", location = "/WEB-INF/jsp/dashboard.jsp", type = "dispatcher"), })
	public String dashboard() {
		return SUCCESS;
	}

	@Action(value = "usermanage", results = {
			@Result(name = "success", location = "/WEB-INF/jsp/usermanage.jsp", type = "dispatcher"), })
	public String fileview() {
		return SUCCESS;
	}

}
