module de.lubowiecki.javafxtest {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;

    opens de.lubowiecki.javafxtest to javafx.fxml;
    opens de.lubowiecki.javafxtest.model to javafx.fxml, javafx.base;
    exports de.lubowiecki.javafxtest;
}
