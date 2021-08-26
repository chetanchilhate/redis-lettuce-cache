DROP TABLE IF EXISTS t_user;

CREATE TABLE t_user (
  id int NOT NULL AUTO_INCREMENT,
  email varchar(255) NOT NULL,
  first_name varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);