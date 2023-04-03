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


public class FromInsertDBController {

    @FXML
    public Button buttonOk;
    @FXML
    public ComboBox<String> computerComboBox;
    @FXML
    public ComboBox<String> userComboBox;
    @FXML
    Session session;

    @FXML
    void initialize() {
        try {
            ObservableList<String> TypeLIST = FXCollections.observableArrayList(DBConnector.getAllComputers());
            computerComboBox.setItems(TypeLIST);

            ObservableList<String> NumberLIST = FXCollections.observableArrayList(DBConnector.getAllUsers());
            userComboBox.setItems(NumberLIST);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void onClickInsert() throws SQLException {
        if (computerComboBox.getValue() == null || userComboBox.getValue() == null) return;
        session = new Session(computerComboBox.getValue(), userComboBox.getValue());
        DBConnector.insertInfo(session);
        Stage stage = (Stage) buttonOk.getScene().getWindow();
        stage.close();
    }
}
