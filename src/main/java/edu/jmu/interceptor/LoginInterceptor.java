package edu.jmu.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import edu.jmu.pojo.User;

public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginInterceptor() {
		// TODO 自动生成的构造函数存根
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		Map<String, Object> session = invocation.getInvocationContext().getSession();
		User user = (User) session.get("user");
		// 非法请求
		if (user == null) {
			ActionContext actionContext = invocation.getInvocationContext();
			HttpServletRequest request = (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);
			String ip = request.getRemoteAddr();
			LogManager.getRootLogger().info("拦截非法请求 IP：" + ip);
			session.put("msg", "请先登录");
			return Action.LOGIN;// 没有登录，跳转到登录页
		}
		return invocation.invoke();
	}

}
