package model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "affiliation")
public class Affiliation {
	
	@Id
	private String title;
	private int discount;
		
	public Affiliation() {}
	
	public Affiliation(String title, int discount)
	{
		this.setTitle(title);
		this.setDiscount(discount);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getDiscount() {
		return Double.valueOf(discount) / 100.0;
	}
	
	public int getDiscountDisplay() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Affiliation [title=" + title + ", discount=" + discount + "]";
	}
}
