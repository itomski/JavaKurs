package de.lubowiecki.javakurs.designpatterns.adapter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UsbAnschlussTest {

	@Test
	void testLightningToUsb() {
		
		UsbAnschluss anschluss = new UsbAnschluss();
		LightningStecker stecker = new LightningStecker();
		
		anschluss.connect(new AdapterLightningAufUsb(stecker));
		
		String expected = "Empfangen: Daten als Lightning-Stream";
		String actual = anschluss.transferData();
		
		assertEquals(expected, actual);
	}
}
