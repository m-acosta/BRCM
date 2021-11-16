package model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status 
{
	
	@Id
	private String label;
	
	@OneToOne
	@JoinColumn(name = "label")
	private Purchase purchase;
	
	public Status() {}
	
	public Status(String label)
	{
		this.setStatus(label);
	}
	
	public Purchase getPurchase()
	{
		return this.purchase;
	}
	
	public void setPurchase(Purchase purchase)
	{
		this.purchase = purchase;
	}
	
	public void setStatus(String label)
	{
		this.label = label;
	}
	
	public String getStatus()
	{
		return this.label;
	}

}
