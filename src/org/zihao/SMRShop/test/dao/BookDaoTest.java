package org.zihao.SMRShop.test.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.zihao.SMRShop.bean.Book;
import org.zihao.SMRShop.dao.BookDaoImpl;
import org.zihao.SMRShop.dao.enums.BookCond;
import org.zihao.SMRShop.test.DaoUnitTest;

public class BookDaoTest extends DaoUnitTest<BookDaoImpl,Book> 
{
	public BookDaoTest()
	{
		
	}

	public BookDaoTest(String className) 
	{
		super(className);
	}

	@Override
	public void saveTest() throws NoSuchMethodException, SecurityException 
	{
		Book book = new Book();
		book.setName("testBook");
		book.setAuthor("testAuthor");
		book.setImage("testImage");
		book.setIntroduce("testInt");
		book.setPrice(123);
		book.setPublisher("testPub");
		
		doSave(book);
	}

	@Override
	public void deleteTest() throws NoSuchMethodException, SecurityException 
	{
		int id = (int)getPara("id", "i");
		Book book = getTestDao().get(id);
		doDelete(book);
	}

	@Override
	public void updateTest() throws NoSuchMethodException, SecurityException
	{
		int id = (int)getPara("id", "i");
		Book book = getTestDao().get(id);
		book.setName("updateTestBook");
		book.setAuthor("updateTestAuthor");
		book.setImage("updateTestImage");
		book.setIntroduce("updateTestInt");
		book.setPrice(321);
		book.setPublisher("updateTestPub");
		doUpdate(book);
	}

	@Override
	public void getTest() throws NoSuchMethodException, SecurityException
	{
		super.getTest();
	}
	
	public void getByCondTest() throws NoSuchMethodException, SecurityException
	{
		Method method = classType.getDeclaredMethod("getByCond", BookCond.class,Object.class);
		
		startTest(method, BookCond.id, 1);
		startTest(method, BookCond.name, "ÀäÐ¦»°");
		startTest(method, BookCond.author, "Äª");
		startTest(method, BookCond.publisher, "³ö°æ");
	}
}
