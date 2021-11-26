package model.business;

import java.sql.SQLException;

import model.dataccess.StudentDataAccess;
import model.entities.MessageException;
import model.entities.Student;

public class StudentBusiness 
{
	public static Student SearchByBroncoId(String bronco_id) throws ClassNotFoundException, SQLException 
	{
		if (bronco_id.equals("")) {
			throw new MessageException("Student not found.");
		} 
	
		return ((new StudentDataAccess().getStudentById(bronco_id)));
	}
	
	public static void CreateStudent(Student student)
	{
		StudentDataAccess studentDa = new StudentDataAccess();
		studentDa.saveStudent(student);
	}
}
