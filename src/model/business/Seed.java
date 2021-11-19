package model.business;

import java.sql.Time;
import java.time.LocalDate;

import model.dataccess.ActivityDataAccess;
import model.dataccess.ActivityPriceDataAccess;
import model.dataccess.ActivityPurchaseDataAccess;
import model.dataccess.AddressDataAccess;
import model.dataccess.AffiliationDataAccess;
import model.dataccess.CustomerDataAccess;
import model.dataccess.ProfessorDataAccess;
import model.dataccess.PurchaseDataAccess;
import model.dataccess.StatusDataAccess;
import model.dataccess.StudentDataAccess;
import model.entities.Activity;
import model.entities.ActivityPrice;
import model.entities.ActivityPriceId;
import model.entities.ActivityPurchase;
import model.entities.ActivityPurchaseId;
import model.entities.Address;
import model.entities.Affiliation;
import model.entities.Customer;
import model.entities.Professor;
import model.entities.Purchase;
import model.entities.Status;
import model.entities.Student;

public class Seed {

	public static void main(String[] args) {
		
		AddressDataAccess addressDa = new AddressDataAccess();
		Address add1 = new Address("Madison", 115, 95112, "long beach", "California");
		Address add2 = new Address("Jackson", 233, 92503, "san jose", "Texas");
		Address add3 = new Address("Washington", 797, 90512, "modesto", "Utah");
		addressDa.saveAddress(add1);
		addressDa.saveAddress(add2);
		addressDa.saveAddress(add3);
		
		AffiliationDataAccess affiliationDa = new AffiliationDataAccess();
		Affiliation aff1 = new Affiliation("Student", 15);
		Affiliation aff2 = new Affiliation("Professor", 20);
		Affiliation aff3 = new Affiliation("Both", 35);
		affiliationDa.saveAffiliation(aff1);
		affiliationDa.saveAffiliation(aff2);
		affiliationDa.saveAffiliation(aff3);
		
		LocalDate date1 = LocalDate.of(1991, 1, 14);
		LocalDate date2 = LocalDate.of(1991, 1, 15);
		LocalDate date3 = LocalDate.of(1991, 1, 16);
		
		CustomerDataAccess customerDa = new CustomerDataAccess();
		Customer student = new Customer("00", "Brian Nelson", date1, "9001112222", add1, aff1);
		Customer professor = new Customer("01", "Cameron Watts", date2, "9001113333", add2, aff2);
		Customer both = new Customer("10", "Don Hewey ", date3, "9001114444", add3, aff3);
		customerDa.saveCustomer(student);
		customerDa.saveCustomer(professor);
		customerDa.saveCustomer(both);
		
		LocalDate graddate1 = LocalDate.of(2024, 1, 14);
		LocalDate graddate2 = LocalDate.of(2024, 1, 15);
		
		LocalDate enterdate1 = LocalDate.of(2019, 1, 14);
		LocalDate enterdate2 = LocalDate.of(2019, 1, 15);
		
		StudentDataAccess studentDa = new StudentDataAccess();
		Student student1 = new Student(student.getBronco_id(), "CS", "None", graddate1, enterdate1);
		Student student_both = new Student(both.getBronco_id(), "LIT", "CS", graddate2, enterdate2);
		studentDa.saveStudent(student1);
		studentDa.saveStudent(student_both);
		
		ProfessorDataAccess professorDa = new ProfessorDataAccess();
		Professor professor1 = new Professor(professor.getBronco_id(), "CS-551", "AI", "CS");
		Professor professor_both = new Professor(both.getBronco_id(), "LIT-120", "Literature and Medicine", "LIT");
		professorDa.saveProfessor(professor1);
		professorDa.saveProfessor(professor_both);
		
		StatusDataAccess statusDa = new StatusDataAccess();
		Status status_online = new Status("Online");
		Status status_online_complete = new Status("Online Complete");
		Status status_counter = new Status("Counter");
		statusDa.saveStatus(status_online);
		statusDa.saveStatus(status_online_complete);
		statusDa.saveStatus(status_counter);
		
		ActivityDataAccess activityDa = new ActivityDataAccess();
		Activity activity_basketball = new Activity("Basketball");
		Activity activity_football = new Activity("Football");
		Activity activity_soccer = new Activity("Soccer");
		activityDa.saveActivity(activity_soccer);
		activityDa.saveActivity(activity_football);
		activityDa.saveActivity(activity_basketball);
		
		LocalDate priceupdate1 = LocalDate.of(2009, 1, 14);
		LocalDate priceupdate2 = LocalDate.of(2010, 1, 15);
		ActivityPriceDataAccess acprDa = new ActivityPriceDataAccess();
		ActivityPriceId basketball_pk = new ActivityPriceId(activity_basketball, priceupdate1);
		ActivityPriceId football_pk = new ActivityPriceId(activity_football, priceupdate2);
		ActivityPriceId soccer_pk = new ActivityPriceId(activity_soccer, priceupdate2);
		
		ActivityPrice basketball = new ActivityPrice(basketball_pk, 10.50);
		ActivityPrice football = new ActivityPrice(football_pk, 11.50);
		ActivityPrice soccer = new ActivityPrice(soccer_pk, 12.50);
		acprDa.saveActivityPrice(soccer);
		acprDa.saveActivityPrice(football);
		acprDa.saveActivityPrice(basketball);
		
		PurchaseDataAccess orderDa = new PurchaseDataAccess();
		
		LocalDate order_date_1 = LocalDate.of(2021, 1, 15);
		@SuppressWarnings("deprecation")
		Time order_time_1 = new Time(0, 0, 0);
		Purchase order1 = new Purchase(order_time_1, order_date_1, 544.00, status_online, student);
		orderDa.savePurchase(order1);
		
		LocalDate order_date_2 = LocalDate.of(2021, 1, 16);
		@SuppressWarnings("deprecation")
		Time order_time_2 = new Time(1, 1, 1);
		Purchase order2 = new Purchase(order_time_2, order_date_2, 144.00, status_online_complete, professor);
		orderDa.savePurchase(order2);
		
		LocalDate order_date_3 = LocalDate.of(2021, 1, 17);
		@SuppressWarnings("deprecation")
		Time order_time_3 = new Time(2, 2, 2);
		Purchase order3 = new Purchase(order_time_3, order_date_3, 244.00, status_counter, student);
		orderDa.savePurchase(order3);
		
		ActivityPurchaseDataAccess order_activityDa = new ActivityPurchaseDataAccess();
		ActivityPurchaseId order_activity_1_pk = new ActivityPurchaseId(order1, activity_basketball);
		ActivityPurchase order_activity_1 = new ActivityPurchase(order_activity_1_pk, 5);
		order_activityDa.saveActivityPurchase(order_activity_1);
		
		ActivityPurchaseId order_activity_2_pk = new ActivityPurchaseId(order1, activity_soccer);
		ActivityPurchase order_activity_2 = new ActivityPurchase(order_activity_2_pk, 3);
		order_activityDa.saveActivityPurchase(order_activity_2);
	}
}
