/**
 * Kem Chan
 * CS 320
 * 07/30/2025
 */

package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import AppointmentClass.AppointmentService;

class AppointmentServiceTest {
	@AfterEach
	void tearDown() throws Exception{
		AppointmentService.appointments.clear();
	}
	
	@DisplayName ("Add appointment")
	@Test
	void testAddUniqueAppt() {
		String id = "1";
		String description = "This is a good description";
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.MONTH, 07);
		c.set(Calendar.DATE, 30);
		c.set(Calendar.YEAR, 2025);
		Date goodDate = c.getTime();
		AppointmentService tempAppt = new AppointmentService();
		
		assertEquals(0, AppointmentService.appointments.size());
		tempAppt.addUniqueAppointment(goodDate,  description);
		
		assertTrue(AppointmentService.appointments.containsKey(id));
		assertEquals(goodDate, AppointmentService.appointments.get(id).getDate());
		assertEquals(description, AppointmentService.appointments.get(id).getDescription());
	}
	
	@DisplayName ("Add bad appointment with empty description")
	@Test
	void testAddEmptyDesc() {
		String id = "0";
		String description = ""; //bad description
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.MONTH, 07);
		c.set(Calendar.DATE, 30);
		c.set(Calendar.YEAR, 2025);
		Date goodDate = c.getTime();
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			AppointmentService tempAppt = new AppointmentService();
			tempAppt.addUniqueAppointment(goodDate, description);
		});
		assertEquals("Invalid description", exception.getMessage());
	}
	
	@DisplayName ("Add bad appointment with null description")
	@Test
	void testAddNullDesc() {
		String id = "0";
		String description = null; //bad description
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.MONTH, 07);
		c.set(Calendar.DATE, 30);
		c.set(Calendar.YEAR, 2025);
		Date goodDate = c.getTime();
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			AppointmentService tempAppt = new AppointmentService();
			tempAppt.addUniqueAppointment(goodDate, description);
		});
		assertEquals("Invalid description", exception.getMessage());
	}
	
	//add 3 contacts into addAppt & delete objects
	//at id 1 check there is no object
	@DisplayName ("Test deleteAppt")
	@Test
	void testDeleteAppt() {
		String id = "0";
		String description = "This is a good description";
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.MONTH, 07);
		c.set(Calendar.DATE, 30);
		c.set(Calendar.YEAR, 2025);
		Date goodDate = c.getTime();
		AppointmentService tempAppt = new AppointmentService();
		
		assertEquals(0, AppointmentService.apppointments.size());
		tempAppt.addUniqueAppointment(goodDate, description); //object 0
		tempAppt.addUniqueAppointment(goodDate, description); //object 1
		tempAppt.addUniqueAppointment(goodDate, description); //object 2
		
		assertEquals(3, AppointmentService.appointments.size());
		tempAppt.deleteAppointment("1");
		
		assertEquals(2, AppointmentService.appointments.size());
		assertFalse(AppointmentService.appointments.containsKey("1"));
		tempAppt.deleteAppointment("1");
		assertEquals(2, AppointmentService.appointments.size());
	}
}
