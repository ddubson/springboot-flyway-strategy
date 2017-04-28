ALTER TABLE books
  ADD CONSTRAINT books_authors_fk
  FOREIGN KEY (author_id) REFERENCES authors (id);