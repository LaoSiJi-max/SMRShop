package org.zihao.SMRShop.service.ifs;

import java.util.List;

import org.zihao.SMRShop.bean.Book;

public interface BookService 
{
	public List<Book> getAllBooks();
	public List<Book> getSearchBook(String keyword);
	public Book getBook(int id);
	public List<Book> getByCond(String cond,String keyword);
	public boolean createOrUpdate(Book book);
	public boolean delete(int id);
}
