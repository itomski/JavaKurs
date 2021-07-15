package de.lubowiecki.javakurs.designpatterns.prototype;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OtherPrototypeTest {

	@Test
	void test() {
		OtherPrototype p1 = new OtherPrototype();
		try {
			OtherPrototype p2 = (OtherPrototype) p1.clone();
			assertNotEquals(p1, p2);
		} 
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
