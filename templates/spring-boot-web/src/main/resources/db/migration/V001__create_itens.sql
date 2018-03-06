CREATE SCHEMA IF NOT EXISTS ${artifact};

CREATE TABLE IF NOT EXISTS ${artifact}.item (
    id BIGINT,
    name VARCHAR(50),
    description VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS ${artifact}.category (
    id BIGINT,
    description VARCHAR(50),
    itemId BIGINT
);
