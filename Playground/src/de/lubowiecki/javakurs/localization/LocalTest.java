package de.lubowiecki.javakurs.localization;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocalTest {
	
	private final static Logger LOGGER = Logger.getLogger(LocalTest.class.getName());
	
	public static void main(String[] args) {
		
		Instant start = Instant.now();
		
		// Logger Levels
			// SEVERE
			// WARNING
			// INFO
			// CONFIG
			// FINE
			// FINER
			// FINEST
			
		LocalDateTime ldt = LocalDateTime.now();
		//ldt = LocalDateTime.of(2021, 1, 10, 15, 22, 33);
		//System.out.println(ldt);
		LOGGER.setLevel(Level.ALL);
		
		
		ZoneId zone = ZoneId.systemDefault();
		zone = ZoneId.of("Asia/Tokyo");
		//System.out.println(zone);
		LOGGER.warning("Zone: " + zone);
		
		ZonedDateTime zdt1 = ZonedDateTime.of(ldt, zone);
		//System.out.println(zdt1);
		LOGGER.info("ZDT1: " + zdt1);
		
		LOGGER.severe("Problem...");
		
//		ZoneId.getAvailableZoneIds().stream()
//			.filter(z -> z.contains("Asia"))
//			.forEach(System.out::println);
		
//		for(String id : ZoneId.getAvailableZoneIds()) {
//			System.out.println(id);
//		}
		
		Instant end = Instant.now();
		
		Duration d = Duration.between(start, end);
		LOGGER.info(d.toMillis() + "ms");
		
	}

}
