package model.business;

import java.sql.SQLException;

import model.dataccess.ProfessorDataAccess;
import model.entities.MessageException;
import model.entities.Professor;

public class ProfessorBusiness 
{
	public static Professor SearchByBroncoId(String bronco_id) throws ClassNotFoundException, SQLException 
	{
		if (bronco_id.equals("")) {
			throw new MessageException("Professor not found.");
		} 
	
		return ((new ProfessorDataAccess().getProfessorById(bronco_id)));
	}
	
	public static void CreateProfessor(Professor professor)
	{
		ProfessorDataAccess professorDa = new ProfessorDataAccess();
		professorDa.saveProfessor(professor);
	}
}
