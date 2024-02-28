CREATE TABLE IF NOT EXISTS users
(
    id       int primary key AUTO_INCREMENT,
    age      int         not null,
    email    varchar(155) NOT NULL,
    name     varchar(55) not null,
    password varchar(255) not null
);

CREATE TABLE IF NOT EXISTS roles
(
    id   int primary key AUTO_INCREMENT,
    name varchar(55) not null
);

CREATE TABLE IF NOT EXISTS users_roles
(
    user_id int,
    role_id int,
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

INSERT INTO roles (name)
VALUES ('ROLE_USER');
INSERT INTO roles (name)
VALUES ('ROLE_ADMIN');

INSERT INTO users (age, email, name, password)
VALUES (42, 'user@user.ru', 'user', '$2a$12$r/UgXbidDftGfwuZlXVd4eECHJcp1bviAVvcsQPAp0HVtwEBFU3sq');
INSERT INTO users (age, email, name, password)
VALUES (33, 'admin@admin.ru', 'admin', '$2a$12$VtePqSbEBG0gNKa99GxTJOZxqetVIvuf/vKxHkk7tblicWhLljW5K');
INSERT INTO users (age, email, name, password)
VALUES (17, 'misha@mail.ru', 'misha', '$2a$12$r/UgXbidDftGfwuZlXVd4eECHJcp1bviAVvcsQPAp0HVtwEBFU3sq');
INSERT INTO users (age, email, name, password)
VALUES (24, 'sergey@yandex.ru', 'sergey', '$2a$12$r/UgXbidDftGfwuZlXVd4eECHJcp1bviAVvcsQPAp0HVtwEBFU3sq');
INSERT INTO users (age, email, name, password)
VALUES (51, 'ivan@google.com', 'ivan', '$2a$12$r/UgXbidDftGfwuZlXVd4eECHJcp1bviAVvcsQPAp0HVtwEBFU3sq');

INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1);

INSERT INTO users_roles (user_id, role_id)
VALUES (2, 1);
INSERT INTO users_roles (user_id, role_id)
VALUES (2, 2);
INSERT INTO users_roles (user_id, role_id)
VALUES (3, 1);
INSERT INTO users_roles (user_id, role_id)
VALUES (4, 1);
INSERT INTO users_roles (user_id, role_id)
VALUES (5, 1);
