package org.zihao.SMRShop.action.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.zihao.SMRShop.action.ifs.admin.AdBookAction;
import org.zihao.SMRShop.bean.Book;
import org.zihao.SMRShop.service.ifs.BookService;

import com.opensymphony.xwork2.ActionSupport;

public class AdBookActionImpl extends ActionSupport implements AdBookAction
{
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	
	private BookService bookService;
	
	private String cond;
	private String keyword;
	private Book book;
	
	public BookService getBookService()
	{
		return bookService;
	}

	public void setBookService(BookService bookService)
	{
		this.bookService = bookService;
	}

	public String getCond()
	{
		return cond;
	}

	public void setCond(String cond)
	{
		this.cond = cond;
	}

	public String getKeyword()
	{
		return keyword;
	}

	public void setKeyword(String keyword)
	{
		this.keyword = keyword;
	}

	public Book getBook()
	{
		return book;
	}

	public void setBook(Book book)
	{
		this.book = book;
	}

	@Override
	public String execute() throws Exception
	{
		List<Book> result = new ArrayList<Book>();
		
		if(getCond()!=null&&getKeyword()!=null)
		{
			 result = bookService.getByCond(cond, keyword);
		}
		
		request.setAttribute("result", result);
		request.setAttribute("count", result.size());
		return "main";
	}

	@Override
	public String createOrUpdate()
	{
		String id = request.getParameter("id");
		
		if(id!=null)
		{
			Book book = bookService.getBook(Integer.valueOf(id));
			request.setAttribute("book", book);
		}
		
		return SUCCESS;
	}

	@Override
	public String createOrUpdate_sub()
	{
		if(bookService.createOrUpdate(book))
		{
			try 
			{
				response.sendRedirect("/SMRShop/adBook");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		return ERROR;
	}

	@Override
	public String delete()
	{
		int id = Integer.valueOf(request.getParameter("id").toString());
		
		if(bookService.delete(id))
		{
			try
			{
				response.sendRedirect("/SMRShop/adBook");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return ERROR;
	}

}
