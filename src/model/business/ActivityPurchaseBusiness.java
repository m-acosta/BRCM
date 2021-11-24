package model.business;

import java.sql.SQLException;
import java.util.List;

import model.dataccess.ActivityPurchaseDataAccess;
import model.entities.ActivityPurchase;
import model.entities.MessageException;

public class ActivityPurchaseBusiness 
{
	public static double RevenueReportByActivities(List<String> activities) throws ClassNotFoundException, SQLException 
	{
		if (activities.isEmpty()) {
			throw new MessageException("No activities selected not Found.");
		} 
		
		double revenue_report = 0;
		for(String temp: activities)
		{
			ActivityPurchaseDataAccess actpurchDa = new ActivityPurchaseDataAccess();
			List<ActivityPurchase> activity_purchases = actpurchDa.getActivityPurchaseByActivity(temp);
			for(ActivityPurchase temp2: activity_purchases)
			{
				double multiplier1 = temp2.getQuantity();
				System.out.println(multiplier1);
				// get the purchase receipt need the date
				// then check the activity price table for the price around that date for the activity_name  of temp2
				// multiple the quantity with the price and move on to next purchase do the same thing tally it up
				// if the user selected multiple activities do the same thing again for the next activity and tally it all up
			}
		}
		
		return 0.0;
	}
	
	public static double PurchaseReceipt(int id) throws ClassNotFoundException, SQLException 
	{

		ActivityPurchaseDataAccess actpurchDa = new ActivityPurchaseDataAccess();
		List<ActivityPurchase> activity_purchases = actpurchDa.getActivityPurchaseByPurchaseId(id);
		for(ActivityPurchase temp: activity_purchases)
		{
			String activity = temp.getActivity().getActivity();
			double price = temp.getActivity().getPrice();
			System.out.println(activity);
			System.out.println(price);
			// get the purchase receipt need the date
			// then check the activity price table for the price around that date for the activity_name  of temp2
			// multiple the quantity with the price and move on to next purchase do the same thing tally it up
			// if the user selected multiple activities do the same thing again for the next activity and tally it all up
		}
		
		return 0.0;
	}
}
