package model.business;

import java.sql.SQLException;
import java.util.List;

import model.dataccess.CustomerDataAccess;
import model.entities.Customer;
import model.entities.MessageException;

public class CustomerBusiness 
{
	public static Customer SearchByBroncoId(String bronco_id) throws ClassNotFoundException, SQLException 
	{
		if (bronco_id.equals("")) {
			throw new MessageException("Customer not found.");
		} 
	
		return ((new CustomerDataAccess().getCustomerById(bronco_id)));
	}
	
	public static List<Customer> GetAllCustomers() throws ClassNotFoundException, SQLException 
	{
		return ((new CustomerDataAccess().getAllCustomers()));
	}
	
	public static void CreateCustomer(Customer customer)
	{
		CustomerDataAccess customerDa = new CustomerDataAccess();
		customerDa.saveCustomer(customer);
	}
}
