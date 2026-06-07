package org.zihao.SMRShop.action.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.zihao.SMRShop.action.ifs.admin.AdAdminAction;
import org.zihao.SMRShop.bean.Admin;
import org.zihao.SMRShop.dao.ifs.AdminDao;
import org.zihao.SMRShop.service.ifs.AdminService;

import com.opensymphony.xwork2.ActionSupport;

public class AdAdminActionImpl extends ActionSupport implements AdAdminAction 
{
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	
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
		List<Admin> result = adminService.getAllAdmin();
		
		request.setAttribute("result", result);
		request.setAttribute("count", result.size());
		
		return "main";
	}

	@Override
	public String create()
	{
		return SUCCESS;
	}

	@Override
	public String create_sub()
	{
		if(adminService.create(admin))
		{
			try
			{
				response.sendRedirect("/SMRShop/adAdmin");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		return ERROR;
	}

	@Override
	public String delete()
	{
		int id = Integer.valueOf(request.getParameter("id").toString());
		
		if(adminService.delete(id))
		{
			try
			{
				response.sendRedirect("/SMRShop/adAdmin");
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
		
		if(adminService.stateChange(id))
		{
			try
			{
				response.sendRedirect("/SMRShop/adAdmin");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		return ERROR;
	}

	
}
