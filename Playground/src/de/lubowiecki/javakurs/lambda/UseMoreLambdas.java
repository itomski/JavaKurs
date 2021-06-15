package de.lubowiecki.javakurs.lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

public class UseMoreLambdas {

	public static void main(String[] args) {
		
		List<User> list = new ArrayList<>();
		list.add(new User("Peter", "Parker"));
		list.add(new User("Bruce", "Wayne"));
		list.add(new User("Steve", "Rogers"));
		
//		change(list, (u, i) -> {
//			String ln = u.getLastname().substring(0, i) + "...";
//			u.setLastname(ln);
//		});
		
		change(list, (u) -> u.setLastname(u.getLastname().toUpperCase()));
		
		System.out.println(list);

	}
	
	public static void change(Collection<User> list, ObjIntConsumer<User> cons) {
		
		for(User u : list) {
			cons.accept(u, 5);
		}
	}
	
	public static void change(Collection<User> list, Consumer<User> cons) {
		
		for(User u : list) {
			cons.accept(u);
		}
	}

}
