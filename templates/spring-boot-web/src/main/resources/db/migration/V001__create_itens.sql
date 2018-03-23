CREATE SCHEMA IF NOT EXISTS ${artifact};

CREATE TABLE IF NOT EXISTS ${artifact}.category (
    id SERIAL PRIMARY KEY,
    description VARCHAR(50),
);

CREATE TABLE IF NOT EXISTS ${artifact}.item (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    description VARCHAR(50),
    category INTEGER REFERENCES ${artifact}.category(id)
);