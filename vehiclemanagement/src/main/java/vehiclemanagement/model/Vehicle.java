package vehiclemanagement.model;

public class Vehicle extends AbstractEntity {

	private String nrPlate;
	
	private String brand;
	
	private String model;
	
	private String type;
	
	private int power;
	
	private String color;
	
	private String notice;
	
	private String status;

	public Vehicle() {
	}
	
	public Vehicle(String nrPlate, String brand, String model, String type, int power, String status) {
		this.nrPlate = nrPlate;
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.power = power;
		this.status = status;
	}
	
	public Vehicle(int id, String nrPlate, String brand, String model, String type, int power, String color, String notice,
			String status) {
		this(nrPlate, brand, model, type, power, status);
		setId(id);
		this.color = color;
		this.notice = notice;
	}

	public String getNrPlate() {
		return nrPlate;
	}

	public void setNrPlate(String nrPlate) {
		this.nrPlate = nrPlate;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getStatus() {
		return status;
	}

	// TODO: Setter an vorgegebene Auswahlmöglichkeiten anpassen
	public void setStatus(String status) {
		this.status = status;
	}
}
