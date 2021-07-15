package de.lubowiecki.javakurs.designpatterns.prototype;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		GamingComputer gc1 = new GamingComputer(16, 1000);
		GamingComputer gc2 = (GamingComputer) gc1.copy();
		//assertNotEquals(gc1, gc2);
		assertEquals(gc1.getHd(), gc2.getHd());
	}

}
