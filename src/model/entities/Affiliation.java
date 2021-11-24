package model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
}
