DROP TABLE IF EXISTS details;
DROP TABLE IF EXISTS client;

CREATE TABLE client
(
  client_id SERIAL PRIMARY KEY NOT NULL,
  clientname VARCHAR(40),
  apikey VARCHAR(40) UNIQUE
);

CREATE TABLE details
(
  id SERIAL PRIMARY KEY NOT NULL,
  username VARCHAR(40),
  name varchar(40),
  default_price VARCHAR(255),
  currency VARCHAR(255),
  description VARCHAR(255),
  category VARCHAR(40),
  supplier VARCHAR(40),
  categorycounter INT,
  client_id SERIAL REFERENCES client(client_id)
);




