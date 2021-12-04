package model.business;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import model.entities.Professor;
import model.entities.Student;

class StudentBusinessTest {

	@Test
	void testSearchByBroncoId() {
		StudentBusiness stB = new StudentBusiness();
		String bronco_id = "00";

		String minor = "CS";
		String major = "None";
		LocalDate gradeDate = LocalDate.of(2024, 1, 14);
		LocalDate enterDate = LocalDate.of(2019, 1, 14);
		
		Student expectStudent = new Student(bronco_id, minor, major, gradeDate, enterDate);

		try {
			Student actualStudent = stB.SearchByBroncoId(bronco_id);
			assertEquals(expectStudent.toString(), actualStudent.toString());
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
}
