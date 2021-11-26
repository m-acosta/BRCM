package model.business;

import java.sql.SQLException;
import java.util.List;

import model.dataccess.ActivityDataAccess;
import model.entities.Activity;

public class ActivityBusiness 
{
	public static List<String> getAllActivities() throws ClassNotFoundException, SQLException 
	{
		return ((new ActivityDataAccess().getAllActivitiesByDate()));
	}
	
	public static Activity getActivityPrice(String name) throws ClassNotFoundException, SQLException 
	{
		return ((new ActivityDataAccess().getActivityPriceByName(name)));
	}
	
	public static List<Activity> getActivityIds(String activity) throws ClassNotFoundException, SQLException 
	{
		return ((new ActivityDataAccess().getActivityIdsByName(activity)));
	}
}
