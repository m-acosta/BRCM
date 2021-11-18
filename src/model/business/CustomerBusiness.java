package model.business;

import java.sql.SQLException;

import model.dataccess.CustomerDataAccess;
import model.entities.Customer;
import model.entities.MessageException;

public class CustomerBusiness {
	public static Customer SearchByBroncoId(String bronco_id) throws ClassNotFoundException, SQLException 
	{
		if (bronco_id.equals("")) {
			throw new MessageException("Customer not found.");
		} 
	
		return ((new CustomerDataAccess().getCustomerById(bronco_id)));
	}
	
	public static void CreateCustomer(Customer customer)
	{
		CustomerDataAccess customerDa = new CustomerDataAccess();
		customerDa.saveCustomer(customer);
	}
}
