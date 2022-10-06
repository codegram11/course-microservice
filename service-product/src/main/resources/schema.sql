DROP TABLE IF EXISTS tbl_categories;

CREATE TABLE tbl_categories (
                                id LONG AUTO_INCREMENT  PRIMARY KEY,
                                name VARCHAR(250) NOT NULL
);


DROP TABLE IF EXISTS tbl_products;

CREATE TABLE tbl_products (
                              id LONG AUTO_INCREMENT  PRIMARY KEY,
                              name VARCHAR(250) NOT NULL,
                              description VARCHAR(250) NOT NULL,
                              stock DOUBLE,
                              price DOUBLE,
                              status VARCHAR(250) NOT NULL,
                              create_at TIMESTAMP,
                              category_id LONG
);