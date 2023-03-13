package com.example.project;

import DBUtils.DepartmentDBUtils;
import DBUtils.EmployeeDBUtils;
import DBUtils.Task;
import DBUtils.TaskDBUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplicaton extends Application {
    static EmployeeDBUtils employeeDBUtils;
    static TaskDBUtils taskDBUtils;
    static DepartmentDBUtils departmentDBUtils;


    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        Scene scene = new Scene(root);

        stage.setTitle("Employee Management System");
        stage.setScene(scene);


        stage.show();
        stage.setOnCloseRequest(event -> logout(stage));
    }

    public static void main(String[] args) {
        launch();
    }

    public void logout(Stage stage){
        /*
          Displays a confirmation dialog box that allows the user to save data before exiting the program.
          If the user clicks the "OK" button, the method closes the database connections and exits the program.
         */
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("logout");
//        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to save before exiting?: ");

        if(alert.showAndWait().get() == ButtonType.YES){
            closeDataBases();
            stage.close();
        }
    }

    public static void openDataBases(){
        employeeDBUtils.openDB();
        taskDBUtils.openDB();
        departmentDBUtils.openDB();
    }
    public void closeDataBases(){
        employeeDBUtils.closeDB();
        taskDBUtils.closeDB();
        departmentDBUtils.closeDB();
    }
}