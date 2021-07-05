package de.lubowiecki.javakurs.designpatterns.abstractfactory;

public class FactoryProvider {

	public static Factory getFactory(Type t) {
		
		switch(t) {
			
			case VAN:
				return new Factory<Van>() {
					@Override
					public Van create() {
						return new Van(Type.VAN);
					}
				};
				
			case MINI:
				return new Factory<Mini>() {

					@Override
					public Mini create() {
						return new Mini();
					}
				};
				
			case LIMO:
				return null;
				
			case ROADSTER:
				return null;
		}
		
		throw new RuntimeException("Falsche Auswahl");
	}	
}
