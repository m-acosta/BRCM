package model.business;

import java.sql.SQLException;
import java.util.List;

import model.dataccess.PurchaseDataAccess;
import model.entities.Purchase;

public class PurchaseBusiness 
{
	public static List<Purchase> getAllPurchases() throws ClassNotFoundException, SQLException 
	{
		return ((new PurchaseDataAccess().getAllPurchases()));
	}

}
