INSERT INTO tb_category (name, created_at) VALUES ('Livros', NOW())
INSERT INTO tb_category (name, created_at) VALUES ('Computadores', NOW())
INSERT INTO tb_category (name, created_at) VALUES ('Eletrônicos', NOW())


INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Smart TV', 404.50, TIMESTAMP WITH TIME ZONE '2020-07-21T20:59:19Z', 'Lorem', 'Lorem');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Smart TV', 404.50, TIMESTAMP WITH TIME ZONE '2020-07-21T20:59:19Z', 'Lorem', 'Lorem');

INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 3);