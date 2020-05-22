insert into book (book_id, category, title, year, price) 
values (100, 'cooking', 'Everyday Italian', '2005', 30.00);

insert into book (book_id, category, title, year, price) 
values (200, 'children', 'Harry Potter', '2005', 29.99);

insert into book (book_id, category, title, year, price) 
values (300, 'web', 'Learning XML', '2003', 39.95);


insert into author (author_id, author, book_id) 
values (111, 'Sam T. Bruce', 100);
values (333, 'Giada De Laurentiis', 100);

insert into author (author_id, author, book_id) 
values (555, 'J K. Rowling', 200);
values (999, 'Erik T. Ray', 200);

insert into author (author_id, author, book_id) 
values (1000, 'Erik T. Ray', 300);

--DROP ALL OBJECTS