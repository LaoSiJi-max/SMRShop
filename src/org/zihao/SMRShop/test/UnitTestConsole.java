package org.zihao.SMRShop.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.zihao.SMRShop.bean.Book;
import org.zihao.SMRShop.dao.ifs.BaseDao;
import org.zihao.SMRShop.dao.ifs.BaseDaoImpl;

public class UnitTestConsole 
{
	private Scanner scanner = null;
	private String cmd;
	private String[] cmds;
	
	public static void main(String[] args) 
	{
		new UnitTestConsole();
	}
	
	public UnitTestConsole() 
	{
		scanner = new Scanner(System.in);
		firstMenu();
	}
	
	private void firstMenu()
	{
		boolean isToRun = true;
		
		while(isToRun)
		{
			System.out.println("提示:请输入命令:");
			cmd = scanner.nextLine();
			
			//全局命令
			switch (cmd) 
			{
				//退出
				case "exit":
					System.out.println("--- 结束测试 ---");
					System.exit(0);
					break;
	
				case "":	
					continue;
					
				default:
					cmds = cmd.split(" ");
					break;
			}
			
			//分部命令
			switch (cmds[0]) 
			{
				case "test":
					secondMenu();
					break;
	
				default:
					System.out.println("提示:命令不存在");
					break;
			}
		}
	}
	
	private void secondMenu()
	{
		boolean isToRun = true;
		
		if(cmds.length<2)
		{
			System.out.println("提示:请输入要测试的层:");
		}
				
		String pagName = cmds.length>=2?cmds[1]:scanner.nextLine();
			
		switch (pagName)
		{
			case "dao":
			case "service":
			case "action":
			case "util":
				thirdMenu(pagName);
				break;
						
			default:
				System.out.println("提示:该层不存在");
				break;
		}
	}
	
	private void thirdMenu(String pagName)
	{	
		if(cmds.length<3)
		{
			System.out.println("提示:请输入要测试的单元:");
		}
		String unitName = cmds.length<3?scanner.nextLine():cmds[2];
		
		switch (pagName)
		{
			case "dao":
			case "service":
			case "action":
				String firstChar = pagName.substring(0,1);
				createTest(pagName, unitName+pagName.replace(firstChar, firstChar.toUpperCase())+"Test");
			break;
				
			case "util":
				createTest(pagName, unitName+"Test");
			break;
			
		default:
			break;
		}
	}
	
	private void createTest(String pagName,String className) 
	{
		System.out.println("--- 开始此单元测试 ---");
		
		boolean isToRun = true;
		
		try 
		{
			Class c = Class.forName("org.zihao.SMRShop.test."+pagName+"."+className);
			Constructor constructor = c.getConstructor(String.class);			
			
			while(isToRun)
			{
				System.out.println("请输入要测试的方法：");
				String cmd = scanner.nextLine();
				switch (cmd) 
				{
					case "finish":
						isToRun = false;
						break;
						
					default:
						Method method = c.getDeclaredMethod(cmd+"Test");
						method.invoke(constructor.newInstance(className));
						break;
				}
			}
		} 
		catch (ClassNotFoundException e)
		{
			System.out.println("报告:找不到此测试类");
		}
		catch (NoSuchMethodException e)
		{
			System.out.println("报告:找不到此方法");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("测试发生异常");
		}
		finally
		{
			System.out.println("--- 结束此单元测试 ---");
		}
	}

}
