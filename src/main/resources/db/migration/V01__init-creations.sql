DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id INT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(58),
  password VARCHAR(58),
  name VARCHAR(255),
  street VARCHAR(255),
  state VARCHAR(128),
  city VARCHAR(255),
  zip_code VARCHAR(12),
  checked BOOLEAN,
  cpf VARCHAR(12) 
);

DROP TABLE IF EXISTS author;
CREATE TABLE author (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255)
);

DROP TABLE IF EXISTS book;
CREATE TABLE book (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255),
  image VARCHAR(255),
  release_date DATE, 
  resume BLOB,
  rented BOOLEAN DEFAULT FALSE,
  unit_price DECIMAL,
  stock_quantity INT
);

DROP TABLE IF EXISTS book_author;
CREATE TABLE book_author (
  book_id INT NOT NULL,
  author_id INT NOT NULL
);
