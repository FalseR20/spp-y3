-- noinspection SqlWithoutWhereForFile

DELETE
FROM session;
DELETE
FROM computer;
DELETE
FROM room;
DELETE
FROM user;
DELETE
FROM role;

INSERT INTO role
VALUES (1, 'guest', 1),
       (2, 'admin', 10);

INSERT INTO user
VALUES (1, 'user_guest', 1),
       (2, 'user_admin', 2);

INSERT INTO room
VALUES (1, 'cell');

INSERT INTO computer
VALUES (1, 'throw away', 1),
       (2, 'game ready', 1);

INSERT INTO session (id, user_id, computer_id)
VALUES (1, 1, 1),
       (2, 2, 2);

UPDATE room
SET name = 'cs go 2 club'
WHERE name = 'cell';

DELETE
FROM session
WHERE computer_id = 1;

DELETE
FROM computer
WHERE name = 'throw away';

SELECT id, name FROM computer;