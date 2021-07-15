package de.lubowiecki.javakurs.designpatterns.chainofresponsibility;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class AbstractUserFilterTest {
	
	@Test
	void testAgeFilter_alt_genug() {
		User u = new User("Peter", "Parker", LocalDate.of(1975, 12, 21), Privileg.READ);
		AbstractUserFilter filter = new AgeUserFilter();
		boolean actual = filter.check(u);
		assertTrue(actual);
	}
	
	@Test
	void testAgeFilter_nicht_alt_genug() {
		User u = new User("Peter", "Parker", LocalDate.of(2003, 12, 21), Privileg.READ);
		AbstractUserFilter filter = new AgeUserFilter();
		boolean actual = filter.check(u);
		assertFalse(actual);
	}
	
	@Test
	void testAgeFilter_alt_genug_write() {
		User u = new User("Peter", "Parker", LocalDate.of(1975, 12, 21), Privileg.WRITE);
		
		AbstractUserFilter filter1 = new AgeUserFilter();
		AbstractUserFilter filter2 = new PrivilegUserFilter(Privileg.WRITE);
		AbstractUserFilter filter3 = new PrivilegUserFilter(Privileg.READ);
		
		filter2.setNextFilter(filter3);
		filter1.setNextFilter(filter2);
		
		boolean actual = filter1.check(u);
		assertTrue(actual);
	}

}
