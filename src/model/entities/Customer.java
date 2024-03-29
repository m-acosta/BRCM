package model.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@Column(name ="bronco_id")
	private String bronco_id;
	private String fn_ln;
	private LocalDate dob;
	private String phone;
	
	@ManyToOne
    @JoinColumn(name="address_id", nullable=false)
	private Address address;
	
	@OneToOne
    @JoinColumn(name="title", nullable=false)	
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
	
	public Affiliation getAffiliation() {
		return this.affiliation;
	}

	public void setAffiliation(Affiliation affiliation) {
		this.affiliation = affiliation;
	}
	
	public int getAddress() {
		return address.getAddress_id();
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

	@Override
	public String toString() {
		return "Customer [bronco_id=" + bronco_id + ", fn_ln=" + fn_ln + ", dob=" + dob + ", phone=" + phone
				+ ", address=" + address + ", affiliation=" + affiliation + "]";
	}

}
