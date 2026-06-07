package org.zihao.SMRShop.util;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.zihao.SMRShop.bean.User;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class IndexInterceptor extends AbstractInterceptor
{
	HttpSession session = ServletActionContext.getRequest().getSession();
	@Override
	public String intercept(ActionInvocation invocation) throws Exception
	{
		User loginUser = (User)session.getAttribute("loginUser");
		
		if(loginUser!=null)
		{
			return invocation.invoke();
		}
		
		return "login";
	}

}
