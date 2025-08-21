/** Kem Chan
 * CS320
 * 08/04/2025
 */
package model;

import java.util.List;
import java.util.ArrayList;

public class ContactService {
	int currentIDNum = 0; //pseudo GUID
	
	//create new array list to hold objects
	public static List<Contact> contactList = new ArrayList<Contact>();
	
	//add contact at the system controlled index id
	public void addContact(String firstName, 
							String lastName,
							String phoneNumber,
							String address) {
		String stringID = Integer.toString(currentIDNum);
		Contact newContact = new Contact(stringID, firstName, lastName, phoneNumber, address);
		contactList.add(newContact.getContactID(), newContact);
		
		//increment the ID Num
		++currentIDNum;
	}
	
	//delete contacts as the index ID
	public void deleteContact(String ID) {
		int intID = Integer.valueOf(ID);
		
		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getContactID() == intID) {
				contactList.remove(i);
			}
		}
	}
	
	//edit the first name of contact object at contactID
	public void editFirstName(String contactID, String firstName) {
		for(Contact iter : contactList) {
			if(iter.getContactID() == Integer.valueOf(contactID)) {
				iter.setFirstName(firstName);
			}
		}
	}
	
	//edit the last name on contact object at contactID
	public void editLastName(String contactID, String lastName) {
		for(Contact iter : contactList) {
			if(iter.getContactID() == Integer.valueOf(contactID)) {
				iter.setLastName(lastName);
			}
		}
	}
	
	public void editNumber(String contactID, String phoneNumber) {
		for(Contact iter : contactList) {
			if(iter.getContactID() == Integer.valueOf(contactID)) {
				iter.setPhoneNumber(phoneNumber);
			}
		}
	}
	
	public void editAddress(String contactID, String address) {
		for(Contact iter : contactList) {
			if(iter.getContactID() == Integer.valueOf(contactID)) {
				iter.setAddress(address);
			}
		}
	}
}
