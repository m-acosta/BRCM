package model.entities;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Student extends Customer{
	
	private String minor;
	private String major;
	private LocalDate grade_date;
	private LocalDate enter_date;
	
	public Student() {}
	
	public Student(String bronco_id, String fn_ln, LocalDate dob, String phone, Address address, Affiliation affiliation, String minor, String major, LocalDate grade_date, LocalDate enter_date)
	{
		super(bronco_id, fn_ln, dob, phone, address, affiliation);
		this.setMinor(minor);
		this.setMajor(major);
		this.setGrade_date(grade_date);
		this.setEnter_date(enter_date);
	}

	public String getMinor() {
		return minor;
	}

	public void setMinor(String minor) {
		this.minor = minor;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public LocalDate getGrade_date() {
		return grade_date;
	}

	public void setGrade_date(LocalDate grade_date) {
		this.grade_date = grade_date;
	}

	public LocalDate getEnter_date() {
		return enter_date;
	}

	public void setEnter_date(LocalDate enter_date) {
		this.enter_date = enter_date;
	}

}
