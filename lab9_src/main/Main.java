package lab9_src.main;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DBConnector connector = new DBConnector();
        connector.clear();
        connector.insert_default_values();

        System.out.println("Computers before:");
        connector.select_and_print();

        connector.update();
        connector.delete();

        System.out.println("Computers after:");
        connector.select_and_print();

    }
}
