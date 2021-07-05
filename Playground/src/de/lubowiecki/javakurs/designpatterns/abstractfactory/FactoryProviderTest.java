package de.lubowiecki.javakurs.designpatterns.abstractfactory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FactoryProviderTest {

	@Test
	void testVanFactory() {
		
		Factory f = FactoryProvider.getFactory(Type.VAN);
		Vehicle v = f.create();
		
		String expected = "VAN";
		String actual = v.getType();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testMiniFactory() {
		
		Factory f = FactoryProvider.getFactory(Type.MINI);
		Vehicle v = f.create();
		
		String expected = "MINI";
		String actual = v.getType();
		
		assertEquals(expected, actual);
	}

}
