package model.business;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.dataccess.ActivityDataAccess;
import model.entities.Activity;

class ActivityPurchaseBusinessTest {

	@Test
	void testRevenueReportByActivities() {
		List<Activity> activityList = new ArrayList();
		Activity tempActivity1 = new ActivityDataAccess().getActivityById(1);
		Activity tempActivity2 = new ActivityDataAccess().getActivityById(3);
		activityList.add(tempActivity1);
		activityList.add(tempActivity2);
		
		// In our test scenario, Currently, there are two basketball, 
		// one basket ball is purchase by a student with id "00"
		// so price is round (10.5-0.85*10.5) = 8.5
		
		
		// one basket ball is purchase by a professor with id "01"
		// so price is round (10.5-0.8*10.5) = 8.5
		
		// there are two soccer activities, 
		
		// one soccer is purchase by a student with id "00"
		// so price is round (12.5-round(0.85*12.5)) = 9.5
		
		
		// one soccer is purchase by a professor with id "01"
		// so price is round (12.5-round(0.8*12.5)) = 10.5
		//The expected Total revenue should be 8.5+8.5+9.5+10.5 = 37
		
		double output;
		
		try {
			output = ActivityPurchaseBusiness.RevenueReportByActivities(activityList);
			assertEquals(76, output);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
