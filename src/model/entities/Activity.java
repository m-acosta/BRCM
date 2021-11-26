package model.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Activity")
@Table(name = "activity")
public class Activity 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int activity_id;
	private String activity;
	private LocalDate date;
	private double price;
	
	public Activity() {}
	
	public Activity(String activity, LocalDate date, double price)
	{
		this.setActivity(activity);
		this.setDate(date);
		this.setPrice(price);
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
