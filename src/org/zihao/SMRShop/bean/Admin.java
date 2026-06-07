package org.zihao.SMRShop.bean;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.zihao.SMRShop.bean.enums.AdminLevel;
import org.zihao.SMRShop.bean.enums.AdminState;

@Entity
@Table(name="a_admin")
public class Admin 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String logName;
	private String pwd;
	@Enumerated(EnumType.ORDINAL)
	private AdminLevel level;
	@Enumerated(EnumType.ORDINAL)
	private AdminState state;
	
	public Admin() 
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogName() {
		return logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public AdminLevel getLevel() {
		return level;
	}

	public void setLevel(AdminLevel level) {
		this.level = level;
	}

	public AdminState getState() {
		return state;
	}

	public void setState(AdminState state) {
		this.state = state;
	}
}
