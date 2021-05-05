package de.lubowiecki.javakurs.designpatterns.singleton;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoggerSingletonTest {

	@Test
	public void testSame() {
		
		LoggerSingleton s1 = LoggerSingleton.getInstance();
		LoggerSingleton s2 = LoggerSingleton.getInstance();
		
		assertSame(s1, s2);
	}
	
	@Test
	public void testSize() {
		
		LoggerSingleton s1 = LoggerSingleton.getInstance();
		LoggerSingleton s2 = LoggerSingleton.getInstance();
		s1.log("Bla bla bla...");
		s2.log("Xyz...");
		
		assertTrue(s1.size() == 2);
		assertTrue(s2.size() == 2);
	}
}
