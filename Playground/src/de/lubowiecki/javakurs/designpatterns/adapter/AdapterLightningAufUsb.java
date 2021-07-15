package de.lubowiecki.javakurs.designpatterns.adapter;

public class AdapterLightningAufUsb implements UsbStecker {

	private LightningStecker verbraucher;
	
	public AdapterLightningAufUsb(LightningStecker verbraucher) {
		this.verbraucher = verbraucher;
	}

	@Override
	public String getUsbData() {
		return verbraucher.getLightningData();
	}
}