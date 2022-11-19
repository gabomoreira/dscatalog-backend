INSERT INTO tb_category (name, created_at) VALUES ('Livros', NOW())
INSERT INTO tb_category (name, created_at) VALUES ('Computadores', NOW())
INSERT INTO tb_category (name, created_at) VALUES ('Eletrônicos', NOW())


INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Smart TV', 404.50, TIMESTAMP WITH TIME ZONE '2020-07-21T20:59:19Z', 'Lorem', 'Lorem');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Smart Ledg', 1000.34, TIMESTAMP WITH TIME ZONE '2020-07-21T20:59:19Z', 'Lorem', 'Lorem');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Notebook Lenovo S145', 3100.90, TIMESTAMP WITH TIME ZONE '2020-07-21T20:59:19Z', 'Lorem', 'Lorem');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('O Temor do Sabio', 70.90, TIMESTAMP WITH TIME ZONE '2020-07-21T20:59:19Z', 'Lorem', 'Lorem');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('O Ceifador', 59.90, TIMESTAMP WITH TIME ZONE '2020-07-21T20:59:19Z', 'Lorem', 'Lorem');

INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (4, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (5, 1);
