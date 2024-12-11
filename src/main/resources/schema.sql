-- schema.sql

-- Create 'usuario' table
CREATE TABLE IF NOT EXISTS usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255)
);

-- Create 'post' table with a foreign key referencing 'usuario'
CREATE TABLE IF NOT EXISTS post (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    content TEXT,
    url VARCHAR(255),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES usuario(id)
);