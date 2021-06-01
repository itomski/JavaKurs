package de.lubowiecki.javakurs.io;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;

import static java.nio.file.StandardWatchEventKinds.*;
import java.nio.file.WatchService;


public class BayWatch {

	public static void main(String[] args) {
		
		
		Path path = Paths.get(System.getProperty("user.home") + "/Desktop/bay");
		
		try {
			WatchService mitch = path.getFileSystem().newWatchService();
			WatchKey key = path.register(mitch, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
			
			while(true) {
				for(WatchEvent<?> event : key.pollEvents()) {
					System.out.println(event.kind() + ": " + event.context());
				}
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
