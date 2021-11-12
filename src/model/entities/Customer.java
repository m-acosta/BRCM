package model.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private String bronco_id;
	private String fn_ln;
	private LocalDate dob;
	private String phone;
	private int address_id;
	private String title;
	
	public Customer() {
		
	}
	
	public Customer(String bronco_id, String fn_ln, LocalDate dob, String phone, int address_id, String title) 
	{
		this.setBronco_id(bronco_id);
		this.setFn_ln(fn_ln);
		this.setDob(dob);
		this.setPhone(phone);
		this.setAddress_id(address_id);
		this.setTitle(title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob2) {
		this.dob = dob2;
	}

	public String getFn_ln() {
		return fn_ln;
	}

	public void setFn_ln(String fn_ln) {
		this.fn_ln = fn_ln;
	}

	public String getBronco_id() {
		return bronco_id;
	}

	public void setBronco_id(String bronco_id) {
		this.bronco_id = bronco_id;
	}

}
