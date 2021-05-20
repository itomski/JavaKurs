package de.lubowiecki.javakurs;

public class InterfaceTest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BBBBB b = new CCCCC();
		System.out.println(b.zahl); // 100 - Eigenschaften werden auf der Referenz ausgeführt
		b.showZahl();

	}

}

interface AAAAA {
	
	default void machWas() {
		System.out.println("AAAAA");
	}
	
}

interface BBBBB extends AAAAA {
	
	int zahl = 100; // public static final 
	
	@Override
	void machWas();
	
	@Override
	String toString();
	
	void showZahl();
	
}

class CCCCC implements BBBBB {
	
	int zahl = 200; // package-private, nicht final

	@Override
	public void machWas() { // Muss eingebaut werden, weil die default Methode aus AAAAA in BBBBB abstrakt überschrieben wurden 
		zahl += 100;
	}
	
	public void showZahl() { // Muss eingebaut werden, weil die default Methode aus AAAAA in BBBBB abstrakt überschrieben wurden 
		System.out.println(zahl);
	}
	
}