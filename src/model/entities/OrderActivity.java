package model.entities;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "order_item")
@AssociationOverrides({
	@AssociationOverride(name = "primaryKey.order_item",
		joinColumns = @JoinColumn(name = "order_id")),
	@AssociationOverride(name = "primaryKey.activity",
		joinColumns = @JoinColumn(name = "name")) })
public class OrderActivity 
{
	private OrderActivityId primary_key = new OrderActivityId();
	
	private int quantity;
	
	@EmbeddedId
	public OrderActivityId getPrimaryKey()
	{
		return this.primary_key;
	}
	
	public void setPrimaryKey(OrderActivityId primary_key)
	{
		this.primary_key = primary_key;
	}
	
	@Transient
	public Order getOrder()
	{
		return this.getPrimaryKey().getOrder();
	}
	
	public void setOrder(Order order)
	{
		this.getPrimaryKey().setOrder(order);
	}
	
	@Transient
	public Activity getActivity()
	{
		return this.getPrimaryKey().getActivity();
	}
	
	public void setActivity(Activity activity)
	{
		this.getPrimaryKey().setActivity(activity);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
