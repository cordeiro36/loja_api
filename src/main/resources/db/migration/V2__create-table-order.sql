CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    product_id VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) DEFAULT 'PENDENTE'
);