/**
 * Kem Chan
 * CS 320
 * 07/30/2025
 */

package AppointmentClass;

import java.util.HashMap;
import java.util.Date;

public class AppointmentService {
	int currentIDNum = 0; //pseudo GUID
	public static HashMap<String, Appointment> appointments = new HashMap<String, Appointment>();
	
	public void addUniqueAppointment(Date _date, String _description) {
		String stringID = Integer.toString(currentIDNum);
		Appointment tempAppointment = new Appointment(stringID, _date, _description);
		appointments.put(stringID,  tempAppointment);
		++currentIDNum;
	}
	
	public void deleteAppointment(String _ID) {
		if(appointments.containsKey(_ID)) {
			appointments.remove(_ID);
		}
	}
}
