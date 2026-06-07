package org.zihao.SMRShop.service.ifs;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.zihao.SMRShop.bean.Book;
import org.zihao.SMRShop.bean.Order;
import org.zihao.SMRShop.bean.User;

public interface UserService 
{
	public boolean register(User user);
	public int login(String logName,String pwd,HttpSession session);
	public List<Book> getCart(int u_id);
	public boolean cartAdd(int u_id,int b_id);
	public boolean cartRemove(int u_id,int b_id);
	public List<User> getByCond(String cond, String keyword);
	public boolean delete(int id);
	public boolean stateChange(int id);
	public void clearCart(int u_id);
}
