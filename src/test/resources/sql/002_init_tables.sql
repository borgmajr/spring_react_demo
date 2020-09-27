CREATE TABLE users
(
    id SERIAL PRIMARY KEY,
    username character varying(100) UNIQUE,
    password character varying(64),
    email character varying(100),
    deleted boolean default false
);

CREATE TABLE currency
(
    id SERIAL PRIMARY KEY,
    name character varying(100) UNIQUE,
    code character varying(64),
    amount DECIMAL,
    rate DECIMAL
);
