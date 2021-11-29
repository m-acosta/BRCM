package model.business;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import model.dataccess.PurchaseDataAccess;
import model.entities.Purchase;

public class PurchaseBusiness 
{
	public static List<Purchase> getAllPurchases() throws ClassNotFoundException, SQLException 
	{
		return ((new PurchaseDataAccess().getAllPurchases()));
	}
	
	public static double getCustomerRevenueByID(String bronco_id) throws ClassNotFoundException, SQLException 
	{
		double total = 0.0;
		PurchaseDataAccess purchaseDa = new PurchaseDataAccess();
		List<Purchase> customer_purchases = purchaseDa.getAllPurchasesByCustomerId(bronco_id);
		for(Purchase temp: customer_purchases)
		{
			total += temp.getTotal_price();
		}
		return total;
	}
	
	public static double getCustomerRevenueByDate(String bronco_id, LocalDate date) throws ClassNotFoundException, SQLException 
	{
		double total = 0.0;
		PurchaseDataAccess purchaseDa = new PurchaseDataAccess();
		List<Purchase> customer_purchases = purchaseDa.getAllPurchasesByCustomerDate(bronco_id, date);
		for(Purchase temp: customer_purchases)
		{
			total += temp.getTotal_price();
		}
		return total;
	}
	
	public static void CreatePurchase(Purchase purchase)
	{
		PurchaseDataAccess purchaseDa = new PurchaseDataAccess();
		purchaseDa.savePurchase(purchase);
	}
}
