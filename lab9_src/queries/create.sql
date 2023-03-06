CREATE TABLE role
(
    id    INTEGER PRIMARY KEY AUTOINCREMENT,
    name  TEXT,
    level INTEGER
);

CREATE TABLE user
(
    id      INTEGER PRIMARY KEY AUTOINCREMENT,
    name    TEXT,
    role_id INTEGER REFERENCES role
);

CREATE TABLE room
(
    id   INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT
);

CREATE TABLE computer
(
    id      INTEGER PRIMARY KEY AUTOINCREMENT,
    name    TEXT,
    room_id INTEGER REFERENCES room
);

CREATE TABLE session
(
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id     INTEGER REFERENCES user,
    computer_id INTEGER REFERENCES computer,
    timestamp   TEXT DEFAULT (datetime('now','localtime'))
);

DROP TABLE session;
