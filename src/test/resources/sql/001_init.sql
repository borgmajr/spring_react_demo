-- drop all connections to db
SELECT pg_terminate_backend(pid) FROM pg_stat_activity WHERE datname = 'spring_react';

DROP DATABASE IF EXISTS spring_react;

DROP USER if exists spring_react_dev;

CREATE USER spring_react_dev WITH LOGIN NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION PASSWORD 'spring_react_pw';

CREATE DATABASE spring_react WITH  OWNER = spring_react_dev ENCODING = 'UTF8' TABLESPACE = pg_default CONNECTION LIMIT = -1;
