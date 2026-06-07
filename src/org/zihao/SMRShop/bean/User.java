package org.zihao.SMRShop.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.zihao.SMRShop.bean.enums.UserState;

@Entity
@Table(name="u_user")
public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String logName;
	private String pwd;
	private String nickName;
	private String phoneNum;
	private String email;
	@Enumerated(EnumType.ORDINAL)
	private UserState state;
	@ManyToMany(targetEntity=Book.class,fetch=FetchType.EAGER)
	@JoinTable(name="u_shoppingcart",
	joinColumns=@JoinColumn(name="u_id",referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="b_id",referencedColumnName="id"))
	private List<Book> shoppingCart;
	
	public User()
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserState getState() {
		return state;
	}

	public void setState(UserState state) {
		this.state = state;
	}

	public List<Book> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(List<Book> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
}
