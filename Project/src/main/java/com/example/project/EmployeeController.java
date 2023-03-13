package com.example.project;

import DBUtils.Employee;
import DBUtils.EmployeeDBUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;

public class EmployeeController {
    EmployeeDBUtils employeeDBUtils = new EmployeeDBUtils();

    @FXML
    private TableColumn<Employee, Integer> id;

    @FXML
    private TableColumn<Employee, String> fullName;

    @FXML
    private TableColumn<Employee, String> email;

    @FXML
    private TableColumn<Employee, String> phoneNumber;

    @FXML
    private TableColumn<Employee, Date> dateOfBirth;

    @FXML
    private TableColumn<Employee, Date> dateOfAdding;

    @FXML
    private TableColumn<Employee, Double> salary;

    @FXML
    private TableColumn<Employee, Integer> completedTasks;

    @FXML
    private TableColumn<Employee, Integer> department;

    @FXML
    private Button readButton;

    @FXML
    private TableView tableView;

    @FXML
    private Button displayTop;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField textFieldDeleteId;

    @FXML
    private TextField textFieldCreateId;

    @FXML
    private TextField textFieldCreateName;

    @FXML
    private TextField textFieldCreateEmail;

    @FXML
    private TextField textFieldCreateDOB;

    @FXML
    private TextField textFieldCreateDOA;

    @FXML
    private TextField textFieldCreateSalary;

    @FXML
    private TextField textFieldCreateDId;

    @FXML
    private TextField textFieldCreatePhNumber;

    @FXML
    private Button createButton;

    @FXML
    private Button updateButton;

    @FXML
    private TextField textFieldUpdateId;

    @FXML
    private TextField textFieldUpdateNewValue;

    @FXML
    private ChoiceBox choiceBox;

    private String[] choices = {"id", "full_name", "email",
            "phone_number", "date_of_birth", "date_of_adding", "salary", "completed_tasks", "department_id"};

    public void openDateBase(){
        employeeDBUtils.openDB();
        choiceBox.getItems().addAll(choices);
    }

    public void displayDataToTableView(){
        id.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        fullName.setCellValueFactory(new PropertyValueFactory<Employee, String>("fullName"));
        email.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<Employee, String>("phoneNumber"));
        dateOfBirth.setCellValueFactory(new PropertyValueFactory<Employee, Date>("dateOfBirth"));
        dateOfAdding.setCellValueFactory(new PropertyValueFactory<Employee, Date>("dateOfAdding"));
        salary.setCellValueFactory(new PropertyValueFactory<Employee, Double>("salary"));
        completedTasks.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("completedTasks"));
        department.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("department"));
    }

    public void readDataFromDB(ActionEvent event){
        ObservableList<Employee> list = FXCollections.observableArrayList(employeeDBUtils.read());

        displayDataToTableView();

        tableView.setItems(list);
    }

    public void displayTopEmployees(ActionEvent event){
        ObservableList<Employee> list = FXCollections.observableArrayList(employeeDBUtils.displayTop5());

        displayDataToTableView();

        tableView.setItems(list);
    }

    public void deleteEmployee(ActionEvent event){
        int id = Integer.parseInt(textFieldDeleteId.getText());
        employeeDBUtils.delete(id);
    }

    public void createEmployee(ActionEvent event){
        int id = Integer.parseInt(textFieldCreateId.getText());
        String name = textFieldCreateName.getText();
        String email = textFieldCreateEmail.getText();
        String phone = textFieldCreatePhNumber.getText();
        String dateOfBirth = textFieldCreateDOB.getText();
        String dateOfAdding = textFieldCreateDOA.getText();
        double salary = Double.parseDouble(textFieldCreateSalary.getText());
        int depId = Integer.parseInt(textFieldCreateDId.getText());

        employeeDBUtils.create(id, name, email, phone, dateOfBirth, dateOfAdding, salary, depId);
    }

    public void updateRow(ActionEvent event){
        String parameter = (String) choiceBox.getValue();
        int id = Integer.parseInt(textFieldUpdateId.getText());
        String newValue = textFieldUpdateNewValue.getText();
        employeeDBUtils.update(id, parameter,newValue);
    }

}
