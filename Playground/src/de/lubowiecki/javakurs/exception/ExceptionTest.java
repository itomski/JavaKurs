package de.lubowiecki.javakurs.exception;

import java.io.IOException;

public class ExceptionTest {

	public static void main(String[] args) {
		
		ExceptionTest obj = new ExceptionTest();
		
		try {
			obj.machWas();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	void machWas() throws IOException {
		
	}
	
	void machWasAnderes() {
		
//		try {
//			// KompilerError, da im try keine Code eine IOException (Checked Exception) wirft
//			// Nur bei Kind-Klassen von Exception, aber nicht bei RuntimeException
//		}
//		catch(IOException e) {
//			e.printStackTrace();
//		}
		
	}
	
}
