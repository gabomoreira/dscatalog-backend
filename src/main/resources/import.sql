INSERT INTO tb_category (name, created_at) VALUES ('Livros', NOW());
INSERT INTO tb_category (name, created_at) VALUES ('Computadores', NOW());
INSERT INTO tb_category (name, created_at) VALUES ('Eletrônicos', NOW());

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Smart TV', 404.50, TIMESTAMP WITH TIME ZONE '2020-07-21T20:59:19Z', 'Lorem', 'Lorem');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Smart TV', 404.50, TIMESTAMP WITH TIME ZONE '2020-07-21T20:59:19Z', 'Lorem', 'Lorem');

INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 3);


INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Gabriel', 'Moreira', 'gabo@gmail.com', '$2a$12$sh3MCQkXuPxXHACfXmuysuVw1Y312HulqaeKB5VDQ7zMxcRV3Pe2e');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Loid', 'Forger', 'loid@gmail.com', '$2a$12$sh3MCQkXuPxXHACfXmuysuVw1Y312HulqaeKB5VDQ7zMxcRV3Pe2e');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);