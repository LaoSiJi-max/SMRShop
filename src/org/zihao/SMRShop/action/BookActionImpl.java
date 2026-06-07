package org.zihao.SMRShop.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.zihao.SMRShop.action.ifs.BookAction;
import org.zihao.SMRShop.bean.Book;
import org.zihao.SMRShop.service.ifs.BookService;
import org.zihao.SMRShop.util.Paging;

import com.opensymphony.xwork2.ActionSupport;

public class BookActionImpl extends ActionSupport implements BookAction 
{
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	private BookService bookService;
	
	private String keyword;
	
	public BookService getBookService() 
	{
		return bookService;
	}

	public void setBookService(BookService bookService) 
	{
		this.bookService = bookService;
	}
	
	public String getKeyword()
	{
		return keyword;
	}

	public void setKeyword(String keyword)
	{
		this.keyword = keyword;
	}
	
	@Override
	public String execute() throws Exception 
	{
		String thisPage = (String)request.getAttribute("page");
		if(thisPage==null)
		{
			thisPage = "1";
		}
		List<Book> result = bookService.getAllBooks();
		Paging paging = new Paging(thisPage, 12, result.size());
		
		request.setAttribute("result", result);
		request.setAttribute("thisPage", thisPage);
		request.setAttribute("start", paging.startNum());
		request.setAttribute("end", paging.endNum());
		request.setAttribute("max", paging.getMaxPage());
		request.setAttribute("keyword", keyword);
		
		return "main";
	}

	@Override
	public String search() 
	{
		String thisPage = (String)request.getAttribute("page");
		if(thisPage==null)
		{
			thisPage = "1";
		}
		List<Book> result = bookService.getSearchBook(keyword);
		Paging paging = new Paging(thisPage, 12, result.size());
		String mess = "未找到相关结果";
		
		if(result.size()==0)
		{
			mess = "未找到相关结果";
		}
		else
		{
			mess = "找到"+result.size()+"条相关结果";
		}
		
		request.setAttribute("result", result);
		request.setAttribute("mess", mess);
		request.setAttribute("thisPage", thisPage);
		request.setAttribute("start", paging.startNum());
		request.setAttribute("end", paging.endNum());
		request.setAttribute("max", paging.getMaxPage());
		request.setAttribute("keyword", keyword);
		
		return "main";
	}

	@Override
	public String detail() 
	{
		int id = Integer.valueOf(request.getParameter("id"));
		Book book = bookService.getBook(id);
		ServletActionContext.getRequest().setAttribute("book", book);
		
		return SUCCESS;
	}

}
