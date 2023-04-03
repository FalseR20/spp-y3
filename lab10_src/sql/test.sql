SELECT r2.name AS room, c.name AS computer, s.timestamp AS time, u.name AS user, r.name AS role
FROM computer c
         INNER JOIN session s on c.id = s.computer_id
         INNER JOIN user u on u.id = s.user_id
         INNER JOIN role r on r.id = u.role_id
         INNER JOIN room r2 on r2.id = c.room_id;

INSERT INTO session (user_id, computer_id)
VALUES ((SELECT user.id FROM user WHERE user.name = 'Vasia'),
        (SELECT computer.id FROM computer WHERE computer.name = 'Game ready'));

DELETE
FROM session
WHERE id = ?;

UPDATE session
SET user_id     = (SELECT user.id FROM user WHERE user.name = 'Vasia'),
    computer_id = (SELECT computer.id FROM computer WHERE computer.name = 'Game ready')
WHERE timestamp = ?;
