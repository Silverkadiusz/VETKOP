INSERT INTO user(id, username, password)
VALUES (1, 'admin', '{noop}asdf'), (2, 'arek', '{noop}asdf');

INSERT INTO user_role(user_id, role)
VALUES(1, 'ROLE_ADMIN'), (1, 'ROLE_USER'), (2, 'ROLE_USER');