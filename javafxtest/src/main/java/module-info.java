module de.lubowiecki.javafxtest {
    requires javafx.controls;
    requires javafx.fxml;

    opens de.lubowiecki.javafxtest to javafx.fxml;
    exports de.lubowiecki.javafxtest;
}
