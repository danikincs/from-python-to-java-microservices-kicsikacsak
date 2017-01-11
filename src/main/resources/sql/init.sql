DROP TABLE IF EXISTS details;
DROP TABLE IF EXISTS client;

CREATE TABLE client
(
  clientname VARCHAR(40),
  apikey VARCHAR(40) UNIQUE
);




