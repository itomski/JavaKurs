package de.lubowiecki.javafxtest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {
	
	// Wird nur intern im Controller verwendet, daher keine @FXML-Annotation
	private List<String> items = new ArrayList<>();

	@FXML
	private TextArea txtOutput;
	
	@FXML // die Annotation macht diese Eigenschaft für die GUI sichtbar
	private TextField txtInput;
	
    @FXML
    private void addItem() throws IOException {
    	items.add(txtInput.getText());
    	txtInput.clear(); // Leert ein Textfeld
    	refreshOutput();
    }
    
    private void refreshOutput() {
    	StringBuilder sb = new StringBuilder();
    	for(String item : items) {
    		sb.append(item).append("\n");
    	}
    	txtOutput.setText(sb.toString());
    }
}
