package com.example.lab4.Controllers;

import com.example.lab4.Connector.DBConnector;
import com.example.lab4.Model.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.sql.SQLException;

public class UpDateController {
    public static String room;
    public static String computer;
    public static String time;
    public static String user;
    public static String role;
    @FXML
    public Button buttonOk;
    @FXML
    public ComboBox<String> computerComboBox;
    @FXML
    public ComboBox<String> userComboBox;
    Session session;

    public static void setSession(String room_, String computer_, String time_, String user_, String role_) {
        room = room_;
        computer = computer_;
        time = time_;
        user = user_;
        role = role_;
    }

    @FXML
    void initialize() throws SQLException {
        ObservableList<String> TypeLIST = FXCollections.observableArrayList(DBConnector.getAllComputers());
        computerComboBox.setItems(TypeLIST);
        computerComboBox.setValue(computer);

        ObservableList<String> NumberLIST = FXCollections.observableArrayList(DBConnector.getAllUsers());
        userComboBox.setItems(NumberLIST);
        userComboBox.setValue(user);
    }

    public void onClickUpdate() throws SQLException {
        if (computerComboBox.getValue() == null || userComboBox.getValue() == null) return;
        session = new Session(computerComboBox.getValue(), time, userComboBox.getValue());
        DBConnector.updateInfo(session);
        Stage stage = (Stage) buttonOk.getScene().getWindow();
        stage.close();
    }
}
