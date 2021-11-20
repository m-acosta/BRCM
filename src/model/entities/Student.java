package model.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student{
	
	@Id
	@Column(name = "bronco_id")
	private String bronco_id;
	private String minor;
	private String major;
	private LocalDate grade_date;
	private LocalDate enter_date;
	
	public Student() {}
	
	public Student(String bronco_id, String minor, String major, LocalDate grade_date, LocalDate enter_date)
	{
		this.setBroncoId(bronco_id);
		this.setMinor(minor);
		this.setMajor(major);
		this.setGrade_date(grade_date);
		this.setEnter_date(enter_date);
	}
	
	public void setBroncoId(String bronco_id)
	{
		this.bronco_id = bronco_id;
	}
	
	public String getBroncoId() {
		return bronco_id;
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
