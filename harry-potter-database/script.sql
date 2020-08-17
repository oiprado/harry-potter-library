CREATE TABLE book 
(
  id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  title varchar(100) DEFAULT NULL,
  price double DEFAULT NULL,
  quantity int(11) DEFAULT NULL,
  cover varchar(3000) DEFAULT NULL
);

create table shopping_cart
(
	id int(11) PRIMARY KEY  AUTO_INCREMENT,
	user_id int,
	purchase_date timestamp
);

create table shopping_cart_detail
(
	id int(11) PRIMARY KEY AUTO_INCREMENT,
	shopping_cart_id int(11),
	book_id int(11),
	quantity int
);

ALTER TABLE shopping_cart_detail
ADD CONSTRAINT fk_shopping_cart
FOREIGN KEY (shopping_cart_id) REFERENCES shopping_cart(id);

ALTER TABLE shopping_cart_detail
ADD CONSTRAINT fk_book
FOREIGN KEY (book_id) REFERENCES book(id);

create table await_commit_shopping_cart
(
	id int(11) PRIMARY KEY  AUTO_INCREMENT,
	user_id int(11),
	book_id int(11),
	quantity int,
	CONSTRAINT uc_await_commit_shopping_cart UNIQUE (user_id,book_id)
)

ALTER TABLE await_commit_shopping_cart
ADD CONSTRAINT fk_await_sc_book
FOREIGN KEY (book_id) REFERENCES book(id);
