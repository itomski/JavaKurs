package de.lubowiecki.javakurs.localization;

import java.util.ListResourceBundle;

// Bei gleichen Nmen ist ListResourceBundle wichtiger als PropertyResourceBundle
public class ui_en extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			//{"key", "value"},
			{"welcome", "hi"},
			{"question", "How is your name"},
			{"thanks", "Thank you"},
			{"answer", "Your name is"}
			// Fehlende Schlüssel werden aus dem default-File geladen
		};
	}
}