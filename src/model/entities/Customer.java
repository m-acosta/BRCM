package model.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id
	private String bronco_id;
	private String fn_ln;
	private LocalDate dob;
	private String phone;
	private Address address;
	private Affiliation affiliation;
	
	public Customer() {
		
	}
	
	public Customer(String bronco_id, String fn_ln, LocalDate dob, String phone, Address address, Affiliation affiliation) 
	{
		this.setBronco_id(bronco_id);
		this.setFn_ln(fn_ln);
		this.setDob(dob);
		this.setPhone(phone);
		this.setAddress(address);
		this.setAffiliation(affiliation);
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "title")
	public Affiliation getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(Affiliation affiliation) {
		this.affiliation = affiliation;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
