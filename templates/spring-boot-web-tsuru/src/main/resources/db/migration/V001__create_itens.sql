CREATE SCHEMA IF NOT EXISTS ${artifact};

CREATE TABLE IF NOT EXISTS ${artifact}.item (   
    id BIGINT,
    name VARCHAR(50)
);
