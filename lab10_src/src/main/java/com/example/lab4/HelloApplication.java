package com.example.lab4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/lab4/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 540);
        stage.setTitle("Lab10");
        stage.setScene(scene);
        stage.show();

    }
}