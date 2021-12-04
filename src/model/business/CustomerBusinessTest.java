package model.business;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import model.entities.Address;
import model.entities.Affiliation;
import model.entities.Customer;

class CustomerBusinessTest {

	@Test
	void testSearchByBroncoId() {
		CustomerBusiness cusB = new CustomerBusiness();
		// this id is the search target id to search
		String id = "00";
		
		// Create an address object with the search target's address values
		Address add1 = new Address("Madison", 115, 95112, "long beach", "California");

		// Create an new affiliation object with the search target's affiliation values
		Affiliation aff1 = new Affiliation("Student", 15);
		
		// create the search target's birthdate object
		LocalDate date1 = LocalDate.of(1991, 1, 14);
		
		// create a Customer object fill with every search target's fields' values
		Customer expectedCustomer = new Customer(id, "Brian Nelson", date1, "9001112222", add1, aff1);
		

		try {
		// search the customer by target's id - "00"
			Customer searchedCustomer = cusB.SearchByBroncoId(id);
			
		// compare to expected object's toString(print out each field to a string)
		// since we cannot assertEquals two objects, because it will assert
		// two objects' addresses if equal to each other, which will always be different,
		// so by assert the toString() value of each customer object to see
		// whether they are of the same value, we can test if we searched the correct customer
			assertEquals(expectedCustomer.toString(), searchedCustomer.toString());
		} 
		catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}

}
