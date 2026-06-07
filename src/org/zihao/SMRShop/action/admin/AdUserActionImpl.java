package org.zihao.SMRShop.action.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.zihao.SMRShop.action.ifs.admin.AdUserAction;
import org.zihao.SMRShop.bean.Book;
import org.zihao.SMRShop.bean.User;
import org.zihao.SMRShop.service.ifs.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class AdUserActionImpl extends ActionSupport implements AdUserAction 
{
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	
	private UserService userService;
	
	private String cond;
	private String keyword;

	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	public String getCond()
	{
		return cond;
	}

	public void setCond(String cond)
	{
		this.cond = cond;
	}

	public String getKeyword()
	{
		return keyword;
	}

	public void setKeyword(String keyword)
	{
		this.keyword = keyword;
	}

	@Override
	public String execute() throws Exception
	{
		List<User> result = new ArrayList<User>();
	
		if(getCond()!=null&&getKeyword()!=null)
		{
			 result = userService.getByCond(cond, keyword);
		}
		
		request.setAttribute("result", result);
		request.setAttribute("count", result.size());
		return "main";
	}
	
	@Override
	public String delete()
	{
		int id = Integer.valueOf(request.getParameter("id").toString());
		
		if(userService.delete(id))
		{
			try
			{
				response.sendRedirect("/SMRShop/adUser");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return ERROR;
	}

	@Override
	public String stateChange()
	{
		int id = Integer.valueOf(request.getParameter("id").toString());
		
		if(userService.stateChange(id))
		{
			try
			{
				response.sendRedirect("/SMRShop/adUser");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		return ERROR;
	}

}
