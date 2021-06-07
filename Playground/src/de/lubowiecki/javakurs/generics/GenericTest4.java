package de.lubowiecki.javakurs.generics;

import java.util.LinkedList;
import java.util.Queue;

public class GenericTest4 {

	public static void main(String[] args) {
		
		// Konkrete Typen werden erst bei der Instanzierung eingesetzt
		
		Xyz<String>  xyz1 = new Xyz<>();
		xyz1.machWas("Moin");
		
		Xyz<Integer>  xyz2 = new Xyz<>();
		xyz2.machWas(101);
		
		Xyz<User> xyz3 = new Xyz<>();
		xyz3.machWas(new User());
		
		Xyz xyz4 = new Xyz(); // RawType: Object, Unsave

	}
}

// Platzhalter wird einmalig festgelegt
class Xyz<String> { // String ist hier als Platzhalter vorgestellt und wird in dieser Klasse nicht als String sondern als generischer Typ verwendet
	
	void machWas(String t) {
	}
}

//Platzhalter wird einmalig festgelegt
class Xyz2<T, R> {
	
	R machWas(T t) {
		return null;
	}
}

//Container-Klasse
class Xyz3<E> {
	
	private Queue<E> warteschlange = new LinkedList<>(); // LinkedList ist sowohl eine List als auch eine Deque (und Queue)
	
	public boolean add(E e) {
		return warteschlange.offer(e);
	}
	
	public E get() {
		return warteschlange.poll();
	}
}
