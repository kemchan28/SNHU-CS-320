/**
 * Kem Chan 
 * CS 320
 * 08/04/ 2025
 */
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import model.TaskService;


class TaskServiceTest {
	@AfterEach
	void tearDown() throws Exception{
		TaskService.tasks.clear();
	}
	
	@DisplayName("Add task")
	@Test
	void testAddUniqueTask() {
		String id = "0";
		String fullName = "Greg Tipton";
		String description = "This is a good description";
		
		TaskService tempTask = new TaskService();
		assertEquals(0, TaskService.tasks.size());
		tempTask.addUniqueTask(fullName,  description);
		
		assertTrue(TaskService.tasks.containsKey(id));
		assertEquals(fullName, TaskService.tasks.get(id).getName());
		assertEquals(description, TaskService.tasks.get(id).getDescription());
	}
	
	//add 3 contacts to addTask & delete objects at id 
	//also check if there is no object there
	@DisplayName("Test deleteContact")
	@Test
	void testDeleteTask() {
		String fullName = "Greg Tipton";
		String description = "This is a good description";
		
		TaskService tempTask = new TaskService();
		assertEquals(0, TaskService.tasks.size());
		
		tempTask.addUniqueTask(fullName, description);
		tempTask.addUniqueTask(fullName, description);
		tempTask.addUniqueTask(fullName, description);
		
		assertEquals(3, TaskService.tasks.size());
		tempTask.deleteTasks("1");
		assertEquals(2, TaskService.tasks.size());
		assertFalse(TaskService.tasks.containsKey("1"));
	}
	
	//create task & update with good id
	@DisplayName("Test updateTask with a good ID")
	@Test
	void testUpdateTasks() {
		String id = "0";
		String fullName = "Greg Tipton";
		String description = "This is a good description";
		
		TaskService tempTask = new TaskService();
		tempTask.addUniqueTask(fullName, description);
		tempTask.updateTasks("0", fullName, "New decription");
		
		assertEquals("New description", TaskService.tasks.get(id).getDescription());
		assertEquals(fullName, TaskService.tasks.get(id).getName());
	}
	
	//create task & then update with bad id 
	@DisplayName("Test updateTask with bad id")
	@Test
	void testBadUpdateTasks() {
		String id = "0";
		String fullName = "Greg Tipton";
		String description = "This is a good description";
		
		TaskService tempTask = new TaskService();
		tempTask.addUniqueTask(fullName,  description);
		tempTask.updateTasks("1",  fullName,  "New description");
		
		assertNotEquals("New description", TaskService.tasks.get(id).getDescription());
		assertEquals(fullName, TaskService.tasks.get(id).getName());
	}
}