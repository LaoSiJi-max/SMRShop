package org.zihao.SMRShop.dao.ifs;

import java.util.List;

import org.zihao.SMRShop.bean.Order;

public abstract class OrderDao extends BaseDaoImpl<Order> 
{

	public abstract List<Order> getById(int u_id);

}
