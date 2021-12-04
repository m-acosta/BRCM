package model.business;

import java.sql.SQLException;
import java.util.List;

import model.dataccess.ActivityPurchaseDataAccess;
import model.entities.Activity;
import model.entities.ActivityPurchase;
import model.entities.MessageException;

public class ActivityPurchaseBusiness 
{
	public static double RevenueReportByActivities(List<Activity> activities_ids) throws ClassNotFoundException, SQLException 
	{
		if (activities_ids.isEmpty()) {
			throw new MessageException("No activities selected not Found.");
		} 
		
		double revenue_report = 0;
		for(Activity temp: activities_ids)
		{
			ActivityPurchaseDataAccess actpurchDa = new ActivityPurchaseDataAccess();
			List<ActivityPurchase> activity_purchases = actpurchDa.getActivityPurchaseByActivity(temp.getActivityId());
			for(ActivityPurchase tempActivityPurchase : activity_purchases) {
				double price = temp.getPrice()*tempActivityPurchase.getQuantity();
				revenue_report = revenue_report + price;
			}
			//revenue_report = revenue_report + (activity_purchases.size() * temp.getPrice());
		}
		
		return revenue_report;
	}
	
	public static List<ActivityPurchase> PurchaseReceipt(int id) throws ClassNotFoundException, SQLException 
	{

		ActivityPurchaseDataAccess actpurchDa = new ActivityPurchaseDataAccess();
		List<ActivityPurchase> activity_purchases = actpurchDa.getActivityPurchaseByPurchaseId(id);
		
		return activity_purchases;
	}
}
