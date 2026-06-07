package org.zihao.SMRShop.dao;

import java.io.Serializable;
import java.util.List;

import org.zihao.SMRShop.bean.Order;
import org.zihao.SMRShop.bean.User;
import org.zihao.SMRShop.dao.enums.UserCond;
import org.zihao.SMRShop.dao.ifs.OrderDao;
import org.zihao.SMRShop.dao.ifs.UserDao;

public class OrderDaoImpl extends OrderDao 
{
	@Override
	public Order get(Serializable id) 
	{
		if(getBeanType()==null)
		{
			setBeanType(Order.class);
		}
		
		return super.get(id);
	}

	@Override
	public List<Order> getAll() 
	{
		if(getBeanType()==null)
		{
			setBeanType(Order.class);
		}
		
		return super.getAll();
	}

	@Override
	public boolean save(Order bean)
	{
		return super.save(bean);
	}

	@Override
	public boolean delete(Order bean)
	{
		return super.delete(bean);
	}

	@Override
	public boolean update(Order bean)
	{
		return super.update(bean);
	}

	@Override
	public List<Order> getById(int u_id)
	{
		return getSessionFactory().getCurrentSession()
				.createQuery("from Order where u_id=?").setParameter(0, u_id).list();
	}

	
	
}
