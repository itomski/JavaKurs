package de.lubowiecki.javafxtest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

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

    private static Parent loadFXML(String fxml) throws IOException {
    	// Hier wird das ResourceBundle an die Oberfläche übergeben
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
    	launch(args);
    }
}