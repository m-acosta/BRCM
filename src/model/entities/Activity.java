package model.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "Activity")
@Table(name = "activity")
public class Activity 
{
	@Id
	private String name;
	
	@OneToMany
	@JoinColumn
	private Set<ActivityPrice> activity_prices = new HashSet<ActivityPrice>();
	
	@OneToMany
	@JoinColumn(name = "purchase_id")
	private Set<ActivityPurchase> activity_purchases = new HashSet<ActivityPurchase>();
	
	public Activity() {}
	
	public Activity(String name)
	{
		this.setName(name);
	}
	
	@Column(name = "name")
	public String getName()
	{
		return this.name;
	}
	
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Set<ActivityPrice> getActivityPrices()
	{
		return this.activity_prices;
	}
	
	public void setActivityPrices(Set<ActivityPrice> activity_prices)
	{
		this.activity_prices = activity_prices;
	}
	
	public void addActivityPrice(ActivityPrice activity_price)
	{
		this.activity_prices.add(activity_price);
	}
	

	public Set<ActivityPurchase> getActivityPurchases() 
	{
	    return this.activity_purchases;
	}
	
	public void setActivityPurchases(Set<ActivityPurchase> activity_purchases) 
	{
	    this.activity_purchases = activity_purchases;
	}
	
	public void addActivityPurchase(ActivityPurchase activity_purchase)
	{
		this.activity_purchases.add(activity_purchase);
	}
	
}
