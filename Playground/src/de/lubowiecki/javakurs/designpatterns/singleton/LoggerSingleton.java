package de.lubowiecki.javakurs.designpatterns.singleton;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// JUnit-Test in test-Folder
public final class LoggerSingleton {
	
	private final List<String> log;
	
	private static LoggerSingleton instance;
	
	public static LoggerSingleton getInstance() {
		
		// Lazy-Singleton
		if(instance == null) {
			// TODO threadsicher machen
			instance = new LoggerSingleton();
		}
		return instance;
	}
	
	private LoggerSingleton() {
		log = new ArrayList<>();
	}
	
	public void log(String text) {
		log.add(LocalDateTime.now() + ": " + text);
	}
	
	public int size() {
		return log.size();
	}
	
	public void show() {
		log.forEach(i -> System.out.println(i));
		
//		for(String s : log) {
//			System.out.println(s);
//		}
	}
}
