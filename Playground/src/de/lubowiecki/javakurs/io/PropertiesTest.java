package de.lubowiecki.javakurs.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertiesTest {
	
	public static void main(String[] args) {
		
		Properties prop = new Properties();
//		prop.put("user", "root");
//		prop.put("password", "geheim");
//		prop.put("host", "localhost");
		
		// Properties aus der Datei einlesen
		try(FileReader in = new FileReader("conf.properties")) {
			prop.load(in);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(prop.get("user"));
		
		Iterator itr = prop.entrySet().iterator();
		while(itr.hasNext()) {
			Entry e = (Entry) itr.next();
			System.out.println(e.getKey() + " " + e.getValue());
		}
		
		// Properties in Datei speichern
//		try(FileWriter out = new FileWriter("conf.properties")) {
//			prop.store(out, "Frische Werte...");
//		}
//		catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		// XML-Variante benötigt ein FileOutputStream, FileInputStream
		// Schreiben
		try(FileOutputStream out = new FileOutputStream("conf.xml")) {
			prop.storeToXML(out, "Frische Werte...", "UTF-8");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		Properties nextProp = new Properties();
		
		// Lesen
		try(FileInputStream in = new FileInputStream("conf.xml")) {
			nextProp.loadFromXML(in);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(nextProp);
	}
}
