CREATE TABLE users (
                       id INT AUTO_INCREMENT  PRIMARY KEY,
                       login VARCHAR(32) NOT NULL,
                       password VARCHAR(64) NOT NULL,
                       role VARCHAR(32) NOT NULL
);

INSERT INTO users (login, password, role) VALUES
('user', '$2a$10$X4GORrddJTgq5f74NVx/0eI71YBwgVM.Blq62VMqfyCVJDw.r0pWq', 'USER_ROLE'),
('admin', '$2a$10$sCOWGNpwwuDiC2LxL4yvs.PW6IDoh3aD1Kvux8DuoH0tAbNzk4iky', 'ADMIN_ROLE'),
('api', '$2a$10$07GlpoNzvFPq7kEmLzS8SOXYmB383TrKMZFh5e3WnPjgIPoBp5rr6', 'API_ROLE');