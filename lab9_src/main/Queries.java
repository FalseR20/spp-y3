package lab9_src.main;

public class Queries {
    static final String CLEAR_ALL = """
            DELETE
            FROM session;
            DELETE
            FROM computer;
            DELETE
            FROM room;
            DELETE
            FROM user;
            DELETE
            FROM role;""";
    static final String INSERT_ROLE = """
            INSERT INTO role
            VALUES (1, 'guest', 1),
                   (2, 'admin', 10);""";
    static final String INSERT_USER = """
            INSERT INTO user
            VALUES (1, 'user_guest', 1),
                   (2, 'user_admin', 2);""";
    static final String INSERT_ROOM = """
            INSERT INTO room
            VALUES (1, 'cell');""";
    static final String INSERT_COMPUTER = """
            INSERT INTO computer
            VALUES (1, 'throw away', 1),
                   (2, 'game ready', 1);""";
    static final String INSERT_SESSION = """
            INSERT INTO session (id, user_id, computer_id)
            VALUES (1, 1, 1),
                   (2, 2, 2);""";
    static final String UPDATE_ROOM = """
            UPDATE room
            SET name = 'cs go 2 club'
            WHERE name = 'cell';""";
    static final String DELETE_SESSION = """
            DELETE FROM session
            WHERE computer_id = 1;""";
    static final String DELETE_COMPUTER = """
            DELETE FROM computer
            WHERE name = 'throw away';""";
    static final String SELECT_COMPUTER = """
            SELECT id, name FROM computer;""";
}
