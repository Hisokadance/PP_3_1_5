CREATE TABLE IF NOT EXISTS users
(
    id       int primary key AUTO_INCREMENT,
    age      int          not null,
    email    varchar(155) NOT NULL,
    name     varchar(55)  not null,
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

-- Вставляем ROLE_USER, если его еще нет
INSERT INTO roles (name)
SELECT 'ROLE_USER'
WHERE NOT EXISTS (
    SELECT 1 FROM roles WHERE name = 'ROLE_USER'
);

-- Вставляем ROLE_ADMIN, если его еще нет
INSERT INTO roles (name)
SELECT 'ROLE_ADMIN'
WHERE NOT EXISTS (
    SELECT 1 FROM roles WHERE name = 'ROLE_ADMIN'
);

-- Вставляем пользователей, если их еще нет
INSERT INTO users (age, email, name, password)
SELECT 42, 'user@user.ru', 'user', '$2a$12$r/UgXbidDftGfwuZlXVd4eECHJcp1bviAVvcsQPAp0HVtwEBFU3sq'
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE email = 'user@user.ru'
);
INSERT INTO users (age, email, name, password)
SELECT 33, 'admin@admin.ru', 'admin', '$2a$12$VtePqSbEBG0gNKa99GxTJOZxqetVIvuf/vKxHkk7tblicWhLljW5K'
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE email = 'admin@admin.ru'
);
INSERT INTO users (age, email, name, password)
SELECT 17, 'misha@mail.ru', 'misha', '$2a$12$r/UgXbidDftGfwuZlXVd4eECHJcp1bviAVvcsQPAp0HVtwEBFU3sq'
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE email = 'misha@mail.ru'
);
INSERT INTO users (age, email, name, password)
SELECT 24, 'sergey@yandex.ru', 'sergey', '$2a$12$r/UgXbidDftGfwuZlXVd4eECHJcp1bviAVvcsQPAp0HVtwEBFU3sq'
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE email = 'sergey@yandex.ru'
);
INSERT INTO users (age, email, name, password)
SELECT 51, 'ivan@google.com', 'ivan', '$2a$12$r/UgXbidDftGfwuZlXVd4eECHJcp1bviAVvcsQPAp0HVtwEBFU3sq'
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE email = 'ivan@google.com'
);

-- Вставляем записи в таблицу пользователей и их роли, если они еще не существуют
INSERT INTO users_roles (user_id, role_id)
SELECT 1, 1
WHERE NOT EXISTS (
    SELECT 1 FROM users_roles WHERE user_id = 1 AND role_id = 1
);
INSERT INTO users_roles (user_id, role_id)
SELECT 2, 1
WHERE NOT EXISTS (
    SELECT 1 FROM users_roles WHERE user_id = 2 AND role_id = 1
);
INSERT INTO users_roles (user_id, role_id)
SELECT 2, 2
WHERE NOT EXISTS (
    SELECT 1 FROM users_roles WHERE user_id = 2 AND role_id = 2
);
INSERT INTO users_roles (user_id, role_id)
SELECT 3, 1
WHERE NOT EXISTS (
    SELECT 1 FROM users_roles WHERE user_id = 3 AND role_id = 1
);
INSERT INTO users_roles (user_id, role_id)
SELECT 4, 1
WHERE NOT EXISTS (
    SELECT 1 FROM users_roles WHERE user_id = 4 AND role_id = 1
);
INSERT INTO users_roles (user_id, role_id)
SELECT 5, 1
WHERE NOT EXISTS (
    SELECT 1 FROM users_roles WHERE user_id = 5 AND role_id = 1
);

