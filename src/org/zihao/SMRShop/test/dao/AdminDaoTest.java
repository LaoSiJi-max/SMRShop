package org.zihao.SMRShop.test.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.zihao.SMRShop.bean.Admin;
import org.zihao.SMRShop.bean.enums.AdminLevel;
import org.zihao.SMRShop.bean.enums.AdminState;
import org.zihao.SMRShop.dao.AdminDaoImpl;
import org.zihao.SMRShop.test.DaoUnitTest;
import org.zihao.SMRShop.test.DefaultUnitTest;

public class AdminDaoTest extends DaoUnitTest<AdminDaoImpl, Admin>
{
	public AdminDaoTest()
	{
		
	}

	public AdminDaoTest(String className) 
	{
		super(className);
	}

	public void saveTest() throws NoSuchMethodException, SecurityException 
	{
		Admin admin = new Admin();
		admin.setLevel(AdminLevel.普通管理员);
		admin.setLogName("test");
		admin.setPwd("test");
		admin.setState(AdminState.正常);
		
		doSave(admin);
	}

	public void deleteTest() throws NoSuchMethodException, SecurityException 
	{
		int id = (int)getPara("id", "i");
		Admin admin = testClass.get(id);
		
		doDelete(admin);
	}

	public void updateTest() throws NoSuchMethodException, SecurityException 
	{
		int id = (int)getPara("id", "i");
		Admin admin = testClass.get(id);
		admin.setLevel(AdminLevel.系统管理员);
		admin.setLogName("updateTest");
		admin.setPwd("updateTest");
		admin.setState(AdminState.停用);
		
		doUpdate(admin);
	}

	@Override
	public void getTest() throws NoSuchMethodException, SecurityException
	{
		super.getTest();
	}
}
