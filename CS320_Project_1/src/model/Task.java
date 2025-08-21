package model;
/**
 * Kem Chan 
 * CS 320
 * 08/04/ 2025
 */



public class Task {
	private String uniqueID;
	private String fullName;
	private String description;
	
	//validate uniqueID
	private final boolean validateID(String uniqueID) {
		if(uniqueID == null || uniqueID.length() > 10) {
			return false;
		}
		return true;
	}
	
	//validates name
	private final boolean validateName(String fullName) {
		if(fullName == null || fullName.length() > 20 || fullName.equals("")) {
			return false;
		}
		return true;
	}
	
	//validate description
	private final boolean validateDescription(String description) {
		if(description == null || description.length() > 50 || description.equals("")) {
			return false;
		}
		return true;
	}
	
	public Task(String uniqueID, String fullName, String description) {
		if(!this.validateID(uniqueID)) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if(!this.validateName(fullName)) {
			throw new IllegalArgumentException("Invalid name");
		}
		
		if(!this.validateDescription(description)) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		setID(uniqueID);
		setName(fullName);
		setDescription(description);
	}
	
	public int getUniqueID() {
		return Integer.valueOf(uniqueID);
	}
	
	public void setID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	
	public String getName() {
		return fullName;
	}
	
	public void setName(String fullName) {
		if(!this.validateName(fullName)) {
			throw new IllegalArgumentException("Invalid name");
		}
		this.fullName = fullName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		if(!this.validateDescription(fullName)) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.description = description;
	}
	
}