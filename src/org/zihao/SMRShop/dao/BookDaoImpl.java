package org.zihao.SMRShop.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.zihao.SMRShop.bean.Book;
import org.zihao.SMRShop.dao.enums.BookCond;
import org.zihao.SMRShop.dao.ifs.BookDao;

@Transactional
@Repository
public class BookDaoImpl extends BookDao
{
	@Override
	public Book get(Serializable id) 
	{
		if(beanType==null)
		{
			setBeanType(Book.class);
		}
		
		return super.get(id);
	}
	
	@Override
	public List<Book> getAll() 
	{
		if(beanType==null)
		{
			setBeanType(Book.class);
		}
		
		return super.getAll();
	}
	
	@Override
	public boolean save(Book bean)
	{
		return super.save(bean);
	}
	
	@Override
	public boolean delete(Book bean)
	{
		return super.delete(bean);
	}
	
	@Override
	public boolean update(Book bean) 
	{
		return super.update(bean);
	}

	@Override
	public List<Book> getByCond(BookCond bCond, Object value) 
	{
		if(beanType==null)
		{
			setBeanType(Book.class);
		}
		
		StringBuffer sql = new StringBuffer("select * from b_book where ");
		
		switch (bCond) {
		case id :
			sql.append("id=?");
			return sessionFactory.getCurrentSession()
					.createSQLQuery(sql.toString()).addEntity(beanType).setParameter(0, value).list();

		case name :
			sql.append("name like ?");
			break;
		
		case author :
			sql.append("author like ?");
			break;
		
		case publisher :
			sql.append("publisher like ?");
			break;
			
		default:
			break;
		}
		
		return sessionFactory.getCurrentSession()
				.createSQLQuery(sql.toString()).addEntity(beanType).setParameter(0, "%"+value+"%").list();
	}

	@Override
	public boolean saveOrUpdate(Book book)
	{
		try 
		{
			sessionFactory.getCurrentSession()
			.saveOrUpdate(book);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
}
