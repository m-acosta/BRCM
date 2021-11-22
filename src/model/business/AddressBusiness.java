package model.business;

import model.dataccess.AddressDataAccess;
import model.entities.Address;

public class AddressBusiness 
{
	public static void CreateAddress(Address address)
	{
		AddressDataAccess addressDa = new AddressDataAccess();
		addressDa.saveAddress(address);
	}
}
