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

CREATE TABLE author (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE book (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255),
  image VARCHAR(255),
  release_date DATE, 
  resume BLOB,
  rented BOOLEAN DEFAULT FALSE,
  quantity INT
);

CREATE TABLE book_author (
  book_id INT NOT NULL,
  author_id INT NOT NULL
);
