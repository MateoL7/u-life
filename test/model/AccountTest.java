package model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AccountTest {
	
	private Account a;
	
	
	public void setupScenary1() {
		a = new Account("JP","123",19,87.0,183.0,"male","JP","Juan");
	}

	@Test
	void testAddActivity() {
		setupScenary1();
		a.addActivity("correr", 30, 1);
		a.addActivity("gym", 0, 2);
		String actividad = a.getFirstActivity().getName();
		String actividad2 = a.getFirstActivity().getNext().getName();
		assertTrue(actividad.equals("correr")&&actividad2.equals("gym"),"algo salio mal");
	}
	@Test
	void testAddSport() {
		setupScenary1();
		a.addSport("Football", 30, 1, 300, SportType.RUN);
		a.addSport("Basketball",30, 1,400,SportType.BASKETBALL);
		Sport s1 = new Sport("Football", 30, 1, 300, SportType.RUN);
		Sport s2 = new Sport("Basketball",30, 1,400,SportType.BASKETBALL);
		assertTrue(s1.getName().equals(a.getFirstActivity().getName())&&s2.getName().equals(a.getFirstActivity().getNext().getName()),"No es el mismo objeto");
	}
	@Test
	void testAddAlarm() {
		setupScenary1();
		a.addAlarm(12, 20, "PM");
		a.addAlarm(4, 30, "AM");
	    String time1 = a.getRootAlarm().getLeft().getTime();
	    String time2 = a.getRootAlarm().getTime();
	    assertTrue(time1.equals("AM")&& time2.equals("PM"),"no se asigno bien los datos");
	}
	@Test
	void testShowAlarm() {
		setupScenary1();
		String message = a.showAlarms();
		assertTrue(!message.isEmpty(),"no se recolecto correctamente los datos");
	}
	
	@Test
	void testCheckAlarm() {
		setupScenary1();
		a.addAlarm(5, 20, "5:20PM");
		String msg = a.checkAlarm(5, 20);
		assertTrue(msg.equals("Activated"),"no se activo la alarma correctamente");
	}
	
	@Test
	void testShowActivity() {
		setupScenary1();
		String message = a.showActivities();
		assertTrue(!message.isEmpty(),"no se recolecto correctamente los datos");
	}

}
