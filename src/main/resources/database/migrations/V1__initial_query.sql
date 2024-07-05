CREATE TABLE tb_user_roles (
    id INTEGER NOT NULL AUTO_INCREMENT,
    created_at DATETIME(6),
    updated_at DATETIME(6),
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE tb_users (
    id INTEGER NOT NULL AUTO_INCREMENT,
    created_at DATETIME(6),
    updated_at DATETIME(6),
    email VARCHAR(100) NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT tb_users_unique_email UNIQUE (email)
);

CREATE TABLE tb_users_roles (
    user_id INTEGER NOT NULL,
    roles_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, roles_id),
    CONSTRAINT tb_users_roles_foreign_key_tb_user_roles FOREIGN KEY (roles_id) REFERENCES tb_user_roles (id),
    CONSTRAINT tb_users_roles_foreign_key_tb_users FOREIGN KEY (user_id) REFERENCES tb_users (id)
);

INSERT INTO tb_user_roles (name, created_at, updated_at)
VALUES ("ADMIN", NOW(), NOW()),
    ("USER", NOW(), NOW());