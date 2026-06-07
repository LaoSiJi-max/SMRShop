package org.zihao.SMRShop.service.ifs;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.zihao.SMRShop.bean.Admin;

public interface AdminService 
{
	public int login(String logName,String pwd,HttpSession session);
	public List<Admin> getAllAdmin();
	public boolean create(Admin admin);
	public boolean delete(int id);
	public boolean stateChange(int id);
}
