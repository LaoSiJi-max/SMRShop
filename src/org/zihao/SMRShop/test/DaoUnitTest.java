package org.zihao.SMRShop.test;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.zihao.SMRShop.bean.Admin;

public abstract class DaoUnitTest<T,B> extends DefaultUnitTest<T> 
{

	public DaoUnitTest() 
	{
		super();
	}

	public DaoUnitTest(String className) 
	{
		super(className);
	}
	
	public void doSave(B bean) throws NoSuchMethodException, SecurityException
	{
		if(bean!=null)
		{
			Method method = classType.getDeclaredMethod("save", bean.getClass());
			startTest(method, bean);
		}
		else
		{
			System.out.println("报告:参数bean为空,无法执行save");
		}
	}
	
	public void doDelete(B bean) throws NoSuchMethodException, SecurityException
	{
		if(bean!=null)
		{
			Method method = classType.getDeclaredMethod("delete", bean.getClass());
			startTest(method, bean);
		}
		else
		{
			System.out.println("报告:参数bean为空,无法执行delete");
		}
	}
	
	public void doUpdate(B bean) throws NoSuchMethodException, SecurityException
	{
		if(bean!=null)
		{
			Method method = classType.getDeclaredMethod("update", bean.getClass());
			startTest(method, bean);
		}
		else
		{
			System.out.println("报告:参数bean为空,无法执行update");
		}
	}
	
	public void getTest() throws NoSuchMethodException, SecurityException
	{
		Method get = classType.getDeclaredMethod("get", Serializable.class);
		startTest(get, (int)getPara("id", "i"));
		Method getAll = classType.getDeclaredMethod("getAll");
		startTest(getAll);
	}
	
	public abstract void saveTest() throws NoSuchMethodException, SecurityException ;
	public abstract void deleteTest() throws NoSuchMethodException, SecurityException ;
	public abstract void updateTest() throws NoSuchMethodException, SecurityException ;
	
}
