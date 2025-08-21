/**
 * Kem Chan
 * CS 320
 * 08/04/2025
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import java.util.Date;
import java.util.Calendar;
import org.junit.jupiter.api.Test;

import model.Appointment;

class AppointmentTest {
	@DisplayName ("Test good constructor")
	@Test
	void testAppointment() {
		String id = "1";
		Calendar c = Calendar.getInstance();
		String description = "This is a good description";
		
		c.set(Calendar.MONTH, 07);
		c.set(Calendar.DATE, 30);
		c.set(Calendar.YEAR, 2025);
		
		Date goodDate = c.getTime();
		Appointment tempAppt = new Appointment(id, goodDate, description);
		
		assertEquals(1, tempAppt.getUniqueID());
		assertEquals(goodDate, tempAppt.getDate());
		assertEquals(description, tempAppt.getDescription());
	}
	
	@DisplayName ("Test bad constructor id is too long")
	@Test
	void testBadAppointment() {
		String id = "123456789101112";
		Date date = new Date();
		String description = "This is a good decription";
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(id, date, description);
		});
		assertEquals("Invalid ID", exception.getMessage());
	}
	
	@DisplayName ("Test bad constructor id null")
	@Test
	void testBadIDNull() {
		String id = null;
		Date date = new Date();
		String description = "This is a good description";
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(id, date, description);
		});
		assertEquals("Invalid ID", exception.getMessage());
	}
	
	@DisplayName ("Test bad constructor past date")
	@Test
	void testBadeDate() {
		String id = "1";
		Calendar c = Calendar.getInstance();
		String description = "This is a good description";
		
		c.set(Calendar.MONTH, 07);
		c.set(Calendar.DATE, 30);
		c.set(Calendar.YEAR, 2025);
		
		Date badDate = c.getTime();
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(id, badDate, description);
		});
		assertEquals("Invalid ID", exception.getMessage());
	}
	
	@DisplayName ("Test bad constructor null date")
	@Test
	void testNullDate() {
		String id = "1";
		String description = "This is a good description";
		Date badDate = null;
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.MONTH, 07);
		c.set(Calendar.DATE, 30);
		c.set(Calendar.YEAR, 2025);
		
		Date goodDate = c.getTime();
		Appointment tempAppt = new Appointment(id, goodDate, description);
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(id, badDate, description);
		});
		assertEquals("Invalid date", exception.getMessage());
		exception = assertThrows(IllegalArgumentException.class, () -> {
			tempAppt.setDate(null);
		});
		assertEquals("Invalid date", exception.getMessage());
	}
	
	@DisplayName ("Test bad description too long")
	@Test
	void testLongDesc() {
		String id = "1";
		String description = "This description is way too long to be valid & can cause an error";
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.MONTH, 07);
		c.set(Calendar.DATE, 30);
		c.set(Calendar.YEAR, 2025);
		
		Date goodDate = c.getTime();
		Appointment tempAppt = new Appointment(id, goodDate, "test");
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(id, goodDate, description);
		});
		assertEquals("Invalid description", exception.getMessage());
		exception = assertThrows(IllegalArgumentException.class, () -> {
			tempAppt.setDescription(description);
		});
		assertEquals("Invalid description", exception.getMessage());
	}
	
	@DisplayName ("Test bad description null")
	@Test
	void testNullDesc() {
		String id = "1";
		String description = null;
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.MONTH, 07);
		c.set(Calendar.DATE, 30);
		c.set(Calendar.YEAR, 2025);
		Date goodDate = c.getTime();
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(id, goodDate, description);
		});
		assertEquals("Invalid description", exception.getMessage());
	}
	
	@DisplayName ("Test bad description is empty")
	@Test
	void testEmptyDesc() {
		String id = "1";
		String description = "";
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.MONTH, 07);
		c.set(Calendar.DATE, 30);
		c.set(Calendar.YEAR, 2025);
		Date goodDate = c.getTime();
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(id, goodDate, description);
		});
		assertEquals("Invalid description", exception.getMessage());
	}
}
