package org.zihao.SMRShop.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.zihao.SMRShop.bean.Admin;
import org.zihao.SMRShop.bean.Book;
import org.zihao.SMRShop.bean.Order;
import org.zihao.SMRShop.bean.User;
import org.zihao.SMRShop.bean.enums.AdminState;
import org.zihao.SMRShop.bean.enums.OrderState;
import org.zihao.SMRShop.bean.enums.UserState;
import org.zihao.SMRShop.dao.enums.BookCond;
import org.zihao.SMRShop.dao.enums.UserCond;
import org.zihao.SMRShop.dao.ifs.BookDao;
import org.zihao.SMRShop.dao.ifs.OrderDao;
import org.zihao.SMRShop.dao.ifs.UserDao;
import org.zihao.SMRShop.service.ifs.UserService;
import org.zihao.SMRShop.util.ifs.Encryption;

public class UserServiceImpl implements UserService 
{
	private UserDao userDao;
	private BookDao bookDao;

	private Encryption encryption;

	public UserDao getUserDao()
	{
		return userDao;
	}

	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}
	
	public BookDao getBookDao()
	{
		return bookDao;
	}

	public void setBookDao(BookDao bookDao)
	{
		this.bookDao = bookDao;
	}

	public Encryption getEncryption()
	{
		return encryption;
	}

	public void setEncryption(Encryption encryption)
	{
		this.encryption = encryption;
	}

	@Override
	public boolean register(User user)
	{
		user.setState(UserState.正常);
		user.setPwd(encryption.encrypt(user.getPwd()));
		
		return userDao.save(user);
	}

	@Override
	public int login(String logName, String pwd,HttpSession session)
	{
		User user = userDao.loginFind(logName, encryption.encrypt(pwd));
		
		if(user!=null)
		{
			if(user.getState()==UserState.正常)
			{
				user.setPwd("");
				session.setAttribute("loginUser", user);
				return 1;
			}
			else
			{
				return -1;
			}
		}
		else
		{
			return 0;
		}
	}

	@Override
	public boolean cartAdd(int u_id,int b_id)
	{
		User user = userDao.get(u_id);
		Book book = bookDao.get(b_id);
		user.getShoppingCart().add(book);
		return userDao.update(user);
	}

	@Override
	public boolean cartRemove(int u_id,int b_id)
	{
		User user = userDao.get(u_id);
		
		List<Book> cart = user.getShoppingCart();
		for (int i=0;i<cart.size();i++)
		{
			if(cart.get(i).getId()==b_id)
			{
				cart.remove(i);
				break;
			}
		}
		return userDao.update(user);
	}

	@Override
	public List<Book> getCart(int u_id)
	{
		User user = userDao.get(u_id);
		return user.getShoppingCart();
	}

	@Override
	public List<User> getByCond(String cond, String keyword)
	{
		List<User> result = null;
		
		switch (cond)
		{
			case "id":
				result = userDao.getByCond(UserCond.id, keyword);
				break;
				
			case "nickName":
				result = userDao.getByCond(UserCond.nickName, keyword);
				break;
	
			default:
				result = userDao.getByCond(UserCond.id, keyword);
				break;
		}
		
		return result;
	}

	@Override
	public boolean delete(int id)
	{
		User user = userDao.get(id);
		return userDao.delete(user);
	}

	@Override
	public boolean stateChange(int id)
	{
		User user = userDao.get(id);
		
		if(user.getState()==UserState.正常)
		{
			user.setState(UserState.停用);
		}
		else
		{
			user.setState(UserState.正常);
		}
		
		return userDao.update(user);
	}

	@Override
	public void clearCart(int u_id)
	{
		User user = userDao.get(u_id);
		user.getShoppingCart().clear();
		userDao.save(user);
	}
}
