package org.zihao.SMRShop.action.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.zihao.SMRShop.action.ifs.admin.AdOrderAction;
import org.zihao.SMRShop.bean.Order;
import org.zihao.SMRShop.service.ifs.OrderService;

import com.opensymphony.xwork2.ActionSupport;

public class AdOrderActionImpl extends ActionSupport implements AdOrderAction
{
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	
	private OrderService orderService;

	public OrderService getOrderService()
	{
		return orderService;
	}

	public void setOrderService(OrderService orderService)
	{
		this.orderService = orderService;
	}

	@Override
	public String execute() throws Exception
	{
		List<Order> result = orderService.getAll();
		
		request.setAttribute("result", result);
		request.setAttribute("count", result.size());
		
		return "main";
	}

	@Override
	public String stateChange()
	{
		int id = Integer.valueOf(request.getParameter("id"));
		if(orderService.stateChange(id))
		{
			try 
			{
				response.sendRedirect("/SMRShop/adOrder");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return NONE;
		}
		else
		{
			return ERROR;
		}
	}
}
