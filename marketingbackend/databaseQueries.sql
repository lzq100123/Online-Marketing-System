CREATE TABLE category (
	id INT AUTO_INCREMENT NOT NULL,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN NOT NULL,

	CONSTRAINT pk_category_id PRIMARY KEY(id)
);

INSERT INTO category (name, description, image_url, is_active) VALUE("Television","This is a description about television!","tv1.png",true);
INSERT INTO category (name, description, image_url, is_active) VALUE("Laptop","This is a description about laptop!","laptop1.png",true);
INSERT INTO category (name, description, image_url, is_active) VALUE("Mobile","This is a description about mobile!","mobile1.png",true);

CREATE TABLE user_detail (
	id INT AUTO_INCREMENT NOT NULL,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN NOT NULL,
	password VARCHAR(50),
	email VARCHAR(100),
	contact_number VARCHAR(15),

	CONSTRAINT pk_user_id PRIMARY KEY(id)
);

INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number) 
VALUES("Zhiquan", "Li", "ADMIN", true, "admin", "lzq@hawk.iit.edu", "8888888888");
INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number) 
VALUES("Fangzhou", "Xiong", "SUPPLIER", true, "123456", "xfz@hawk.iit.edu", "9999999999");
INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number) 
VALUES("Xinzhou", "Yan", "SUPPLIER", true, "123456", "yxz@hawk.iit.edu", "6666666666");
INSERT INTO user_detail (first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ("Khozema", "Nullwala", "USER", true, "123456", "kn@gmail.com", "7777777777");

CREATE TABLE product (
	id INT AUTO_INCREMENT NOT NULL,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN NOT NULL,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,

	CONSTRAINT pk_product_id PRIMARY KEY(id),
	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category(id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id)
);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABC123DEFX', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', 799, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 699, 2, true, 3, 3, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 659, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 899, 3, true, 2, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 1099, 5, true, 2, 3, 0, 0 );
