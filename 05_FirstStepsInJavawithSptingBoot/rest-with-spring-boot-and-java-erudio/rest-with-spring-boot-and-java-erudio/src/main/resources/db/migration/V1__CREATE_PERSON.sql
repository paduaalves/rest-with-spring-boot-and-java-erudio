CREATE TABLE `person`
(
    `id`         bigint NOT NULL AUTO_INCREMENT,
    `first_name` varchar(255) DEFAULT NULL,
    `last_name`  varchar(255) DEFAULT NULL,
    `address`    varchar(255) DEFAULT NULL,
    `gender`     varchar(255) DEFAULT NULL,
    `birth_date` date         DEFAULT NULL,
    PRIMARY KEY (`id`)
);