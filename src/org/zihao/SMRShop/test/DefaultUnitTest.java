package org.zihao.SMRShop.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public abstract class DefaultUnitTest<T>
{
	protected T testClass;
	protected Class classType;
	protected Scanner scanner;
	
	public DefaultUnitTest() 
	{
		classType = testClass.getClass();
		scanner = new Scanner(System.in);
	}
	
	public DefaultUnitTest(String className) 
	{
		ApplicationContext context = new FileSystemXmlApplicationContext("/WebContent/WEB-INF/applicationContext.xml");
		testClass = (T)context.getBean(getBeanName(className));
		classType = testClass.getClass();
		scanner = new Scanner(System.in);
	}
	
	public T getTestDao() 
	{
		return testClass;
	}

	public void setTestDao(T testClass) 
	{
		this.testClass = testClass;
	}
	
	public void startTest(Method method,Object... paras)
	{
		Object res = null;
		try 
		{
			res = method.invoke(testClass ,paras);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
			
		StringBuffer report = new StringBuffer("报告:");
		report.append(testClass.getClass().getName());
		report.append(".");
		report.append(method.getName());
		report.append("(");
			
		for (int i=0;i<paras.length;i++) 
		{
			if(paras[i] instanceof String)
			{
				report.append("\""+paras[i]+"\"");
			}
			else
			{
				report.append(paras[i]);
			}
			
			if(i<paras.length-1)
			{
				report.append(",");
			}
		}
			
		report.append(")的返回值为:");
		report.append(res);
			
		System.out.println(report.toString());
	}
	
	public String getBeanName(String className)
	{
		String first = className.substring(0,1);
		return className.replaceFirst(first, first.toLowerCase()).replaceAll("Test", "");
	}
	
	public Object getPara(String paraName,String retType)
	{
		System.out.print(paraName+"=");
		switch (retType) 
		{
			case "s":
				return scanner.nextLine();
				
			case "i":
				return scanner.nextInt();
				
			case "d":
				return scanner.nextDouble();
				
			case "f":
				return scanner.nextFloat();
				
			default:
				return scanner.nextLine();
		}
	}
}
