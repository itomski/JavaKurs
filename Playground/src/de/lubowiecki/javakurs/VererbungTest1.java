package de.lubowiecki.javakurs;

import java.io.IOException;

public class VererbungTest1 {

	public static void main(String[] args) {
		
		try {
			Thing t = new Thing();
			t.execute();
			
			t = new SpecialThingA(); // IS-A
			t.execute();
			
			t = new SpecialThingB(); // IS-A
			t.execute();
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class Thing {
	
	void execute() throws Exception {
		System.out.println(getClass().getSimpleName() + "::execute()");
	}
}

class SpecialThingA extends Thing {
	
	// Beim Überschreiben: Keine Exc, gleiche Exc, Kind-Exc, oder neu RuntimeExceptions
	@Override
	public void execute() {
		System.out.println(getClass().getSimpleName() + "::execute() #");
	}
}

class SpecialThingB extends Thing {
	
	@Override
	protected void execute() throws IOException {
		System.out.println(getClass().getSimpleName() + "::execute() @");
	}
}