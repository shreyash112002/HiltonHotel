module com.example.hiltonhotel {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;


    opens com.example.hiltonhotel to javafx.fxml;
    exports com.example.hiltonhotel;
}