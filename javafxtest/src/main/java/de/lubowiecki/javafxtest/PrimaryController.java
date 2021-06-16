package de.lubowiecki.javafxtest;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import de.lubowiecki.javafxtest.model.Item;
import de.lubowiecki.javafxtest.model.ItemMapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

// Initializable: stellt eine Methode bereit, die nach dem Einlesen des FXML automatisch aufgerufen wird
public class PrimaryController implements Initializable {
	
	// Wird nur intern im Controller verwendet, daher keine @FXML-Annotation
	//private List<String> items = new ArrayList<>();
	
	private ItemMapper mapper;
	
	public PrimaryController() {
		try {
			mapper = new ItemMapper();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@FXML
	private TableView<Item> tblOutput;
	
	@FXML // die Annotation macht diese Eigenschaft für die GUI sichtbar
	private TextField txtInput;
	
    @FXML
    private void addItem() throws IOException {
    	Item item = new Item();
    	item.setName(txtInput.getText());
    	item.setCount(1);
    	
    	try {
    		if(mapper.save(item)) {
	    		txtInput.clear(); // Leert ein Textfeld
	    		refreshOutput();
    		}
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    private void refreshOutput() {
    	StringBuilder sb = new StringBuilder();
    	try {
    		// Die Tabelle wird mit Item-Objekten in form einer speziellen Liste gefüllt
	    	tblOutput.setItems(FXCollections.observableList(mapper.find(0, 20)));
	    	
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		refreshOutput();
	}
}
