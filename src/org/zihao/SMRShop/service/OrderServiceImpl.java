package org.zihao.SMRShop.service;

import java.util.List;

import org.zihao.SMRShop.bean.Order;
import org.zihao.SMRShop.bean.enums.OrderState;
import org.zihao.SMRShop.dao.ifs.OrderDao;
import org.zihao.SMRShop.service.ifs.OrderService;
import org.zihao.SMRShop.service.ifs.UserService;

public class OrderServiceImpl implements OrderService
{
	private OrderDao orderDao;
	
	private UserService userService;

	public OrderDao getOrderDao()
	{
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao)
	{
		this.orderDao = orderDao;
	}
	
	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	@Override
	public List<Order> getOrders(int u_id)
	{
		return orderDao.getById(u_id);
	}

	@Override
	public boolean addOrder(int u_id)
	{
		Order order = new Order();
		order.setU_id(u_id);
		order.setState(OrderState.未发货);
		order.setItems(userService.getCart(u_id));
		
		userService.clearCart(u_id);
		
		return orderDao.save(order);
	}

	@Override
	public List<Order> getAll()
	{
		return orderDao.getAll();
	}

	@Override
	public boolean stateChange(int id)
	{
		Order order = orderDao.get(id);
		if(order.getState()==OrderState.未发货)
		{
			order.setState(OrderState.已发货);
		}
		else
		{
			order.setState(OrderState.未发货);
		}
		return orderDao.update(order);
	}

}
