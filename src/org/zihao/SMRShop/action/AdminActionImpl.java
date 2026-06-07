package org.zihao.SMRShop.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.zihao.SMRShop.action.ifs.AdminAction;
import org.zihao.SMRShop.bean.Admin;
import org.zihao.SMRShop.service.ifs.AdminService;

import com.opensymphony.xwork2.ActionSupport;

public class AdminActionImpl extends ActionSupport implements AdminAction 
{
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = ServletActionContext.getRequest().getSession();
	
	private AdminService adminService;
	
	private Admin admin;
	
	public AdminService getAdminService()
	{
		return adminService;
	}

	public void setAdminService(AdminService adminService)
	{
		this.adminService = adminService;
	}

	public Admin getAdmin()
	{
		return admin;
	}

	public void setAdmin(Admin admin)
	{
		this.admin = admin;
	}

	@Override
	public String execute() throws Exception
	{
		return "main";
	}
	
	@Override
	public String login() 
	{
		if(session.getAttribute("loginAdmin")==null)
		{
			return SUCCESS;
		}
		else
		{
			return "main";
		}
	}

	@Override
	public String login_sub()
	{
		switch(adminService.login(admin.getLogName(), admin.getPwd(), session))
		{
			case 1 :
				try 
				{
					ServletActionContext.getResponse().sendRedirect("/SMRShop/admin");
				} catch (IOException e) {
					e.printStackTrace();
				}
			return NONE;
			
			case 0 :
				request.setAttribute("mess", "登录失败!用户名或者密码有误");
				break;
			case -1:
				request.setAttribute("mess", "该用户已被封停");
				break;
			
		}
		
		return "adlogin";
	}

}
