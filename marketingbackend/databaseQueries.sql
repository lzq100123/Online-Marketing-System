CREATE TABLE category (
	id INT AUTO_INCREMENT NOT NULL,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN NOT NULL,

	CONSTRAINT pk_category_id PRIMARY KEY(id)
);