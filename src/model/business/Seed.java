package resources;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

import model.dataccess.ActivityDataAccess;
import model.dataccess.AddressDataAccess;
import model.dataccess.AffiliationDataAccess;
import model.dataccess.CustomerDataAccess;
import model.dataccess.OrderActivityDataAccess;
import model.dataccess.OrderDataAccess;
import model.dataccess.ProfessorDataAccess;
import model.dataccess.StatusDataAccess;
import model.dataccess.StudentDataAccess;
import model.entities.Activity;
import model.entities.Address;
import model.entities.Affiliation;
import model.entities.Customer;
import model.entities.Order;
import model.entities.OrderActivity;
import model.entities.Professor;
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
		Student student1 = new Student(student, "CS", "None", graddate1, enterdate1);
		Student student_both = new Student(both, "LIT", "CS", graddate2, enterdate2);
		studentDa.saveStudent(student1);
		studentDa.saveStudent(student_both);
		
		ProfessorDataAccess professorDa = new ProfessorDataAccess();
		Professor professor1 = new Professor(professor, "CS-551", "AI", "CS");
		Professor professor_both = new Professor(both, "LIT-120", "Literature and Medicine", "LIT");
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
		
//		LocalDate order_date_1 = LocalDate.of(2021, 1, 15);
//		@SuppressWarnings("deprecation")
//		Time order_time_1 = new Time(0, 0, 0);
//		
//		LocalDate order_date_2 = LocalDate.of(2021, 1, 20);
//		@SuppressWarnings("deprecation")
//		Time order_time_2 = new Time(1, 1, 1);
		
//		OrderDataAccess orderDa = new OrderDataAccess();
//		Order order1 = new Order(order_time_1, order_date_1, 544, status_online, student);
//		Order order2 = new Order(order_time_2, order_date_2, 144, status_online_complete, student);
//		orderDa.saveOrder(order1);
//		orderDa.saveOrder(order2);
//		
//		
//		OrderActivityDataAccess order_activityDa = new OrderActivityDataAccess();
//		OrderActivity order_activity_1 = new OrderActivity();
//		order_activity_1.setActivity(activity_soccer);
//		order_activity_1.setOrder(order1);
//		order_activity_1.setQuantity(3);
//		order_activityDa.saveOrderActivity(order_activity_1);
		
		
	}
}
