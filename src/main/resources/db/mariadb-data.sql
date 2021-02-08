INSERT INTO users (username, password, name, surname, email, phone)
VALUES ('admin', '{bcrypt}$2a$12$fvbdZJvjnPV/Mw5TlZ33OeeuyhZMQV2hQYNZy2VjEom/bQgci4wW6', 'Goodname', 'Goodsurname',
        'foo@example.org', '+37062318446');

INSERT INTO role (id, role_name)
VALUES (1, 'ADMIN'),
       (2, 'USER'),
       (3, 'MANAGER'),
       (4, 'HELP_DESK'),
       (5, 'ENGINEER');

INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1);

INSERT INTO organizational_units (ou_name)
VALUES ('Sample OU');

UPDATE users
SET ou_id = 1
WHERE id = 1;

INSERT INTO service_request_status (created_at, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 'REGISTERED', CURRENT_TIMESTAMP),
       (CURRENT_TIMESTAMP, 'STARTED', CURRENT_TIMESTAMP),
       (CURRENT_TIMESTAMP, 'CLOSED', CURRENT_TIMESTAMP);

INSERT INTO locations (created_at, name, updated_at, ou_id)
VALUES (CURRENT_TIMESTAMP, 'sample location', CURRENT_TIMESTAMP, 1);

INSERT INTO configuration_item_status (created_at, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 'DECOMMISSIONED', CURRENT_TIMESTAMP),
       (CURRENT_TIMESTAMP, 'OPERATING', CURRENT_TIMESTAMP);

INSERT INTO configuration_items (description, inventory_number, model, name, serial_number, vendor, location_id, ou_id,
                                 status)
VALUES ('sample CI1', 'INV123', 'sample model1', 'name1', 'CN394J392H', 'vendor1', 1, 1, 1),
       ('sample CI2', 'INV124', 'sample model2', 'name2', 'CN394J392F', 'vendor2', 1, 1, 1),
       ('sample CI3', 'INV125', 'sample model3', 'name3', 'CN393J392F', 'vendor3', 1, 1, 1),
       ('sample CI4', 'INV126', 'sample model4', 'name4', 'CN364J392F', 'vendor4', 1, 1, 1);

INSERT INTO ci_sr (ci_id, sr_id)
VALUES (1, 1);