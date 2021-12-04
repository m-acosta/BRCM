package model.business;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import model.entities.Address;
import model.entities.Affiliation;
import model.entities.Customer;
import model.entities.Professor;

class ProfessorBusinessTest {

	@Test
	void testSearchByBroncoId() {
		ProfessorBusiness proffB = new ProfessorBusiness();
		String id = "01";

		String office = "CS-551";
		String research = "AI";
		String department = "CS";
		Professor professor = new Professor(id, office, research, department);

		try {
		assertEquals(professor.toString(), proffB.SearchByBroncoId(id).toString());
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
