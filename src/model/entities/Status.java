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
	
//	@OneToOne
//	@JoinColumn(name = "label")
//	private Order order;
//	
	public Status() {}
	
	public Status(String label)
	{
		this.setStatus(label);
	}
	
//	public Order getOrder()
//	{
//		return this.order;
//	}
//	
//	public void setOrder(Order order)
//	{
//		this.order = order;
//	}
	
	public void setStatus(String label)
	{
		this.label = label;
	}
	
	public String getStatus()
	{
		return this.label;
	}

}
