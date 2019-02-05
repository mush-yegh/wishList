CREATE TABLE IF NOT EXISTS user (
        id BIGINT AUTO_INCREMENT,
        first_name VARCHAR(50) NOT NULL,
        last_name VARCHAR (50) NOT NULL,
        mail VARCHAR (50) NOT NULL,
        birth_date DATE NOT NULL,
        active TINYINT NOT NULL DEFAULT 1,
        created DATETIME NOT NULL DEFAULT NOW(),
        PRIMARY KEY (id),
        UNIQUE (mail)
)  ENGINE=INNODB;

ALTER TABLE user MODIFY active TINYINT NULL;

ALTER TABLE user MODIFY created DATETIME NULL;



CREATE TABLE IF NOT EXISTS wish (
        id BIGINT AUTO_INCREMENT,
        user_id BIGINT NOT NULL,
        title VARCHAR (255) NOT NULL ,
        link VARCHAR (255),
        description TEXT,
        price DECIMAL (10,2) NOT NULL,
        PRIMARY KEY (id)
)  ENGINE=INNODB;

ALTER TABLE `wishlist_test`.`wish`
        ADD COLUMN `created` DATE NOT NULL AFTER `price`,
        ADD COLUMN `updated` DATE NULL DEFAULT NULL AFTER `created`,
        ADD COLUMN `active` TINYINT NOT NULL AFTER `updated`;

ALTER TABLE `wishlist_test`.`wish`
        DROP FOREIGN KEY `FKkqi4lso34o5xjkhiw71uadwvu`;
ALTER TABLE `wishlist_test`.`wish`
        CHANGE COLUMN `user_id` `owner_id` BIGINT(20) NOT NULL ;
ALTER TABLE `wishlist_test`.`wish`
        ADD CONSTRAINT `FKkqi4lso34o5xjkhiw71uadwvu`
                FOREIGN KEY (`owner_id`)
                        REFERENCES `wishlist_test`.`user` (`id`);
