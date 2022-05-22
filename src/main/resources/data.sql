INSERT INTO user(id, username, password)
VALUES (1, 'admin', '{noop}asdf'), (2, 'arek', '{noop}asdf');

INSERT INTO user_role(user_id, role)
VALUES(1, 'ROLE_ADMIN'), (1, 'ROLE_USER'), (2, 'ROLE_USER');

INSERT INTO post(name, created_at)
VALUES
('Pierwsza wizyta weterynaryjna', '2021-02-19 15:00'),
('Szczepienia', '2021-02-19 15:01'),
('Psie zabawki top10', '2021-02-19 15:01'),
('Defekacja', '2021-02-19 15:05');