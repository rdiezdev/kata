-- pokemon definition
drop table if exists pokemon;

CREATE TABLE pokemon (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `base_experience` int(11) DEFAULT NULL,
  `height` float DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1l2d8t2w3h2rw3tm4h5fc3fyw` (`name`)
);

INSERT INTO pokemon(id, base_experience, height, name, weight)
VALUES(1, 10, 20, 'poke1', 100);

INSERT INTO pokemon(id, base_experience, height, name, weight)
VALUES(2, 20, 15, 'poke2', 100);

INSERT INTO pokemon(id, base_experience, height, name, weight)
VALUES(3, 30, 10, 'poke3', 50);

INSERT INTO pokemon (id, base_experience, height, name, weight)
VALUES(4, 40, 5, 'poke4', 25);