package de.lubowiecki.javakurs;

import java.lang.reflect.Field;

public class ReflectionTest {
	
	public static void main(String[] args) {
		
		Field[] fields = Person.class.getDeclaredFields();
		for(Field f : fields) {
			f.setAccessible(true);
			System.out.println(f.getName() + ": " + f.getType());
		}
		
		// Repository (Spring)
		// EntityManager (JPA)
	}
}
