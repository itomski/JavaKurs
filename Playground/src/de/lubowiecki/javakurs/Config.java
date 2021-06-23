package de.lubowiecki.javakurs;

public enum Config {
	
	CONF1, CONF2, CONF3;
	
	@Override
	public String toString() {
		
		switch(this) {
			case CONF1:
				return "...";
				
			case CONF2:
				return "....";
				
			case CONF3:
				return "......";
				
			default:
				return "..";
		}
	}

}
