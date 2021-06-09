package vehiclemanagement.model;

public enum Status {
	
	// TODO: Bessere Lösung finden
	UNBEKANNT(0), EINSATZBEREIT(1), PFLEGE(2), KAPUTT(3), WERKSTATT(4);
	
	private final int id;
	
	Status(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public static Status getById(int id) {
		
		if(id < 0 || id > Status.values().length)
			return Status.UNBEKANNT;
		
		return Status.values()[id];
	}
}
