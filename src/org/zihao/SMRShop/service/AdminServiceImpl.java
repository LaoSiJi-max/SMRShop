package org.zihao.SMRShop.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.zihao.SMRShop.bean.Admin;
import org.zihao.SMRShop.bean.User;
import org.zihao.SMRShop.bean.enums.AdminState;
import org.zihao.SMRShop.bean.enums.UserState;
import org.zihao.SMRShop.dao.ifs.AdminDao;
import org.zihao.SMRShop.service.ifs.AdminService;
import org.zihao.SMRShop.util.ifs.Encryption;

public class AdminServiceImpl implements AdminService
{
	private AdminDao adminDao;

	private Encryption encryption;

	public AdminDao getAdminDao() 
	{
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao)
	{
		this.adminDao = adminDao;
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
	public int login(String logName, String pwd, HttpSession session)
	{
		Admin admin = adminDao.loginFind(logName, encryption.encrypt(pwd));
		
		if(admin!=null)
		{
			if(admin.getState()==AdminState.正常)
			{
				admin.setPwd("");
				session.setAttribute("loginAdmin", admin);
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
	public List<Admin> getAllAdmin()
	{
		return adminDao.getAll();
	}

	@Override
	public boolean create(Admin admin)
	{
		admin.setState(AdminState.正常);
		admin.setPwd(encryption.encrypt(admin.getPwd()));
		
		return adminDao.save(admin);
	}

	@Override
	public boolean delete(int id)
	{
		Admin admin = adminDao.get(id);
		return adminDao.delete(admin);
	}

	@Override
	public boolean stateChange(int id)
	{
		Admin admin = adminDao.get(id);
		
		if(admin.getState()==AdminState.正常)
		{
			admin.setState(AdminState.停用);
		}
		else
		{
			admin.setState(AdminState.正常);
		}
		
		return adminDao.update(admin);
	}
}
