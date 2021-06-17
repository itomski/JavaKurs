package de.lubowiecki.javakurs.designpatterns.builder;

// Klasse für ein Immutable Objekt
public class Kurs {

	private final int nr;
	private final String name;
	private final String beschreibung;
	
	public Kurs(int nr, String name, String beschreibung) {
		this.nr = nr;
		this.name = name;
		this.beschreibung = beschreibung;
	}

	public int getNr() {
		return nr;
	}

	public String getName() {
		return name;
	}

	public String getBeschreibung() {
		return beschreibung;
	}
	
	// Builder für die äußere Klasse
	public static class Builder {
		
		private int nr;
		private String name = "";
		private String beschreibung = "";
		
		public int getNr() {
			return nr;
		}
		public Builder setNr(int nr) {
			this.nr = nr;
			return this;
		}
		public String getName() {
			return name;
		}
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public String getBeschreibung() {
			return beschreibung;
		}
		public Builder setBeschreibung(String beschreibung) {
			this.beschreibung = beschreibung;
			return this;
		}
		
		public Kurs build() {
			return new Kurs(nr, name, beschreibung);
		}
	}
}
