package model.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddressTest {

	@Test
	void testGetNumber() {
		Address address = new Address("flintlock", 1100, 91765, "Diamond Bar", "CA");
		assertTrue(address.getNumber()== 1100);
	}

}
