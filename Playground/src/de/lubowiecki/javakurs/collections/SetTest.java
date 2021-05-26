package de.lubowiecki.javakurs.collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		
		// HashBasierterContainer
		Set<Integer> zahlen = new HashSet<>();
		
		zahlen.add(10);
		zahlen.add(15);
		zahlen.add(22);
		zahlen.add(1);
		zahlen.add(128);
		zahlen.add(128);
		zahlen.add(new Integer(22));
		
		zahlen.remove(1);
		
		System.out.println(zahlen);
		
		System.out.println();
		
		Set<Object> objs = new HashSet<>();
		
		Object o = new Object();
		objs.add(o);
		objs.add(new Object());
		objs.add(new Object());
		objs.add(new Object());
		objs.add(o); // Referenz auf ein Objekt, das schon im Set enthalten ist 
		
		System.out.println(objs);
		
		System.out.println();
		
		
		Set<Book> books = new HashSet<>();
		books.add(new Book("978-0201633610"));
		books.add(new Book("978-0321125217"));
		books.add(new Book("978-0321127426"));
		books.add(new Book("978-0201633610"));
		
		System.out.println(books);
		
		// 1. hashCode-Vergleich
		// 2. wenn hashCode gleich, dann equals-Vergleich
		
		books.forEach(b -> System.out.println(b.hashCode()));
		
		Book b1 = new Book("978-0201633610");
		b1.setPages(250);
		
		Book b2 = new Book("978-0201633610");
		b2.setPages(320);
		
		Book b3 = new Book("978-0321127426");
		b3.setPages(122);
		
		//public boolean equals(Object obj)
		System.out.println(b1.equals(b2)); // this ist b1, obj ist b2
		// this ist das Objekt auf dem gerade die Methode aufgerufen wurde
		
		System.out.println(b2.equals(b1)); // this ist b2, obj ist b1
		
		Comparator<Book> isbnComp = (bk1, bk2) -> bk1.getIsbn().compareTo(bk2.getIsbn());
		Comparator<Book> pageComp = (bk1, bk2) -> bk1.getPages() - bk2.getPages();
		books = new TreeSet<>(isbnComp.thenComparing(pageComp));
		books.add(b1);
		books.add(b2);
		books.add(b3);
		
		System.out.println(books);
		
		
	}
}
