package vehiclemanagement.model;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Set;

public class User extends AbstractEntity {
	
	private String firstname;
	private String lastname;
	private LocalDate birthDate;
	
	private Set<Vehicle> vehicles = null;
	
	public User() {
	}
	
	public User(int id, String firstname, String lastname, LocalDate birthDate) {
		this.setId(id);
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate = birthDate;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	// Lazy - Daten werden nur bei ausführung dieser Methode geholt
	// wird diese Methode nicht ausgeführt, dann bleibt vehicles mit null belegt;
	public Set<Vehicle> getVehicles() throws SQLException {
		if(vehicles == null) {
			//TODO: Falls diese Methode aufgerufen wird, und eine null drin  ist,
			// Dann heißt es, dass es noch nicht die zugeordneten Vehicle-Objekte aus der DB zeigt
			vehicles = new VehicleMapper().findByUser(this);
			
		}
		return vehicles;
	}

	public void addVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
	}
	
	public void removeVehicle(Vehicle vehicle) {
		this.vehicles.remove(vehicle);
		// TODO: die Verbindung aus aus der DB entfernen
		// TODO: Um ständige Lese- und Schreib-Zugriffe auf die DB zu reduzieren sollte ein Flag verwendet werden,
		// der uns eine Info gibt, ob der aktuelle Zustand des Sets mit der DB synchronisiert wurde
	}
}
