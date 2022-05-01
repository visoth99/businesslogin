DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
    id INT(11) AUTO_INCREMENT NOT NULl,
    password varchar(128) NOT NULL,
    first_name varchar(32) NOT NULL,
    last_name varchar(32) NOT NULL,
    username varchar(64) UNIQUE NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`(
    id INT(11) AUTO_INCREMENT NOT NULl,
    name varchar(64) DEFAULT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles`(
    user_id int(11) NOT NULL,
    role_id int(11) NOT NULL,
    PRIMARY KEY (user_id,role_id),
    CONSTRAINT FK_ROLE FOREIGN KEY (role_id) REFERENCES `role` (`id`),
    CONSTRAINT FK_USER FOREIGN KEY (user_id) REFERENCES `user` (`id`)
);


