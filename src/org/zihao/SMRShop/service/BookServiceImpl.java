package org.zihao.SMRShop.service;

import java.util.List;

import org.zihao.SMRShop.bean.Book;
import org.zihao.SMRShop.bean.User;
import org.zihao.SMRShop.dao.enums.BookCond;
import org.zihao.SMRShop.dao.ifs.BookDao;
import org.zihao.SMRShop.service.ifs.BookService;

public class BookServiceImpl implements BookService 
{
	private BookDao bookDao;

	public BookDao getBookDao()
	{
		return bookDao;
	}

	public void setBookDao(BookDao bookDao)
	{
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> getAllBooks()
	{
		return bookDao.getAll();
	}

	@Override
	public List<Book> getSearchBook(String keyword)
	{
		return bookDao.getByCond(BookCond.name, keyword);
	}

	@Override
	public Book getBook(int id)
	{
		return bookDao.get(id);
	}

	@Override
	public List<Book> getByCond(String cond, String keyword)
	{
		List<Book> result = null;
		
		switch (cond)
		{
		case "id":
			result = bookDao.getByCond(BookCond.id, keyword);
			break;
			
		case "name":
			result = bookDao.getByCond(BookCond.name, keyword);
			break;
			
		case "author":
			result = bookDao.getByCond(BookCond.author, keyword);
			break;
			
		case "publisher":
			result = bookDao.getByCond(BookCond.publisher, keyword);
			break;

		default:
			result = bookDao.getByCond(BookCond.id, keyword);
			break;
		}
		
		return result;
	}

	@Override
	public boolean createOrUpdate(Book book)
	{	
		return bookDao.saveOrUpdate(book);
	}

	@Override
	public boolean delete(int id)
	{
		Book book = bookDao.get(id);
		return bookDao.delete(book);
	}

}
