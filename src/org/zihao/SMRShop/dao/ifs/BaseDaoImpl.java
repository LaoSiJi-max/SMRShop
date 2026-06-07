package org.zihao.SMRShop.dao.ifs;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

public class BaseDaoImpl<T> implements BaseDao<T>
{
	protected SessionFactory sessionFactory;
	protected Class<T> beanType;

	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Class<T> getBeanType() 
	{
		return beanType;
	}

	@Override
	public void setBeanType(Class<T> beanType) 
	{
		this.beanType = beanType;
	}

	public T get(Serializable id)
	{
		return (T)sessionFactory.getCurrentSession().get(beanType , id);
	}
	
	public List<T> getAll()
	{
		String hql = "from "+beanType.getName();
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	public boolean save(T bean)
	{
		try 
		{
			sessionFactory.getCurrentSession().save(bean);
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(T bean)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(bean);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(T bean)
	{
		try 
		{
			sessionFactory.getCurrentSession().update(bean);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
}
