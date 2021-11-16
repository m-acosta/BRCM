package model.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "activity")
public class Activity 
{
	private String name;
	
	//private Set<OrderActivity> order_activities = new HashSet<OrderActivity>();
	
	public Activity() {}
	
	public Activity(String name)
	{
		this.setName(name);
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	@Id
	@Column(name = "name")
	public String getName()
	{
		return this.name;
	}
	
//	@OneToMany(mappedBy = "primaryKey.order_item", cascade = CascadeType.ALL)
//	public Set<OrderActivity> getOrderActivities() 
//	{
//	    return this.order_activities;
//	}
//	
//	public void setOrderActivity(Set<OrderActivity> order_activities) 
//	{
//	    this.order_activities = order_activities;
//	}
//	
//	public void addOrderActivity(OrderActivity order_activity)
//	{
//		this.order_activities.add(order_activity);
//	}
	
}
