package de.lubowiecki.javakurs;

public class ExceptionTest6 {

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
