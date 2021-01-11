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