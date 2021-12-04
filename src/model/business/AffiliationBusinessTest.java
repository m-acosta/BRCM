package model.business;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import model.entities.Affiliation;

class AffiliationBusinessTest {

	@Test
	void testSearchByTitle() {
		AffiliationBusiness affB = new AffiliationBusiness();
		Affiliation aff1 = new Affiliation("Student", 15);
		try {
		assertEquals(aff1.toString(), affB.SearchByTitle("Student").toString());

		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
}
