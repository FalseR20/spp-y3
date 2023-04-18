package com.example.lab4.Controllers;

import com.example.lab4.Connector.DBConnector;
import com.example.lab4.Model.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HelloController {

    public TableView<Session> table;
    public ObservableList<Session> listview = FXCollections.observableArrayList();
    public String room;
    public String computer;
    public String time;
    public String user;
    public String role;
    @FXML
    public Button Add;
    @FXML
    public Button Change;
    @FXML
    public Button Delete;
    @FXML
    public Button Refresh;
    @FXML
    public ComboBox roomFilterComboBox;
    @FXML
    public ComboBox computerFilterComboBox;
    @FXML
    public ComboBox userFilterComboBox;
    @FXML
    public ComboBox roleFilterComboBox;
    @FXML
    private TableColumn<Session, String> roomColumn;
    @FXML
    private TableColumn<Session, String> computerColumn;
    @FXML
    private TableColumn<Session, String> timeColumn;
    @FXML
    private TableColumn<Session, String> userColumn;
    @FXML
    private TableColumn<Session, String> roleColumn;
    public HelloController() {
        DBConnector.setController(this);
    }

    @FXML
    void initialize() throws SQLException {
        try {
            listview.addAll(DBConnector.connection());
            for (Session session : listview) {
                System.out.println(session);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        roomColumn.setCellValueFactory(new PropertyValueFactory<>("room"));
        computerColumn.setCellValueFactory(new PropertyValueFactory<>("computer"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        userColumn.setCellValueFactory(new PropertyValueFactory<>("user"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));

        table.setItems(listview);

        table.getSortOrder().add(roomColumn);


        TableView.TableViewSelectionModel<Session> selectionModel = table.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observableValue, oldVal, newVal) -> {
            if (newVal != null) {
                room = newVal.getRoom();
                computer = newVal.getComputer();
                time = newVal.getTime();
                user = newVal.getUser();
                role = newVal.getRole();
            }
        });

        ObservableList<String> computersList = FXCollections.observableArrayList(DBConnector.getAllComputers());
        computersList.add("computer");
        computerFilterComboBox.setItems(computersList);
        computerFilterComboBox.setValue("computer");

        ObservableList<String> usersList = FXCollections.observableArrayList(DBConnector.getAllUsers());
        usersList.add("user");
        userFilterComboBox.setItems(usersList);
        userFilterComboBox.setValue("user");

        ObservableList<String> roomsList = FXCollections.observableArrayList(DBConnector.getAllRooms());
        roomsList.add("room");
        roomFilterComboBox.setItems(roomsList);
        roomFilterComboBox.setValue("room");

        ObservableList<String> rolesList = FXCollections.observableArrayList(DBConnector.getAllRoles());
        rolesList.add("role");
        roleFilterComboBox.setItems(rolesList);
        roleFilterComboBox.setValue("role");

    }


    public void onClickRefresh() throws SQLException {
        listview.clear();
        listview.addAll(DBConnector.connection());
        String computerFilter = (String) computerFilterComboBox.getValue();
        if (!computerFilter.equals("computer")) {
            listview.removeIf(session -> !session.getComputer().equals(computerFilter));
        }
        String userFilter = (String) userFilterComboBox.getValue();
        if (!userFilter.equals("user")) {
            listview.removeIf(session -> !session.getUser().equals(userFilter));
        }
        String roomFilter = (String) roomFilterComboBox.getValue();
        if (!roomFilter.equals("room")) {
            listview.removeIf(session -> !session.getRoom().equals(roomFilter));
        }
        String roleFilter = (String) roleFilterComboBox.getValue();
        if (!roleFilter.equals("role")) {
            listview.removeIf(session -> !session.getRole().equals(roleFilter));
        }
        table.setItems(listview);
        table.getSortOrder().add(roomColumn);
    }

    @FXML
    public void onClickAdd() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/example/lab4/insert.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 400);
            Stage stage = new Stage();
            stage.setTitle("Add Element");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e.getMessage());
        }
    }

    @FXML
    public void onClickChange() throws IOException {
        if (room == null) return;
        FXMLLoader fxmlLoader = new FXMLLoader();
        UpDateController.setSession(room, computer, time, user, role);
        fxmlLoader.setLocation(getClass().getResource("/com/example/lab4/update.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        Stage stage = new Stage();
        stage.setTitle("Update Element");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void onClickDelete() throws SQLException {
        if (time == null) return;
        DBConnector.deleteInfo(time);
    }
}