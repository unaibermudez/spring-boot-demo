-- data.sql

-- Insert sample users
INSERT INTO usuario (name, email) VALUES ('Mudezza', 'unai@example.com');
INSERT INTO usuario (name, email) VALUES ('Jane Smith', 'jane.smith@example.com');
INSERT INTO usuario (name, email) VALUES ('Carlos Lopez', 'carlos.lopez@example.com');
INSERT INTO usuario (name, email) VALUES ('Marta Sanchez', 'marta.sanchez@example.com');
INSERT INTO usuario (name, email) VALUES ('John Doe', 'john.doe@example.com');

-- Insert sample posts
INSERT INTO post (title, content, url, user_id) 
VALUES ('First post', 'This is a post by mudezza', 'https://example.com/first-post.jpg', 1);

INSERT INTO post (title, content, url, user_id)
VALUES ('Second post', 'This is a post by Jane', 'https://example.com/second-post.jpg', 2);

INSERT INTO post (title, content, url, user_id)
VALUES ('Third post', 'This is a post by Carlos', 'https://example.com/third-post.jpg', 3);

INSERT INTO post (title, content, url, user_id)
VALUES ('Fourth post', 'This is a post by Marta', 'https://example.com/fourth-post.jpg', 4);

INSERT INTO post (title, content, url, user_id)
VALUES ('Fifth post', 'This is a post by John', 'https://example.com/fifth-post.jpg', 5);