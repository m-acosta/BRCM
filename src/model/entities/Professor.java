package model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="professor")
public class Professor{
	
	@Id
	@Column(name = "bronco_id")
	private String bronco_id;
	private String office;
	private String research;
	private String department;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "bronco_id")
	private Customer customer;
	
	public Professor() {}
	
	public Professor(Customer customer, String office, String research, String department)
	{
		this.setCustomer(customer);
		this.setOffice(office);
		this.setResearch(research);
		this.setDepartment(department);
	}
	
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
	
	public String getCustomer() {
		return customer.getBronco_id();
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getResearch() {
		return research;
	}

	public void setResearch(String research) {
		this.research = research;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


}
