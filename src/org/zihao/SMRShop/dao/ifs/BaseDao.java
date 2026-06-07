package org.zihao.SMRShop.dao.ifs;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

public interface BaseDao<T>
{
	public SessionFactory getSessionFactory();
	public void setSessionFactory(SessionFactory sessionFactory); 
	public Class<T> getBeanType();
	public void setBeanType(Class<T> beanType);
	public T get(Serializable id);
	public List<T> getAll();
	public boolean save(T bean);
	public boolean delete(T bean);
	public boolean update(T bean);
}
