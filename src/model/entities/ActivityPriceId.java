package model.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ActivityPriceId implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDate date;
	private Activity activity;
	
	public ActivityPriceId() {}
	
	public ActivityPriceId(Activity activity, LocalDate date)
	{
		this.setActivity(activity);
		this.setDate(date);
	}
	
	public LocalDate getDate()
	{
		return this.date;
	}
	
	public void setDate(LocalDate date)
	{
		this.date = date;
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
