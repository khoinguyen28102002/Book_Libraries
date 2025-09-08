CREATE TABLE book (
    id BIGINT PRIMARY KEY DEFAULT (floor(random() * 90000000) + 10000000),
    title VARCHAR(255),
    author VARCHAR(255),
    price VARCHAR(50),
    quantity INT
);