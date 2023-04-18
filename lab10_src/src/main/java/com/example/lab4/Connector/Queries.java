package com.example.lab4.Connector;

public class Queries {
    static final String JOIN_ALL = "SELECT r2.name AS room, c.name AS computer, s.timestamp AS time, u.name AS user, r.name AS role\n" +
            "FROM computer c\n" +
            "    INNER JOIN session s on c.id = s.computer_id\n" +
            "    INNER JOIN user u on u.id = s.user_id\n" +
            "    INNER JOIN role r on r.id = u.role_id\n" +
            "    INNER JOIN room r2 on r2.id = c.room_id;\n" +
            "\n";
    static final String SELECT_COMPUTERS = "SELECT name FROM computer;";
    static final String SELECT_USERS = "SELECT name FROM user;";
    static final String SELECT_ROOMS = "SELECT name FROM room;";
    static final String SELECT_ROLES = "SELECT name FROM role;";
    static final String INSERT_SESSION = "INSERT INTO session (user_id, computer_id)\n" +
            "VALUES ((SELECT user.id FROM user WHERE user.name = ?),\n" +
            "        (SELECT computer.id FROM computer WHERE computer.name = ?));";
    static final String DELETE_SESSION = "DELETE FROM session WHERE timestamp = ?;";
    static final String UPDATE_SESSION = "UPDATE session\n" +
            "SET user_id     = (SELECT user.id FROM user WHERE user.name = ?),\n" +
            "    computer_id = (SELECT computer.id FROM computer WHERE computer.name = ?)\n" +
            "WHERE timestamp = ?;";

}
