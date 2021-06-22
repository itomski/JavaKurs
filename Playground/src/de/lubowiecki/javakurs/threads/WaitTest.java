package de.lubowiecki.javakurs.threads;

public class WaitTest {

	public static void main(String[] args) {
		
		Object o = new Object();
		
		try {
			// wait = Es wird auf einen LOCK gewartet
			o.wait(); // IllegalMonitorStateException: Monitor ist ähnlich wie eine Warteliste
			// Liegt die Warteliste nicht vor, kommt es zu einer IllegalMonitorStateException
			// Diese "Warteliste" wird nur in Synchronisationsblöcken bereitgestellt
			
			// notify = Es wird nicht mehr auf ein LOCK gewaretet 
			o.notify();
			
			// Uberall, wo es im Zusamenhang mit Threads zu Verzögerungen kommen kann 
			// muss eine InterruptedException behandelt werden
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
