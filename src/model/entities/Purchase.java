package model.entities;

import java.sql.Time;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "purchase")
public class Purchase 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int purchase_id;
	private Time time;
	private LocalDate date;
	private double total_price;
	
	@OneToOne
	@JoinColumn(name="label", nullable=false)
	private Status status;
	
	@ManyToOne
    @JoinColumn(name="bronco_id", nullable=false)	
	private Customer customer;
	
//	@OneToMany
//	@JoinColumn
//	private Set<ActivityPurchase> activity_purchases = new HashSet<ActivityPurchase>();
	
	public Purchase() {}
	
	public Purchase(Time time, LocalDate date, double total_price, Status status, Customer customer)
	{
		this.setTime(time);
		this.setDate(date);
		this.setTotal_price(total_price);
		this.setStatus(status);
		this.setCustomer(customer);
	}
	
//	public Set<ActivityPurchase> getActivityPurchases() 
//	{
//	    return this.activity_purchases;
//	}
//	
//	public void setActivityPurchase(Set<ActivityPurchase> activity_purchases) 
//	{
//	    this.activity_purchases = activity_purchases;
//	}
//	
//	public void addActivityPurchase(ActivityPurchase activity_purchase)
//	{
//		this.activity_purchases.add(activity_purchase);
//	}
	
	public int getPurchaseId()
	{
		return this.purchase_id;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public String getStatus() {
		return status.getStatus();
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getCustomerId() {
		return customer.getBronco_id();
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
