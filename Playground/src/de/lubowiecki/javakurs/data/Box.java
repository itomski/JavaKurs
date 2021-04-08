package de.lubowiecki.javakurs.data;

public class Box {
	
	// immutable Sequenz von Zeichen
	// final für Objekt heißt, die Referenz darf sich nicht änedrn
	private final String inhalt = new String("");
	
	// mutable Sequenz von Zeichen
	// final für Objekt heißt, die Referenz darf sich nicht änedrn
	private final StringBuilder sb = new StringBuilder(); 

	public String getInhalt() {
		return inhalt;
	}

	public void setInhalt(String inhalt) {
		this.inhalt.concat(inhalt);
		//this.inhalt += inhalt; // Referenz auf ein neues StringObjektes auf dem Heap 
	}

	public String getContent() {
		return sb.toString();
	}

	public void setContent(String str) {
		this.sb.append(str); // Erweiterung des StringBuilder Objektes
	}
}
