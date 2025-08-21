/**
 * Kem Chan 
 * CS 320
 * July 22, 2025
 */

package Tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import TaskClass.Task;

class TaskTest {
	//good constructor
	@DisplayName("Good constructor")
	@Test
	void goodConstructor() {
		String id = "1";
		String fullName = "Greg Tipton";
		String description = "This is a good description";
		
		Task tempTask = new Task(id, fullName, description);
		
		assertEquals(1, tempTask.getUniqueID());
		assertEquals(fullName, tempTask.getName());
		assertEquals(description, tempTask.getDescription());
	}
	
	//invalid constructor with description too long
	@DisplayName("Invalid constructor")
	@Test
	void invalidConstructor() {
		String id = "1";
		String fullName = "Greg Tipton";
		String description = "This is an invalid description because it is tooo long & does not work";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(id, fullName, description);
		});
	}
	
	//invalid constructor with long ID
	@DisplayName("Invalid constructor with long ID")
	@Test
	void invalidIDConstruct() {
		String id = "12345678910111213";
		String fullName = "Greg Tipton";
		String description = "description";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(id, fullName, description);
		});
	}
	
	//invalid constructor with null id
	@DisplayName("Invalid constructor with no ID")
	@Test
	void invalidNullConstructor() {
		String id = null;
		String fullName = "Greg Tipton";
		String description = "description";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(id, fullName, description);
		});
	}
	
	//test setFullName with good input
	@DisplayName("Test valid setName")
	@Test
	public void testGoodName() {
		String id = "1";
		String fullName = "Greg Tipton";
		String description = "This is an valid description";
		
		Task tempTask = new Task(id, fullName, description);
		tempTask.setName("Test Name");
		assertEquals("Test Name", tempTask.getName());
	}
	
	//test setFullName with null input
	@DisplayName("Test invalid null setName")
	@Test
	public void testNullName() {
		String id = "1";
		String fullName = "Greg Tipton";
		String description = "This is an valid description";
		
		Task tempTask = new Task(id, fullName, description);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			tempTask.setName(null);
		});
	}
	
	//test setFullName with long input
	@DisplayName("Test invalid long setName")
	@Test
	public void testLongName() {
		String id = "1";
		String fullName = "Greg Tipton";
		String description = "This is an valid description";
		
		Task tempTask = new Task(id, fullName, description);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			tempTask.setName("This name is really long, is this real");
		});
	}
	
	//test setFullName with empty string
	@DisplayName("Test invalid with empty setName")
	@Test
	public void testEmptyName() {
		String id = "1";
		String fullName = "Greg Tipton";
		String description = "This is an valid description";
		
		Task tempTask = new Task(id, fullName, description);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			tempTask.setName("");
		});
	}
	
	//test setDescription with empty string
	@DisplayName("Test invalid empty description")
	@Test
	public void testEmptyDescription() {
		String id = "1";
		String fullName = "Greg Tipton";
		String description = "";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(id, fullName, description);
		});
	}
	
	//test setDescription with null string
	@DisplayName("test invalid empty description")
	@Test
	public void testNullDescription() {
		String id = "1";
		String fullName = "Greg Tipton";
		String description = null;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(id, fullName, description);
		});
	}
}
