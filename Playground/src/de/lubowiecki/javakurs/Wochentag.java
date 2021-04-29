package de.lubowiecki.javakurs;

import java.time.LocalTime;

public enum Wochentag {
	
	MO, DI, MI, DO, FR, SA, SO;
	
	static {
		System.out.println("STATIC ENUM INIT");
	}
	
	{
		System.out.println("INSTANCE ENUM INIT");
	}
}
