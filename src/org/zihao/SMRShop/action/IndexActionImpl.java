package org.zihao.SMRShop.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.zihao.SMRShop.action.ifs.IndexAction;
import org.zihao.SMRShop.bean.Book;
import org.zihao.SMRShop.service.ifs.BookService;

import com.opensymphony.xwork2.ActionSupport;

public class IndexActionImpl extends ActionSupport implements IndexAction 
{
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	private BookService bookService;
	
	public BookService getBookService()
	{
		return bookService;
	}

	public void setBookService(BookService bookService)
	{
		this.bookService = bookService;
	}

	@Override
	public String execute() throws Exception 
	{
		List<Book> recBook = bookService.getAllBooks();
		List<Book> newBook = bookService.getAllBooks();
		request.setAttribute("recBook", recBook);
		request.setAttribute("newBook", newBook);
		
		return "main";
	}
	
	@Override
	public String about() 
	{		
		return SUCCESS;
	}

}
