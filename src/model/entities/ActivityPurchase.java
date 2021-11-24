package model.entities;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "activity_purchase")
@AssociationOverrides({
	@AssociationOverride(name = "purchase",
		joinColumns = @JoinColumn(name = "purchase_id")),
	@AssociationOverride(name = "activity",
		joinColumns = @JoinColumn(name = "activity_id")) })
public class ActivityPurchase 
{
	private ActivityPurchaseId primary_key = new ActivityPurchaseId();
	
	private int quantity;
	
	public ActivityPurchase() {}
	
	public ActivityPurchase(ActivityPurchaseId primary_key, int quantity)
	{
		this.setPrimaryKey(primary_key);
		this.setQuantity(quantity);
	}
	
	@EmbeddedId
	public ActivityPurchaseId getPrimaryKey()
	{
		return this.primary_key;
	}
	
	public void setPrimaryKey(ActivityPurchaseId primary_key)
	{
		this.primary_key = primary_key;
	}
	
	@Transient
	public Purchase getPurchase()
	{
		return this.getPrimaryKey().getPurchase();
	}
	
	public void setPurchase(Purchase purchase)
	{
		this.getPrimaryKey().setPurchase(purchase);
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
