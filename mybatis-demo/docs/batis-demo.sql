use sys;

DROP DATABASE IF EXISTS `batis`;
CREATE DATABASE batis;

use batis;

DROP TABLE IF EXISTS `proc_demo`;
CREATE  TABLE proc_demo(
	id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    username varchar(30) NOT NULL,
    password varchar(30) NOT NULL,
    image_url varchar(120) NOT NULL,
    role_name varchar(120) NOT NULL,
    KEY(username),
    KEY(password)

) ENGINE=InnoDB, DEFAULT CHARSET=utf8;

use batis;
insert into proc_demo (`username`,`password`,`image_url`,`role_name`) values('jinghe','lotus','imgurl','admin');
insert into proc_demo (`username`,`password`,`image_url`,`role_name`) values('ps','lotus','imgurl','admin');
insert into proc_demo (`username`,`password`,`image_url`,`role_name`) values('arbor','lotus','imgurl','admin');
insert into proc_demo (`username`,`password`,`image_url`,`role_name`) values('veritas','lotus','imgurl','admin');

use batis;

DROP PROCEDURE IF EXISTS validate_members;

DELIMITER //
CREATE PROCEDURE validate_members(IN userIds text, IN splitor char(1))
BEGIN
	DECLARE invalid_members text;
    SET invalid_members = 'jinghe,lotus';
	select invalid_members;
END //
DELIMITER ;

call validate_members('jinghe',',');

