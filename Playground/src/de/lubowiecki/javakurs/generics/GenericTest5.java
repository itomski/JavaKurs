package de.lubowiecki.javakurs.generics;

import java.util.List;
import java.util.function.Predicate;

public class GenericTest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConcreteGenI cgi = new ConcreteGenI(); 
		
		// Generische Methode: Der generische Typ für S wird beim Methoden-Aufruf aus dem Eingangsparameter ausgelesen
		cgi.machWasGanzAnderes(100);
		cgi.machWasGanzAnderes("Hallo Welt");
		
	}

}

interface GenI<T> {
	
	void machWas(T t);
	
	<S> T machWasGanzAnderes(S s); // Generische Methode mit einem eigenen generischen Typ
	
	T machWasAnderes(List<T> list);
	
	String machWasGanzAnderes2(Predicate<?> s);
}


// Platzhalter werden in Klammern direkt neben dem Klassen bzw. Interfacenamen deklariert, links
class ConcreteGenI implements GenI<String> {

	@Override
	public void machWas(String t) {
		// TODO Auto-generated method stub
		
	}

	// S ein Platzhalter für einen generischer Typ, der nur für diese Methode gilt
	@Override
	public <S> String machWasGanzAnderes(S s) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String machWasAnderes(List<String> list) {
		// TODO Auto-generated method stub
		return null;
	} // String ist hier kein Platzhalter sondern der konkrete Typ String

	@Override
	public String machWasGanzAnderes2(Predicate<?> s) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
