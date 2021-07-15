package de.lubowiecki.javakurs.designpatterns.adapter;

public class UsbAnschluss {
	
	private UsbStecker verbraucher;
	
	public void connect(UsbStecker verbraucher) {
		this.verbraucher = verbraucher;
	}
	
	public String transferData() {
		return "Empfangen: " + verbraucher.getUsbData();
	}
}
