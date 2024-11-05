CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price_in_cents INT NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE
);