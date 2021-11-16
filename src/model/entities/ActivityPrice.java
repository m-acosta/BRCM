package model.entities;

import java.time.LocalDate;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "activity_price")
@AssociationOverrides({
    @AssociationOverride(name = "activity",
        joinColumns = @JoinColumn(name = "name"))
})
public class ActivityPrice 
{
	private ActivityPriceId primary_key = new ActivityPriceId();
	private double price;
	
	public ActivityPrice() {}
	
	public ActivityPrice(ActivityPriceId primary_key, double price) 
	{
		this.setPrimaryKey(primary_key);
		this.setPrice(price);
	}
	
	
	@EmbeddedId
	public ActivityPriceId getPrimaryKey()
	{
		return this.primary_key;
	}
	
	public void setPrimaryKey(ActivityPriceId primary_key)
	{
		this.primary_key = primary_key;
	}
	
	@Transient
	public Activity getActivity()
	{
		return getPrimaryKey().getActivity();
	}
	
	public void setActivity(Activity activity)
	{
		getPrimaryKey().setActivity(activity);
	}
	
	@Transient
	public LocalDate getDate()
	{
		return getPrimaryKey().getDate();
	}
	
	public void setDate(LocalDate date)
	{
		getPrimaryKey().setDate(date);
	}
	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
