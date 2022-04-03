CREATE TABLE IF NOT EXISTS book (
  book_id int(100) NOT NULL AUTO_INCREMENT,
  category varchar(50) DEFAULT NULL,
  title varchar(50) DEFAULT NULL,
  year varchar(50) DEFAULT NULL,
  price varchar(45) DEFAULT NULL,
  PRIMARY KEY (book_id)
);

CREATE TABLE IF NOT EXISTS author (
  author_id int(100) NOT NULL AUTO_INCREMENT,
  authorName varchar(100) DEFAULT NULL,
  book_id INTEGER NOT NULL,
  PRIMARY KEY (author_id),
  FOREIGN KEY (book_id) REFERENCES book (book_id)
 );
