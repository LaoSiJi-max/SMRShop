package org.zihao.SMRShop.test.service;

import java.lang.reflect.Method;

import org.zihao.SMRShop.service.BookServiceImpl;
import org.zihao.SMRShop.test.DefaultUnitTest;

public class BookServiceTest extends DefaultUnitTest<BookServiceImpl> 
{

	public BookServiceTest() 
	{
		super();
	}

	public BookServiceTest(String className) 
	{
		super(className);
	}
	
	public void getAllBooksTest() throws NoSuchMethodException, SecurityException
	{
		Method m = classType.getDeclaredMethod("getAllBooks");
		startTest(m);
	}
	
	public void getSearchBookTest() throws NoSuchMethodException, SecurityException
	{
		Method m = classType.getDeclaredMethod("getSearchBook",String.class);
		String keyword = (String)getPara("keyword", "s");
		startTest(m,keyword);
	}
	
}
