package com.example.lab4.Connector;

import com.example.lab4.Controllers.HelloController;
import com.example.lab4.Model.Session;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.lab4.Connector.Queries.*;

public class DBConnector {
    private static final String URL = "jdbc:sqlite:db.sqlite";
    public static HelloController helloController;

    public static void setController(HelloController helloController) {
        DBConnector.helloController = helloController;
    }

    private static Connection connect() throws SQLException {
        Connection connection = DriverManager.getConnection(URL);
        System.out.println("Connected to sqlite database");
        return connection;
    }

    public static List<Session> connection() throws SQLException {
        ResultSet result = connect().createStatement().executeQuery(JOIN_ALL);
        List<Session> list = new ArrayList<>();
        while (result.next()) {
            Session session = new Session(
                    result.getString("room"),
                    result.getString("computer"),
                    result.getString("time"),
                    result.getString("user"),
                    result.getString("role"));
            list.add(session);
        }

        return list;
    }

    public static List<String> getAllComputers() throws SQLException {
        return getNameOf(SELECT_COMPUTERS);
    }

    public static List<String> getAllUsers() throws SQLException {
        return getNameOf(SELECT_USERS);
    }

    private static List<String> getNameOf(String selectComputer) throws SQLException {
        List<String> list = new ArrayList<>();
        ResultSet resultSet = connect().createStatement().executeQuery(selectComputer);
        while (resultSet.next()) {
            list.add(resultSet.getString("name"));
        }
        return list;
    }

    public static void insertInfo(Session session) throws SQLException {
        System.out.printf("Session to insert: %s", session);
        Connection connection = connect();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SESSION);
        preparedStatement.setString(1, session.getUser());
        preparedStatement.setString(2, session.getComputer());
        preparedStatement.executeUpdate();
        helloController.onClickRefresh();
    }

    public static void updateInfo(Session session) throws SQLException {
        System.out.printf("Session to update: %s", session);
        Connection connection = connect();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SESSION);
        preparedStatement.setString(1, session.getUser());
        preparedStatement.setString(2, session.getComputer());
        preparedStatement.setString(3, session.getTime());
        preparedStatement.executeUpdate();
        helloController.onClickRefresh();
    }


    public static void deleteInfo(String time) throws SQLException {
        System.out.printf("Session to delete: %s", time);
        Connection connection = connect();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SESSION);
        preparedStatement.setString(1, time);
        preparedStatement.execute();
        helloController.onClickRefresh();
    }
}
