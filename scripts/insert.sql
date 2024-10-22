-- Active: 1729567090998@@127.0.0.1@3306@testdb
USE testdb;

INSERT INTO
    users (`username`, `password`)
VALUES ('admin', '$2a$12$l42SJFNJZ0TgjYycOnVDVuXmJaykUIL8dzcerPOpaJBkPM5fWQQXq');

INSERT INTO
    categories (`name`, image_url)
VALUES ('Tops', 'categoria_1.webp'),
    ('Bottoms', 'categoria_2.jpg');

INSERT INTO
    subcategories (`name`, category_id)
VALUES ('T-shirts', 1),
    ('Jackets', 1),
    ('Vests', 1),
    ('Shorts', 2),
    ('Pants', 2),
    ('Leggings', 2);

INSERT INTO
    brands (`name`, image_url)
VALUES ('Adidas', 'adidas.png'),
    ('Puma', 'humbro.png'),
    ('Under Armour', 'underarmor.png'),
    ('Umbro', 'puma.png');


INSERT INTO products (`name`, `description`, `image_url`, `price`, `stock_quantity`, `gender`, `subcategory_id`, `brand_id`, `created_date`, `updated_date`)
VALUES 
('Basic T-Shirt', 'Classic cotton t-shirt for everyday wear.', 'producto1.webp', 19.99, 100, 'UNISEX', 1, 1, NOW(), NOW()),
('Premium Jacket', 'Waterproof jacket with thermal lining.', 'producto2.jpeg', 89.99, 50, 'MALE', 2, 2, NOW(), NOW()),
('Sport Vest', 'Lightweight vest ideal for running.', 'producto3.jpeg', 29.99, 75, 'FEMALE', 3, 3, NOW(), NOW()),
('Casual Shorts', 'Comfortable shorts for casual wear.', 'producto4.webp', 24.99, 60, 'MALE', 4, 4, NOW(), NOW()),
('Chino Pants', 'Slim-fit chinos with stretch fabric.', 'producto5.webp', 49.99, 40, 'UNISEX', 5, 2, NOW(), NOW()),
('Yoga Leggings', 'High-waisted leggings for yoga and training.', 'producto6.webp', 39.99, 120, 'FEMALE', 6, 1, NOW(), NOW()),
('Graphic T-Shirt', 'T-shirt with unique graphic design.', 'producto7.jpeg', 25.99, 80, 'UNISEX', 1, 4, NOW(), NOW()),
('Denim Jacket', 'Classic denim jacket with a modern fit.', 'producto8.jpeg', 69.99, 35, 'MALE', 2, 2, NOW(), NOW()),
('Puffer Vest', 'Insulated puffer vest for cold weather.', 'producto9.webp', 54.99, 45, 'UNISEX', 3, 3, NOW(), NOW()),
('Running Shorts', 'Breathable shorts for running.', 'producto10.avif', 22.99, 90, 'FEMALE', 4, 4, NOW(), NOW());


INSERT INTO
    colors (`name`)
VALUES ('Rojo'),
    ('Azul'),
    ('Blanco'),
    ('Verde'),
    ('Negro');

INSERT INTO
    sizes (size)
VALUES ('S'),
    ('M'),
    ('L'),
    ('XL');

INSERT INTO
    product_color (product_id, color_id)
VALUES (1, 2), (1, 3), (2, 1), (3, 3), (4, 4), (5, 5), (5, 2), (6, 5), (6, 2), (6, 3), (7, 5), (7, 1), (8, 2), (8, 4), (9, 3), (10, 3), (10, 5);

INSERT INTO
    product_size (product_id, size_id)
VALUES (1, 1), (2, 1), (2, 2), (3, 3), (4, 1), (5, 4), (5, 3), (6, 2), (6, 3), (7, 3), (7, 2), (7, 1), (8, 2), (8, 4), (9, 3), (10, 3), (10, 4);

-- use api_fake;
-- Eliminar todos los registros de la tabla 'products'
-- DELETE FROM products;

-- Comprobar que los registros se han eliminado (opcional)
-- SELECT * FROM products;