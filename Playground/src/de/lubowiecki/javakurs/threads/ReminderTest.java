package de.lubowiecki.javakurs.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ReminderTest {

	public static void main(String[] args) {
		
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		// Falls eine Aufgabe länger dauert, wird die nächste Aufgabe direkt im Anschluß an die verhergehende ausgeführt
		//service.scheduleAtFixedRate(new Reminder(), 10, 10, TimeUnit.SECONDS);
		
		// Falls eine Aufgabe länger dauert, wird die nächste Aufgabe im einem vorgegebenen Abstand nach dem Ende der vorhergehenden ausgeführt
		service.scheduleWithFixedDelay(new Reminder(), 10, 10, TimeUnit.SECONDS);
		
	}
}

class Reminder implements Runnable {

	@Override
	public void run() {
		System.out.println("Bitte denke daran deine E-Mails zu verschicken!");
	}
	
}
