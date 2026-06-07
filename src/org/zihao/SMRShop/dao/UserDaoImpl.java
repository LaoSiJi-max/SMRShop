package org.zihao.SMRShop.dao;

import java.io.Serializable;
import java.util.List;

import org.zihao.SMRShop.bean.Order;
import org.zihao.SMRShop.bean.User;
import org.zihao.SMRShop.dao.enums.UserCond;
import org.zihao.SMRShop.dao.ifs.UserDao;

public class UserDaoImpl extends UserDao 
{
	@Override
	public User get(Serializable id) 
	{
		if(getBeanType()==null)
		{
			setBeanType(User.class);
		}
		
		return super.get(id);
	}

	@Override
	public List<User> getAll() 
	{
		if(getBeanType()==null)
		{
			setBeanType(User.class);
		}
		
		return super.getAll();
	}

	@Override
	public boolean save(User bean) 
	{
		return super.save(bean);
	}

	@Override
	public boolean delete(User bean) 
	{
		return super.delete(bean);
	}

	@Override
	public boolean update(User bean)
	{
		return super.update(bean);
	}

	@Override
	public User loginFind(String logName, String pwd)
	{
		if(getBeanType()==null)
		{
			setBeanType(User.class);
		}
		
		StringBuffer sql = new StringBuffer("select * from u_user where logName=? and pwd=?");
		
		List<User> res = getSessionFactory().getCurrentSession()
				.createSQLQuery(sql.toString()).addEntity(beanType)
				.setParameter(0, logName).setParameter(1, pwd).list();
		
		if(res.size()>0)
		{
			return res.get(0);
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<User> getByCond(UserCond uCond, Object value)
	{
		if(getBeanType()==null)
		{
			setBeanType(User.class);
		}
		
		StringBuffer sql = new StringBuffer("select * from u_user where ");
		
		switch (uCond) {
		case id :
			sql.append("id=?");
			return sessionFactory.getCurrentSession()
					.createSQLQuery(sql.toString()).addEntity(beanType).setParameter(0, value).list();

		case nickName :
			sql.append("nickName like ?");
			break;
			
		default:
			break;
		}
		
		return sessionFactory.getCurrentSession()
				.createSQLQuery(sql.toString()).addEntity(beanType).setParameter(0, "%"+value+"%").list();
	}

}
