package de.lubowiecki.javakurs;

public class LoopTest2 {

	public static void main(String[] args) {
		
		// continue und break ist nur für schleifen vorhanden
		// break kann noch mit switch benutzt werden
		
		
		for(int i = 0; i < 100; i++) {
			
			System.out.println();
			System.out.print(i);
			
			if(i % 2 == 0)
				continue; // bricht den aktuellen Durchlauf ab
			
			if(i >= 80)
				break; // bricht das for komplett ab
			
			System.out.print(i);
		}
		
		System.out.println("-------------");
		
		
		// outer
		for(int i = 1; i < 10; i++) {
			
			// Das j des inner-for wird für jeden Durchlauf des outer-for neu mit 0 initialisiert
			// inner
			for(int j = 0; j < 5; j++) {
				
				
				if(i > j)
					continue; // sprint zum nächsten durchlauf von inner-for
					// continue und break beziehen sich auf die Strukturen in ihrer nähe (Ausnahme sind labels)
				
				System.out.println(i + " " + j);
			}
		}
		
		System.out.println("-------------");
		
		app: for(int i = 1; i <= 5; i++) {
			
			
			switch(i) {
				case 1: 
					System.out.println("MO");
					break; // break bezieht sich auf das switch
				
				case 2: 
					System.out.println("DI");
					break;
				
				case 3: 
					System.out.println("CONTINUE");
					continue; // continue bezieht sich auf das for. continue bezieht sich nicht auf switch
				
				case 4:
					System.out.println("BREAK FOR");
					break app; // break bezieht sich auf das for mit dem label app
					
				case 5: 
					System.out.println("MI");
					break;	
			}
			System.out.println("ENDE SWITCH");
		}
		System.out.println("ENDE FOR");
		
		
		System.out.println("-------------");
		
		
		int i = 0;
		do {
			i++;
			
//			if(i > 7)
//				continue;
			
			if(i > 7)
				break;
			
			System.out.println(i);
		}
		while(i < 10);
		
		System.out.println("##" + i);
		
		
	}

}
