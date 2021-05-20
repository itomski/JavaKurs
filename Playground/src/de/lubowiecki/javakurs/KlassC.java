package de.lubowiecki.javakurs;

// Top-Level-Klasse
class KlassA {
	
	int i = 10;
	
	// Innere Klasse
	class SubKlasse {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KlassA other = (KlassA) obj;
		if (i != other.i)
			return false;
		return true;
	}
}

// Top-Level-Klassen dürfen nur public oder package-private sein
class KlassB {
	
}

// Es ist nur eine public Klasse pro Source-File erlaubt. Sie ist Namengebend
public class KlassC {
	
}
