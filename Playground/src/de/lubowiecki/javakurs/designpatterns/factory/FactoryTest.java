package de.lubowiecki.javakurs.designpatterns.factory;

public class FactoryTest {

	public static void main(String[] args) {
		
		Roboter r1 = Roboter.createStabdard();
		
		try {
			Roboter r2 = Roboter.createNormal(RoboterTyp.SICHERHEIT);
			System.out.println(r2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
