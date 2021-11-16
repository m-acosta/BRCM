package model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "affiliation")
public class Affiliation {
	
	@Id
	private String title;
	private int discount;
	
	@OneToOne
	@JoinColumn(name = "title")
	private Customer customer;
		
	public Affiliation() {}
	
	public Affiliation(String title, int discount)
	{
		this.setTitle(title);
		this.setDiscount(discount);
	}
	
	public Customer getCustomer()
	{
		return this.customer;
	}
	
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	

}
