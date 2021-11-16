package model.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderActivityId implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3908983137643904474L;
	private Order order;
	private Activity activity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Order getOrder()
	{
		return this.order;
	}
	
	public void setOrder(Order order)
	{
		this.order = order;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Activity getActivity()
	{
		return this.activity;
	}
	
	public void setActivity(Activity activity)
	{
		this.activity = activity;
	}
}
