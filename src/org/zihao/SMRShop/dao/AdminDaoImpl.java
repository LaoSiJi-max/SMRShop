package org.zihao.SMRShop.dao;

import java.io.Serializable;
import java.util.List;

import org.zihao.SMRShop.bean.Admin;
import org.zihao.SMRShop.bean.User;
import org.zihao.SMRShop.dao.ifs.AdminDao;

public class AdminDaoImpl extends AdminDao
{

	@Override
	public Admin get(Serializable id)
	{
		if(getBeanType()==null)
		{
			setBeanType(Admin.class);
		}
		
		return super.get(id);
	}

	@Override
	public List<Admin> getAll()
	{
		if(getBeanType()==null)
		{
			setBeanType(Admin.class);
		}
		
		return super.getAll();
	}

	@Override
	public boolean save(Admin bean)
	{
		return super.save(bean);
	}

	@Override
	public boolean delete(Admin bean) 
	{
		return super.delete(bean);
	}

	@Override
	public boolean update(Admin bean) 
	{
		return super.update(bean);
	}

	@Override
	public Admin loginFind(String logName, String pwd)
	{
		if(getBeanType()==null)
		{
			setBeanType(Admin.class);
		}
		
		StringBuffer sql = new StringBuffer("select * from a_admin where logName=? and pwd=?");
		
		List<Admin> res = getSessionFactory().getCurrentSession()
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
	
}
