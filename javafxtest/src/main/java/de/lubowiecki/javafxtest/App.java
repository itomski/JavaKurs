package de.lubowiecki.javafxtest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
    	
    	// Liste mit Parametern, die an main-Methode gegeben wurden 
    	Parameters params = getParameters();
    	List<String> list = params.getRaw();
    	
    	scene = new Scene(loadFXML("primary"));
    	
//    	System.out.println(((AnchorPane)scene.getRoot()).getPrefHeight());
//    	System.out.println(((AnchorPane)scene.getRoot()).getPrefWidth());
    	
    	stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    private static Locale getSystemLocale() {
//    	Locale.setDefault(Locale.UK);
//    	return Locale.UK;
    	String c = System.getProperty("user.country");
    	return new Locale(String.format("%s_%s", c.toLowerCase(), c.toUpperCase()));
    	
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        ResourceBundle bundle = ResourceBundle.getBundle("lang.ui", getSystemLocale());
        
        // Hier wird das ResourceBundle an die Oberfläche übergeben
        fxmlLoader.setResources(bundle);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
    	launch(args);
    }
}