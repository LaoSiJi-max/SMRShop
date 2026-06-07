package org.zihao.SMRShop.dao.ifs;

import org.zihao.SMRShop.bean.Admin;

public abstract class AdminDao extends BaseDaoImpl<Admin> 
{
	public abstract Admin loginFind(String logName,String pwd);
}
