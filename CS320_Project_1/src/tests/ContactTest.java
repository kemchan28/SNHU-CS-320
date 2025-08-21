/** Kem Chan
 * CS320
 * 08/04/2025
 */
package tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.Contact;

class ContactTest {
	//test constructors with good behavior
	@DisplayName("Test a valid constructor")
	@Test
	public void testGoodConstructor() {
		String contactID = "1";
		String firstName = "Greg";
		String lastName = "Hoffman";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";
		
		Contact testContact = new Contact(contactID, firstName, lastName, phoneNumber, address);
			assertEquals(1, testContact.getContactID());
			assertEquals(firstName, testContact.getFirstName());
			assertEquals(lastName, testContact.getLastName());
			assertEquals(phoneNumber, testContact.getPhoneNumber());
			assertEquals(address, testContact.getAddress());
	}
	
	//test constructor with invalid phoneNumber length
	@DisplayName("Test invalid constructor")
	@Test
	public void testBadConstructor() {
		String contactID = "2";
		String firstName = "Greg";
		String lastName = "Hoffman";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact(contactID, firstName, lastName, phoneNumber, address);
		});
	}
	
	//test firstName with good input
	@DisplayName("Test a valid setFirstName")
	@Test
	public void testGoodSetFirst() {
		String contactID = "3";
		String firstName = "Greg";
		String lastName = "Hoffman";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";
		
		Contact testContact = new Contact(contactID, firstName, lastName, phoneNumber, address);
		testContact.setFirstName("Test");
			assertEquals("Test", testContact.getFirstName());
	}
	
	//test firstName with a null string this should throw an error
	@DisplayName("Test an invalid null setFirstName")
	@Test
	public void testBadSetFirst() {
		String contactID = "3";
		String firstName = "Greg";
		String lastName = "Hoffman";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";
		
		Contact testContact = new Contact(contactID, firstName, lastName, phoneNumber, address);
		Assertions.assertThrows(IllegalArgumentException.class, () -> { 
			testContact.setFirstName(null);
		});
	}
	
	//test firstName to see if length is too long should throw and exception
	@DisplayName("Test invalid length setFirstName")
	@Test
	public void testLongSetFirst() {
		String contactID = "3";
		String firstName = "Greg";
		String lastName = "Hoffman";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";
		
		Contact testContact = new Contact(contactID, firstName,lastName,phoneNumber, address);
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			testContact.setFirstName("IamWayTooLongForFirstName");
		});
	}
	
	//test getID by using good constructor then evaluate returned integer
	@DisplayName("Test getID")
	@Test
	public void testGetID() {
		String contactID = "3";
		String firstName = "Greg";
		String lastName = "Hoffman";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";
		
		Contact testContact = new Contact(contactID, firstName, lastName, phoneNumber, address);
			assertEquals(3, testContact.getContactID());
	}
	
	//test getID by using good conductor then evaluate the string that is not returned
	@DisplayName("Test bad getID")
	@Test
	public void testBadGetID1() {
		String contactID = "3";
		String firstName = "Greg";
		String lastName = "Hoffman";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";
		
		Contact testContact = new Contact(contactID, firstName, lastName, phoneNumber, address);
			assertEquals("3", testContact.getContactID());
	}
	
	//test getID using ID that is tool long for constructor
	@DisplayName("Test too long getID")
	@Test
	public void testLongGetID() {
		String contactID = "3";
		String firstName = "Greg";
		String lastName = "Hoffman";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact(contactID, firstName, lastName, phoneNumber, address);
		});
	}
	
	//test setLastName with a null string which should throw an error
	@DisplayName("Test invalid null setLastName")
	@Test
	public void testBadSetLast() {
		String contactID = "3";
		String firstName = "Greg";
		String lastName = "Hoffman";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";
		
		Contact testContact = new Contact(contactID, firstName, lastName, phoneNumber, address);
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			testContact.setLastName(null);
		});
	}
	
	//test setLastName with length too long which throw exception
	@DisplayName("Test invalid length setLastName")
	@Test
	public void testLongSetLast() {
		String contactID = "3";
		String firstName = "Greg";
		String lastName = "Hoffman";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";
		
		Contact testContact = new Contact(contactID, firstName, lastName, phoneNumber, address);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setLastName("IamWayTooLongOfALastName");
		});
	}
	
	//test setLastName with good input
	@DisplayName("Test valid setLastName")
	@Test
	public void testBadGetID() {
		String contactID = "3";
		String firstName = "Greg";
		String lastName = "Hoffman";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";
		
		Contact testContact = new Contact(contactID, firstName, lastName, phoneNumber, address);
		testContact.setLastName("Test");
		assertEquals("Test", testContact.getLastName());
	}
	
	//test setPhoneNUmber with null string should throw an error
	@DisplayName("Test invalid null setPhoneNumber")
	@Test
	public void testBadSetPhone() {
		String contactID = "3";
		String firstName = "Greg";
		String lastName = "Hoffman";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";
		
		Contact testContact = new Contact(contactID, firstName, lastName, phoneNumber, address);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setPhoneNumber(null);
		});
	}
	
	//test setPhone within length !=10 which should throw exception
	@DisplayName("Test invalid length setPhoneNumber")
	@Test
	public void testWrongLengthPhone() {
		String contactID = "3";
		String firstName = "Greg";
		String lastName = "Hoffman";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";
		
		Contact testContact = new Contact(contactID, firstName, lastName, phoneNumber, address);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setPhoneNumber("1");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setPhoneNumber("1234567890112131415");
		});
	}
	
	//test setPhone with length 10
	@DisplayName("Test valid length setPhoneNumber")
	@Test
	public void testGoodPhone() {
		String contactID = "3";
		String firstName = "Greg";
		String lastName = "Hoffman";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";
		
		Contact testContact = new Contact(contactID, firstName, lastName, phoneNumber, address);
		testContact.setPhoneNumber("1987654321");
		assertEquals("1987654321", testContact.getPhoneNumber());
	}
	
	//test address with null string which should throwException
	@DisplayName("Test invalid null address")
	@Test
	public void testNullSetAddress() {
		String contactID = "3";
		String firstName = "Greg";
		String lastName = "Hoffman";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";
		
		Contact testContact = new Contact(contactID, firstName, lastName, phoneNumber, address);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setAddress(null);
		});
	}
	
	//test setAddress with length > 30, should throw exception
	@DisplayName("Test invalid setPhoneNumber")
	@Test
	public void testWrongLengthAddress() {
		String contactID = "3";
		String firstName = "Greg";
		String lastName = "Hoffman";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";
		
		Contact testContact = new Contact(contactID, firstName, lastName, phoneNumber, address);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setAddress("123456789 Address Waaaaaaayyyyyyyyyy Tooooooo Long Street");
		});
	}
	
	//test setAddress with good input
	@DisplayName("Test valid length setAddress")
	@Test
	public void testGoodAddress() {
		String contactID = "3";
		String firstName = "Greg";
		String lastName = "Hoffman";
		String phoneNumber = "1234567891";
		String address = "123 Main Street";
		
		Contact testContact = new Contact(contactID, firstName, lastName, phoneNumber, address);
		testContact.setAddress("987 Good Address");
		assertEquals("987 Good Address", testContact.getAddress());
	}
}
