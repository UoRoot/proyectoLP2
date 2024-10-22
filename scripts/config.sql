-- Active: 1729567090998@@127.0.0.1@3306@testdb
USE testdb;

CREATE TABLE IF NOT EXISTS users (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR(100) UNIQUE NOT NULL,
    `password` VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS colors (
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS sizes (
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `size` VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS categories (
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    image_url TEXT
);

CREATE TABLE IF NOT EXISTS subcategories (
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `category_id` INTEGER NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories (`id`)
);

CREATE TABLE IF NOT EXISTS brands (
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    image_url TEXT
);

CREATE TABLE IF NOT EXISTS products (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `description` TEXT,
    image_url TEXT,
    price DECIMAL(10, 2) NOT NULL CHECK (price >= 0),
    stock_quantity INTEGER NOT NULL CHECK (stock_quantity >= 0),
    gender ENUM("MALE", "FEMALE", "UNISEX") NOT NULL,
    subcategory_id INTEGER NOT NULL,
    brand_id INTEGER NOT NULL,
    created_date DATETIME,
    updated_date DATETIME,
    FOREIGN KEY (subcategory_id) REFERENCES subcategories (`id`),
    FOREIGN KEY (brand_id) REFERENCES brands (`id`)
);
-- CREATE INDEX idx_gender ON products (gender);

CREATE TABLE IF NOT EXISTS product_size (
    product_id BIGINT NOT NULL,
    size_id INTEGER NOT NULL,
    PRIMARY KEY (product_id, size_id),
    FOREIGN KEY (product_id) REFERENCES products (`id`) ON DELETE CASCADE,
    FOREIGN KEY (size_id) REFERENCES sizes (`id`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS product_color (
    product_id BIGINT NOT NULL,
    color_id INTEGER NOT NULL,
    PRIMARY KEY (product_id, color_id),
    FOREIGN KEY (product_id) REFERENCES products (`id`) ON DELETE CASCADE,
    FOREIGN KEY (color_id) REFERENCES colors (`id`) ON DELETE CASCADE
);
-- DROP DATABASE testdb;
-- CREATE DATABASE testdb;