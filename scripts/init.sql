DROP TABLE IF EXISTS users;
CREATE TABLE users (id INT PRIMARY KEY NOT NULL, name TEXT NOT NULL);

DROP TABLE IF EXISTS stocks;
CREATE TABLE stocks(code VARCHAR(10) PRIMARY KEY NOT NULL, description TEXT);

DROP TABLE IF EXISTS users_stocks;
CREATE TABLE users_stocks(
    user_id INT REFERENCES users (id),
    stock_code VARCHAR(10) REFERENCES stocks (code),
    CONSTRAINT users_stocks_pkey PRIMARY KEY (user_id, stock_Code)
);

