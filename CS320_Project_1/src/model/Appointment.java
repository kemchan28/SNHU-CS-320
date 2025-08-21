/**
 * Kem Chan
 * CS 320
 * 08/04/2025
 */
package model;

import java.util.Date;

public class Appointment {
	private String uniqueID;
	private Date date;
	private String description;
	
	//validate uniqueID
	private final boolean validateID (String uniqueID) {
		if (uniqueID == null || uniqueID.length() > 10) {
			return false;
		}
		return true;
	}
	
	//validates Name
	private final boolean validateDate (Date _date) {
		if (_date == null || _date.before(new Date())) {
			return false;
		}
		return true;
	}
	
	//validate description
	private final boolean validateDescription (String description) {
		if (description == null || description.length() > 50 || description.equals("")) {
			return false;
		}
		return true;
	}
	
	public Appointment (String uniqueID, Date date, String description) {
		if(!this.validateID(uniqueID)){
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if(!this.validateDate(date)){
			throw new IllegalArgumentException("Invalid date");
		}
		
		if(!this.validateDescription(description)){
			throw new IllegalArgumentException("Invalid description");
		}
		
		setID (uniqueID);
		setDate (date);
		setDescription (description);
	}
	
	public int getUniqueID() {
		return Integer.valueOf(uniqueID);
	}
	
	private void setID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate (Date date) {
		if(!this.validateDate(date)) {
			throw new IllegalArgumentException ("Invalid date");
		}
		this.date = date;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		if(!this.validateDescription(description)){
			throw new IllegalArgumentException ("Invalid description");
		}
		this.description = description;
	}
	
}
