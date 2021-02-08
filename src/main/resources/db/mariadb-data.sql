INSERT INTO users (username, password, name, surname, email, phone)
VALUES ('admin', '{bcrypt}$2a$12$fvbdZJvjnPV/Mw5TlZ33OeeuyhZMQV2hQYNZy2VjEom/bQgci4wW6', 'name', 'surname',
        'foo@example.org', '+37062318446');

INSERT INTO ROLE (id, role_name)
VALUES (1, 'ADMIN'),
       (2, 'USER'),
       (3, 'MANAGER'),
       (4, 'HELP_DESK'),
       (5, 'ENGINEER');

INSERT INTO USER_ROLES (user_id, role_id)
VALUES (1, 1);

INSERT INTO organizational_units (ou_name)
VALUES ('ouname');

INSERT INTO service_request_status (created_at, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 'REGISTERED', CURRENT_TIMESTAMP),
       (CURRENT_TIMESTAMP, 'STARTED', CURRENT_TIMESTAMP),
       (CURRENT_TIMESTAMP, 'CLOSED', CURRENT_TIMESTAMP);

INSERT INTO service_requests (created_at, description, summary, updated_at, status, ou_id, owner_id, reported_by)
VALUES (CURRENT_TIMESTAMP, 'some long description 1', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 1, 1),
       (CURRENT_TIMESTAMP, 'some long description 2', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 1, 1),
       (CURRENT_TIMESTAMP, 'some long description 3', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 1, 1),
       (CURRENT_TIMESTAMP, 'some long description 4', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 2, 1),
       (CURRENT_TIMESTAMP, 'some long description 5', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 1, 1),
       (CURRENT_TIMESTAMP, 'some long description 7', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 1, 1),
       (CURRENT_TIMESTAMP, 'some long description 8', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 2, 1),
       (CURRENT_TIMESTAMP, 'some long description 9', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 1, 1),
       (CURRENT_TIMESTAMP, 'some long description 10', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 1, 1),
       (CURRENT_TIMESTAMP, 'some long description 11', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 2, 1),
       (CURRENT_TIMESTAMP, 'some long description 12', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 1, 1),
       (CURRENT_TIMESTAMP, 'some long description 13', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 2, 1),
       (CURRENT_TIMESTAMP, 'some long description 14', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 1, 1),
       (CURRENT_TIMESTAMP, 'some long description 15', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 2, 1),
       (CURRENT_TIMESTAMP, 'some long description 16', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 1, 1),
       (CURRENT_TIMESTAMP, 'some long description 17', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 2, 1),
       (CURRENT_TIMESTAMP, 'some long description 18', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 1, 1),
       (CURRENT_TIMESTAMP, 'some long description 19', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 1, 1),
       (CURRENT_TIMESTAMP, 'some long description 20', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 1, 1),
       (CURRENT_TIMESTAMP, 'some long description 21', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 2, 1),
       (CURRENT_TIMESTAMP, 'some long description 22', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 1, 1),
       (CURRENT_TIMESTAMP, 'some long description 23', 'some short summary', CURRENT_TIMESTAMP, 1, 1, 1, 1);

INSERT INTO locations (created_at, name, updated_at, ou_id)
VALUES (CURRENT_TIMESTAMP, 'coo location', CURRENT_TIMESTAMP, 1);

INSERT INTO configuration_item_status (created_at, name, updated_at)
VALUES (CURRENT_TIMESTAMP, 'DECOMMISSIONED', CURRENT_TIMESTAMP),
       (CURRENT_TIMESTAMP, 'OPERATING', CURRENT_TIMESTAMP);

INSERT INTO configuration_items (description, inventory_number, model, name, serial_number, vendor, location_id, ou_id,
                                 status)
VALUES ('Desc 1', 'INV123', 'model 1', 'Name 1', 'CN394J392H', 'Vendor 1', 1, 1, 1),
       ('Desc 2', 'INV124', 'model 2', 'Name 2', 'CN394J392F', 'Vendor 2', 1, 1, 1),
       ('Desc 3', 'INV125', 'model 3', 'Name 3', 'CN393J392F', 'Vendor 3', 1, 1, 1),
       ('Desc 4', 'INV126', 'model 4', 'Name 4', 'CN364J392F', 'Vendor 4', 1, 1, 1);

INSERT INTO ci_sr (ci_id, sr_id)
VALUES (1, 1),
       (2, 1);

UPDATE users
SET ou_id = 1
WHERE id = 1;


