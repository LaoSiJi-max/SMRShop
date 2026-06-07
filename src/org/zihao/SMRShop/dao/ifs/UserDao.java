package org.zihao.SMRShop.dao.ifs;

import java.util.List;

import org.zihao.SMRShop.bean.User;
import org.zihao.SMRShop.dao.enums.UserCond;

public abstract class UserDao extends BaseDaoImpl<User> 
{
	public abstract User loginFind(String logName,String pwd);
	public abstract List<User> getByCond(UserCond uCond,Object value);
}
