package org.zihao.SMRShop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.zihao.SMRShop.action.ifs.UserAction;
import org.zihao.SMRShop.bean.Book;
import org.zihao.SMRShop.bean.Order;
import org.zihao.SMRShop.bean.User;
import org.zihao.SMRShop.dao.ifs.UserDao;
import org.zihao.SMRShop.service.ifs.OrderService;
import org.zihao.SMRShop.service.ifs.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class UserActionImpl extends ActionSupport implements UserAction 
{
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = ServletActionContext.getRequest().getSession();
	private HttpServletResponse response = ServletActionContext.getResponse();
	
	private UserService userService;
	private OrderService orderService;

	private User user;
	
	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	public OrderService getOrderService()
	{
		return orderService;
	}

	public void setOrderService(OrderService orderService)
	{
		this.orderService = orderService;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	@Override
	public String login() 
	{
		if(session.getAttribute("loginUser")==null)
		{
			return SUCCESS;
		}
		else
		{
			return "index";
		}
	}

	@Override
	public String login_sub() 
	{
		switch(userService.login(user.getLogName(), user.getPwd(), session))
		{
			case 1 :
				try 
				{
					ServletActionContext.getResponse().sendRedirect("/SMRShop/index");
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
		
		return "login";
	}

	@Override
	public String register() 
	{
		return SUCCESS;
	}

	@Override
	public String register_sub() 
	{
		if(userService.register(user))
		{
			try 
			{
				response.sendRedirect("/SMRShop/index");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			try 
			{
				response.getWriter().println("<script>alert('出现异常,注册失败')</script>");
				response.sendRedirect("/SMRShop/user_register");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return NONE;
	}

	@Override
	public String cart() 
	{
		User loginUser = (User)session.getAttribute("loginUser");
		int u_id = loginUser.getId();
		List<Book> cart = userService.getCart(u_id);
		
		double sum = 0;
		for (Book book : cart) 
		{
			sum += book.getPrice();
		}
		
		request.setAttribute("cart", cart);
		request.setAttribute("sum", sum);
		return SUCCESS;
	}

	@Override
	public String cart_add()
	{
		User loginUser = (User)session.getAttribute("loginUser");
		int u_id = loginUser.getId();
		int b_id = Integer.valueOf(request.getParameter("b_id"));
		
		if(userService.cartAdd(u_id, b_id))
		{
			try 
			{
				response.sendRedirect("/SMRShop/user_cart");
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

	@Override
	public String cart_remove()
	{
		User loginUser = (User)session.getAttribute("loginUser");
		int u_id = loginUser.getId();
		int b_id = Integer.valueOf(request.getParameter("b_id"));
		
		if(userService.cartRemove(u_id, b_id))
		{
			try 
			{
				response.sendRedirect("/SMRShop/user_cart");
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
	
	@Override
	public String cart_sub()
	{
		User loginUser = (User)session.getAttribute("loginUser");
		int u_id = loginUser.getId();
		
		if(orderService.addOrder(u_id))
		{
			try 
			{
				response.sendRedirect("/SMRShop/user_orders");
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

	@Override
	public String orders()
	{
		User loginUser = (User)session.getAttribute("loginUser");
		int u_id = loginUser.getId();
		
		List<Order> orders = orderService.getOrders(u_id);
		if(orders!=null)
		{
			request.setAttribute("orders", orders);
			
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}

}
