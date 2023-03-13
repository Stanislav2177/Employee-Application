package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.project.StartApplicaton.taskDBUtils;

public class MainController {
    @FXML
    private Button buttonTask;

    @FXML
    private Button buttonEmployee;


    @FXML
    public void openTask(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("taskPage.fxml"));
        Parent root = loader.load();

        TaskController taskController = loader.getController();
        taskController.openDataBase();

        Scene scene = new Scene(root);

        Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentStage.setScene(scene);
    }

    @FXML
    public void openEmployee(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("employeePage.fxml"));
        Parent root = loader.load();

        EmployeeController employeeController = loader.getController();
        employeeController.openDateBase();

        Scene scene = new Scene(root);

        Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentStage.setScene(scene);
    }


    public static void changeScene(ActionEvent event,String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainController.class.getResource(fxml));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentStage.setScene(scene);
    }


}