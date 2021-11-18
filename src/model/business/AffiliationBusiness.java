package model.business;

import java.sql.SQLException;

import model.dataccess.AffiliationDataAccess;
import model.dataccess.CustomerDataAccess;
import model.entities.Affiliation;
import model.entities.Customer;
import model.entities.MessageException;

public class AffiliationBusiness {
	public static Affiliation SearchByTitle(String title) throws ClassNotFoundException, SQLException 
	{
		if (title.equals("")) {
			throw new MessageException("Affiliation not Found.");
		} 
	
		return ((new AffiliationDataAccess().getAffiliationById(title)));
	}
}
