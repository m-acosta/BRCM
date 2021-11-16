package model.entities;

import java.sql.Time;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_receipt")
public class Order 
{
	private int order_id;
	private Time time;
	private LocalDate date;
	private int total_price;
	
	@OneToOne(mappedBy="order_receipt")
	private Status status;
	
	@ManyToOne
    @JoinColumn(name="bronco_id", nullable=false)	
	private Customer customer;
	
	private Set<OrderActivity> order_activities = new HashSet<OrderActivity>();
	
	public Order() {}
	
	public Order(Time time, LocalDate date, int total_price, Status status, Customer customer)
	{
		this.setTime(time);
		this.setDate(date);
		this.setTotal_price(total_price);
		this.setStatus(status);
		this.setCustomer(customer);
	}
	
	@OneToMany(mappedBy = "primaryKey.order_item", cascade = CascadeType.ALL)
	public Set<OrderActivity> getOrderActivities() 
	{
	    return this.order_activities;
	}
	
	public void setOrderActivity(Set<OrderActivity> order_activities) 
	{
	    this.order_activities = order_activities;
	}
	
	public void addOrderActivity(OrderActivity order_activity)
	{
		this.order_activities.add(order_activity);
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	public int getOrderId()
	{
		return this.order_id;
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

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getCustomer() {
		return customer.getBronco_id();
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

}
