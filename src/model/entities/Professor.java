package model.entities;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Professor extends Customer{
	
	private String office;
	private String research;
	private LocalDate department;
	
	public Professor() {}
	
	public Professor(String bronco_id, String fn_ln, LocalDate dob, String phone, Address address, Affiliation affiliation, String office, String research, LocalDate department)
	{
		super(bronco_id, fn_ln, dob, phone, address, affiliation);
		this.setOffice(office);
		this.setResearch(research);
		this.setDepartment(department);
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

	public LocalDate getDepartment() {
		return department;
	}

	public void setDepartment(LocalDate department) {
		this.department = department;
	}


}
