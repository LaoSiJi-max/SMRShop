package org.zihao.SMRShop.test.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.zihao.SMRShop.bean.User;
import org.zihao.SMRShop.bean.enums.UserState;
import org.zihao.SMRShop.dao.UserDaoImpl;
import org.zihao.SMRShop.dao.enums.UserCond;
import org.zihao.SMRShop.test.DaoUnitTest;

public class UserDaoTest extends DaoUnitTest<UserDaoImpl,User> 
{
	public UserDaoTest() 
	{
		super();
	}

	public UserDaoTest(String className)
	{
		super(className);
	}

	@Override
	public void saveTest() throws NoSuchMethodException, SecurityException 
	{
		User user = new User();
		user.setEmail("123456@163.com");
		user.setLogName("test");
		user.setNickName("testName");
		user.setPhoneNum("123456");
		user.setPwd("testpwd");
		user.setState(UserState.Õý³£);
		
		doSave(user);
	}
	
	public void getByCondTest() throws NoSuchMethodException, SecurityException
	{
		Method method = classType.getDeclaredMethod("getByCond", UserCond.class,Object.class);
		startTest(method, UserCond.id, 1);
		startTest(method, UserCond.nickName, "t");
	}

	@Override
	public void deleteTest() throws NoSuchMethodException, SecurityException
	{
		int id = (int)getPara("id", "i");
		User user = testClass.get(id);
		doDelete(user);
	}

	@Override
	public void updateTest() throws NoSuchMethodException, SecurityException
	{
		int id = (int)getPara("id", "i");
		User user = testClass.get(id);
		user.setEmail("654321@163.com");
		user.setLogName("updatetest");
		user.setNickName("updatetestName");
		user.setPhoneNum("654321");
		user.setPwd("updatetestpwd");
		user.setState(UserState.Í£ÓÃ);
		
		doUpdate(user);
	}

	@Override
	public void getTest() throws NoSuchMethodException, SecurityException
	{
		super.getTest();
	}
}
