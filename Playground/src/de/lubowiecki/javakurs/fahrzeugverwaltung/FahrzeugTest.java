package de.lubowiecki.javakurs.fahrzeugverwaltung;

import java.util.ArrayList;
import java.util.List;

public class FahrzeugTest {

	public static void main(String[] args) {
		
		// In der Programmierung streben wir nach einer losen Kopplung und hohen Kohesion
		// losen Kopplung: Klassen sind nicht direkt mit anderen Klassen verbunden, sondern über Interfaces
		// hohen Kohesion: Klasse konzentiert sich auf ein Problem
		// Methoden sollten atomare Probleme lösen (atomar = Lösung EINES Problems, dass nicht weiter in Teilprobleme zerlegt werden kann) 
		
		// Interface-Vererbung ist einer Klassen-Vererbung vorzuziehen
		// Wenn ich konkrete ausprogrammierte Methoden oder Eigenschaften erben möchte, muss ich von einer Klasse erben
		// Wenn ich nur einen gemeinsamen Eltern-Typ haben will, sollte ich ein Interface erben
		
		// Interfaces vererben ihre (static) Konstanten aber nicht ihre statischen Methoden
		
		List<Reifen> reifen = new ArrayList<>();
		reifen.add(new Reifen());
		reifen.add(new Reifen());
		reifen.add(new Reifen());
		reifen.add(new Reifen());
		
		Fahrzeug f = new Fahrzeug(new Motor(), reifen, new Radio());
		
		f.getRadio().einschalten();
		System.out.println(f.getRadio().isAn());

		Radio r = f.getRadio();
		
		r.ausschalten();
		System.out.println(r.isAn());
		System.out.println(f.getRadio().isAn());
		
		r.addSender(new Sender("Delta Radio", 95.5));
		r.addSender(new Sender("Radio Hamburg", 92.2));
		
		r.waehleSender(1);
		System.out.println(r);
		r.einschalten();
		
		System.out.println(r);
	}
}

class Fahrzeug {
	
	// HAS-A
	private Motor motor;
	private List<Reifen> reifen;
	private Radio radio;
	
	public Fahrzeug(Motor motor, List<Reifen> reifen, Radio radio) {
		this.motor = motor;
		this.reifen = reifen;
		this.radio = radio;
	}
	
	public Motor getMotor() {
		return motor;
	}
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	
	public List<Reifen> getReifen() {
		return reifen;
	}
	
	public void setReifen(List<Reifen> reifen) {
		this.reifen = reifen;
	}
	
	public Radio getRadio() {
		return radio;
	}
	
	public void setRadio(Radio radio) {
		this.radio = radio;
	}
}

class Motor {
	
	// Eigenschaften des Motor
}

class Reifen {
	
	// Eigenschaften des Reifens
}

class Radio {
	
	private List<Sender> senderListe = new ArrayList<>();
	
	private boolean an;
	
	private Sender gewaehlterSender;

	public void addSender(Sender sender) {
		senderListe.add(sender);
	}
	
	public void waehleSender(int pos) {
		// ArrayIndexOutOfBoundsException abfangen
		gewaehlterSender = senderListe.get(pos);
	}
	
	public boolean isAn() {
		return an;
	}

	public void einschalten() {
		this.an = true;
	}
	
	public void ausschalten() {
		this.an = false;
	}
	
	@Override
	public String toString() {
		return "Radio ist " + ((isAn()) ? ("an, es läuft gerade: " + gewaehlterSender) : "aus");
	}
}

class Sender {
	
	private String name;
	private double frequenz;
	
	public Sender(String name, double frequenz) {
		this.name = name;
		this.frequenz = frequenz;
	}
	
	@Override
	public String toString() {
		return name + " - " + frequenz + " Mhz";
	}
}
