package model.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ActivityPurchaseId implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3908983137643904474L;
	
	private Purchase purchase;
	private Activity activity;
	
	public ActivityPurchaseId() {}
	
	public ActivityPurchaseId(Purchase purchase, Activity activity)
	{
		this.setPurchase(purchase);
		this.setActivity(activity);
	}
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Purchase getPurchase()
	{
		return this.purchase;
	}
	
	public void setPurchase(Purchase purchase)
	{
		this.purchase = purchase;
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
