INSERT INTO users (username, name, password, role) VALUES ('lmarquez@gmail.com', 'luis marquez', '$2a$10$ywh1O2EwghHmFIMGeHgsx.9lMw5IXpg4jafeFS.Oi6nFv0181gHli', 'CUSTOMER');
INSERT INTO users (username, name, password, role) VALUES ('mhernandez@gmail.com', 'mengano hernandez', '$2a$10$TMbMuEZ8utU5iq8MOoxpmOc6QWQuYuwgx1xJF8lSMNkKP3hIrwYFG', 'ADMINISTRATOR');


INSERT INTO ingredients (name, description, price, url_image, enabled) VALUES ('Queso', 'Queso Chedar', 3000,'', true);
INSERT INTO ingredients (name, description, price, url_image, enabled) VALUES ('Salchichas', 'Queso Chedar', 3000,'', true);
INSERT INTO ingredients (name, description, price, url_image, enabled) VALUES ('Peperoni', 'Queso Chedar', 5000,'', true);

INSERT INTO products (name, description, product_type, url_image, price, enabled) VALUES ('Pizza perzonaliza', 'Escoge los ingredientes', 'PIZZA','https://www.elespectador.com/resizer/Y9Rm58KL-alSI02XojQ6xsviQOw=/525x350/filters:quality(60):format(jpeg)/cloudfront-us-east-1.images.arcpublishing.com/elespectador/XXO4YC56FJAHFHP2BZFZ4VDQZU.jpg', 10, true);
INSERT INTO products (name, description, product_type, url_image, price, enabled) VALUES ('Pizza carne', 'Queso Chedar dsdd', 'PIZZA','https://mandolina.co/wp-content/uploads/2023/07/pizza-mexciana.png', 50, true);
INSERT INTO products (name, description, product_type, url_image, price, enabled) VALUES ('Pizza Peperoni', 'Queso Chedar dsdd', 'PIZZA','https://assets.elgourmet.com/wp-content/uploads/2023/03/cover_vhlf5orm7s_pizzamasa-1024x683.jpg.webp', 55, true);

INSERT INTO products (name, description, product_type, url_image, price, enabled) VALUES ('Coca cola', '300 ml', 'BEBIDA','', 5, true);
INSERT INTO products (name, description, product_type, url_image, price, enabled) VALUES ('Agua', '300 ml', 'BEBIDA','', 4, true);

INSERT INTO products (name, description, product_type, url_image, price, enabled) VALUES ('Queso', 'Queso en los bordes', 'ADICIONAL','', 4, true);
INSERT INTO products (name, description, product_type, url_image, price, enabled) VALUES ('Arequipe', 'Arequipe en los bordes', 'ADICIONAL','', 4, true);

INSERT INTO products_ingredients (product_id, ingredient_id) VALUES (2,1);
INSERT INTO products_ingredients (product_id, ingredient_id) VALUES (2,2);

INSERT INTO products_ingredients (product_id, ingredient_id) VALUES (3,1);
INSERT INTO products_ingredients (product_id, ingredient_id) VALUES (3,3);