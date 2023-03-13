module com.example.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.project to javafx.fxml;
    opens DBUtils to javafx.base;
    exports com.example.project;

}