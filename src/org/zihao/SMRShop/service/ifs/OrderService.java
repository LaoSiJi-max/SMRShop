package org.zihao.SMRShop.service.ifs;

import java.util.List;

import org.zihao.SMRShop.bean.Order;

public interface OrderService
{
	public List<Order> getOrders(int u_id);
	public boolean addOrder(int u_id);
	public List<Order> getAll();
	public boolean stateChange(int id);
}
