package model.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int activity_id;
	private String activity;
	private LocalDate date;
	private double price;
	
	
//	@OneToMany
//	@JoinColumn(name = "purchase_id")
//	private Set<ActivityPurchase> activity_purchases = new HashSet<ActivityPurchase>();
	
	public Activity() {}
	
	public Activity(String activity, LocalDate date, double price)
	{
		this.setActivity(activity);
		this.setDate(date);
		this.setPrice(price);
	}
	
//	public Set<ActivityPurchase> getActivityPurchases() 
//	{
//	    return this.activity_purchases;
//	}
//	
//	public void setActivityPurchases(Set<ActivityPurchase> activity_purchases) 
//	{
//	    this.activity_purchases = activity_purchases;
//	}
//	
//	public void addActivityPurchase(ActivityPurchase activity_purchase)
//	{
//		this.activity_purchases.add(activity_purchase);
//	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
