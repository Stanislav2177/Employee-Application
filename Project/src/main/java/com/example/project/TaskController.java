package com.example.project;


import DBUtils.Task;
import DBUtils.TaskDBUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TaskController {

    @FXML
    private TableView tableView;

    @FXML
    private TableColumn<Task, Integer> id;

    @FXML
    private TableColumn<Task, String> title;

    @FXML
    private TableColumn<Task, String> description;

    @FXML
    private TableColumn<Task, Date> givenAt;

    @FXML
    private TableColumn<Task, Date> dueDate;

    @FXML
    private TableColumn<Task, String> finishedAt;

    @FXML
    private Button read;

    @FXML
    private Button ascOrder;

    @FXML
    private Button descOrder;

    @FXML
    private Button expiredTasks;

    @FXML
    private Button addTaskButton;

    @FXML
    private TextField textFieldDueDate;

    @FXML
    private TextArea textFieldForDescription;

    @FXML
    private TextField textFieldForId;

    @FXML
    private TextField textFieldForTitle;

    @FXML
    private TextField textFieldDeleteId;

    @FXML
    private Button deleteOneRowButton;

    @FXML
    private Button deleteAllRowsButton;

    @FXML
    private TextField textFieldDeleteOneRowTitle;

    @FXML
    private Button updateButton;

    @FXML
    private TextField textFieldUpdateId;

    @FXML
    private ChoiceBox<String> choiceBox;

    private String[] choices = {"id_assigned_to", "title", "description",
            "given_at", "due_date", "finished_at"};

    @FXML
    private TextField textFieldUpdateNewValue;



    TaskDBUtils taskDBUtils = new TaskDBUtils();

    public void openDataBase(){
        taskDBUtils.openDB();
        choiceBox.getItems().addAll(choices);
    }

    public void readDataFromDB(ActionEvent event){
        ObservableList<Task> list = FXCollections.observableArrayList(taskDBUtils.read());

        displayDataToTableView();

        tableView.setItems(list);
    }

    public void ascOrder(ActionEvent event){
        ObservableList<Task> list = FXCollections.observableArrayList(taskDBUtils.orderByIdAsc());

        displayDataToTableView();

        tableView.setItems(list);
    }

    public void descOrder(ActionEvent event){
        ObservableList<Task> list = FXCollections.observableArrayList(taskDBUtils.orderByIdDesc());

        displayDataToTableView();

        tableView.setItems(list);
    }

    private void displayDataToTableView(){
        id.setCellValueFactory(new PropertyValueFactory<Task, Integer>("id"));
        title.setCellValueFactory(new PropertyValueFactory<Task, String>("title"));
        description.setCellValueFactory(new PropertyValueFactory<Task, String>("description"));
        givenAt.setCellValueFactory(new PropertyValueFactory<Task, Date>("givenAt"));
        dueDate.setCellValueFactory(new PropertyValueFactory<Task, Date>("dueDate"));
        finishedAt.setCellValueFactory(new PropertyValueFactory<Task, String>("finishedAt"));
    }

    public void expiredTasks(ActionEvent event){
        ObservableList<Task> list = FXCollections.observableArrayList(taskDBUtils.displayEmployeesWithExpiredTasks());

        displayDataToTableView();

        tableView.setItems(list);
    }

    public void addTask(ActionEvent event){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(date);
        System.out.println("Current date is: " + formattedDate);

        String dueDate = textFieldDueDate.getText();
        int id = Integer.parseInt(textFieldForId.getText());
        String description = textFieldForDescription.getText();
        String title = textFieldForTitle.getText();

        taskDBUtils.create(id,title,description,formattedDate, dueDate, null);
    }

    public void deleteOneRow(ActionEvent event){
        int id = Integer.parseInt(textFieldDeleteId.getText());
        String title = textFieldDeleteOneRowTitle.getText();

        taskDBUtils.deleteOneRow(id, title);
    }

    public void deleteAllRows(ActionEvent event){
        taskDBUtils.deleteAllRows();
    }

    public void updateRow(ActionEvent event){
        int id = Integer.parseInt(textFieldUpdateId.getText());

        String choice = choiceBox.getValue();

        String newValue = textFieldUpdateNewValue.getText();

        taskDBUtils.update(id, choice, newValue);
    }

}
