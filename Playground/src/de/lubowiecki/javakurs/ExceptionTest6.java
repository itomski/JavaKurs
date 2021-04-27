package de.lubowiecki.javakurs;

import java.io.FileNotFoundException;

public class ExceptionTest6 {

	int i; // Standardwert 0
	double d; // 0.0
	Byte b; // null
	
	public static void main(String[] args) {
		
		new SprachErkennung().parse("Das ist ein Haus von Nikigraus...");
		
	}
	
	
	
	

}

class SprachErkennung {
	
	public void parse(String text) throws SpracheNichtBekanntException {
		
		//....
		switch(text) {
		
			default:
				throw new SpracheNichtBekanntException();
		}
	}
}

class SpracheNichtBekanntException extends RuntimeException {
	
	public SpracheNichtBekanntException() {
		//super("Die Sprache konnte nicht erkannt werden.");
	}
}
