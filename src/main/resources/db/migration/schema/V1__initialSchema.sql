CREATE TABLE books (
  id INT not null PRIMARY KEY,
  title VARCHAR(200) not null
);

CREATE TABLE authors (
  id int not null PRIMARY KEY,
  first_name VARCHAR(50) not null,
  last_name VARCHAR(50) not null
)