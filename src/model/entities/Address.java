package model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address 
{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int address_id;
	private String street;
	private int number;
	private int zip_code;
	private String city;
	private String state;
	
	public Address() {}
	
	public Address(String street, int number, int zip_code, String city, String state)
	{
		this.setStreet(street);
		this.setNumber(number);
		this.setCity(city);
		this.setZip_code(zip_code);
		this.setState(state);
	}
	
	public int getAddress_id()
	{
		return this.address_id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getZip_code() {
		return zip_code;
	}

	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
