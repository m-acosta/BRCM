package control;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.business.ActivityBusiness;
import model.business.CustomerBusiness;
import model.business.PurchaseBusiness;
import model.dataccess.ActivityPurchaseDataAccess;
import model.entities.Activity;
import model.entities.ActivityPurchase;
import model.entities.ActivityPurchaseId;
import model.entities.Customer;
import model.entities.MessageException;
import model.entities.Purchase;
import model.entities.Status;

@SuppressWarnings("serial")
public class RegistrationControl extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String address = "";
		double total = 0.0;
		try {
			
			String bronco_id = request.getParameter("bronco_id");
			Customer customer = CustomerBusiness.SearchByBroncoId(bronco_id);
			if (customer == null) {
				throw new MessageException("Incorrect credentials.");
			} else {
				Status status = new Status("Online");
				Time time = new Time(System.currentTimeMillis());
				LocalDate local_date = LocalDate.now();
				
				String soccer_checked = request.getParameter("soccer");
				String football_checked = request.getParameter("football");
				String basketball_checked = request.getParameter("basketball");
				ActivityPurchaseDataAccess purchase_activityDa = new ActivityPurchaseDataAccess();
				// this for loop should go through all selected items not selectable will change when 
				// event handler to add selected is created.
				// if checked add cost as well
				String activity1 = "";
				String activity2 = "";
				String activity3 = "";
				Purchase purchase = new Purchase(time, local_date, 0.0, status, customer);
				if(soccer_checked != null)
				{
					Activity activity = ActivityBusiness.getActivityPrice(soccer_checked);
					total += activity.getPrice() - Math.round((activity.getPrice() * customer.getAffiliation().getDiscount()));
					ActivityPurchaseId purchase_activity_pk = new ActivityPurchaseId(purchase, activity); // if checked
					ActivityPurchase purchase_activity = new ActivityPurchase(purchase_activity_pk, 1); // set to one for now dont need more than that
					purchase_activityDa.saveActivityPurchase(purchase_activity);
					activity1 = activity.getActivity() + " (" + activity.getPrice() + " X %" + customer.getAffiliation().getDiscountDisplay() + ")";
					
				}
				if(football_checked != null)
				{
					Activity activity = ActivityBusiness.getActivityPrice(football_checked);
					total += activity.getPrice() - Math.round(activity.getPrice() * customer.getAffiliation().getDiscount());
					ActivityPurchaseId purchase_activity_pk = new ActivityPurchaseId(purchase, activity); // if checked
					ActivityPurchase purchase_activity = new ActivityPurchase(purchase_activity_pk, 1); // set to one for now dont need more than that
					purchase_activityDa.saveActivityPurchase(purchase_activity);
					activity2 = activity.getActivity() + " (" + activity.getPrice() + " X %" + customer.getAffiliation().getDiscountDisplay() + ")";
				}
				if(basketball_checked != null)
				{
					Activity activity = ActivityBusiness.getActivityPrice(basketball_checked);
					total += activity.getPrice() - Math.round((activity.getPrice() * customer.getAffiliation().getDiscount()));
					ActivityPurchaseId purchase_activity_pk = new ActivityPurchaseId(purchase, activity); // if checked
					ActivityPurchase purchase_activity = new ActivityPurchase(purchase_activity_pk, 1); // set to one for now dont need more than that
					purchase_activityDa.saveActivityPurchase(purchase_activity);
					activity3 = activity.getActivity() + " (" + activity.getPrice() + " X %" + customer.getAffiliation().getDiscountDisplay() + ")";
				}
				purchase.setTotal_price(total);
				PurchaseBusiness.CreatePurchase(purchase);
				request.setAttribute("Bronco_Id", request.getParameter("bronco_id"));
				request.setAttribute("Name", customer.getFn_ln());
				request.setAttribute("Date", local_date.toString());
				request.setAttribute("Time", time.toString());
				request.setAttribute("Total", total);
				request.setAttribute("Activity1", activity1);
				request.setAttribute("Activity2", activity2);
				request.setAttribute("Activity3", activity3);
				
				address = "/view/RegisterSuccessView.jsp";
			}

		} catch (MessageException e) {
			if (e.getMessage().equals("Username not informed.")) {
				request.setAttribute("ErrorLogin", "Username not informed.");
				address = "/view/RegisterView.jsp";
			} else if (e.getMessage().equals("Password not informed.")) {
				request.setAttribute("ErrorLogin", "Password not informed.");
				address = "/view/RegisterView.jsp";	
			} else if (e.getMessage().equals("Incorrect credentials.")) {
				request.setAttribute("ErrorLogin", "Incorrect credentials.");
				address = "/view/RegisterView.jsp";	
		    }
		} catch (ClassNotFoundException e) {
			request.setAttribute("ErrorLogin", "Database connection failed.");
			address = "/view/RegisterView.jsp";
		} catch (SQLException e) {
			request.setAttribute("ErrorLogin", "Database connection failed.");
			address = "/view/RegisterView.jsp";
		}
		
	    RequestDispatcher rd = request.getRequestDispatcher(address);
		rd.forward(request, response);

	}
	
}
