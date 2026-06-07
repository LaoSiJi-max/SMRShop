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
import javax.persistence.Table;

import org.zihao.SMRShop.bean.enums.OrderState;

@Entity
@Table(name="o_order")
public class Order
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int u_id;
	@Enumerated(EnumType.ORDINAL)
	private OrderState state;
	@ManyToMany(targetEntity=Book.class,fetch=FetchType.EAGER)
	@JoinTable(name="o_items",
	joinColumns=@JoinColumn(name="o_id",referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="b_id",referencedColumnName="id"))
	private List<Book> items;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}

	public int getU_id()
	{
		return u_id;
	}
	public void setU_id(int u_id)
	{
		this.u_id = u_id;
	}
	public List<Book> getItems()
	{
		return items;
	}
	public void setItems(List<Book> items)
	{
		this.items = items;
	}
	public OrderState getState()
	{
		return state;
	}
	public void setState(OrderState state)
	{
		this.state = state;
	}
}
