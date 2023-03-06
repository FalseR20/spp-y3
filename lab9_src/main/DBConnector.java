package lab9_src.main;

import java.sql.*;

public class DBConnector {
    static final String URL = "jdbc:sqlite:db.sqlite";
    Connection con;
    Statement stmt;

    public DBConnector() throws SQLException {
        con = DriverManager.getConnection(URL);
        stmt = con.createStatement();
    }

    void clear() throws SQLException {
        stmt.executeUpdate(Queries.CLEAR_ALL);
    }

    public void insert_default_values() throws SQLException {
        stmt.executeUpdate(Queries.INSERT_ROLE);
        stmt.executeUpdate(Queries.INSERT_USER);
        stmt.executeUpdate(Queries.INSERT_ROOM);
        stmt.executeUpdate(Queries.INSERT_COMPUTER);
        stmt.executeUpdate(Queries.INSERT_SESSION);
    }

    public void update() throws SQLException {
        stmt.executeUpdate(Queries.UPDATE_ROOM);
    }

    public void delete() throws SQLException {
        stmt.executeUpdate(Queries.DELETE_COMPUTER);
        stmt.executeUpdate(Queries.DELETE_SESSION);
    }

    public void select_and_print() throws SQLException {
        ResultSet resultSet = stmt.executeQuery(Queries.SELECT_COMPUTER);
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.printf("%d. computer: '%s'\n", id, name);
        }
    }
}