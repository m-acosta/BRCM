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
		
		// Currently, there are three soccer, 3 * 12.5, one basketball, 5 * 10.5
		// so 3 * 12.5 + 1 * 11.5 = 90
		
		double output;
		
		try {
			output = ActivityPurchaseBusiness.RevenueReportByActivities(activityList);
			assertEquals(90, output);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
