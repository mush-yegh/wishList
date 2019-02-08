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


CREATE TABLE `request`
(
        `id`           bigint(20) NOT NULL,
        `requester_id` bigint(20) NOT NULL,
        `receiver_id`  bigint(20) NOT NULL,
        `status`       tinyint(4) NOT NULL DEFAULT 0,
        `request_date` datetime   NOT NULL DEFAULT CURRENT_TIMESTAMP,
        `respond_date` date                DEFAULT NULL,
        PRIMARY KEY (`id`),
        UNIQUE KEY `requester_id` (`requester_id`, `receiver_id`),
        KEY `fk_request_1_idx` (`requester_id`),
        KEY `fk_request_2_idx` (`receiver_id`),
        CONSTRAINT `FK97t94dqg8opu4x9cgm94fchw7` FOREIGN KEY (`id`) REFERENCES `user` (`id`),
        CONSTRAINT `FKdkkupgeywvc38759q9xq85ip4` FOREIGN KEY (`receiver_id`) REFERENCES `request` (`id`),
        CONSTRAINT `FKwef60neo5g6yxsxh751778b` FOREIGN KEY (`requester_id`) REFERENCES `request` (`id`),
        CONSTRAINT `fk_request_1` FOREIGN KEY (`requester_id`) REFERENCES `user` (`id`)
                ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT `fk_request_2` FOREIGN KEY (`receiver_id`) REFERENCES `user` (`id`)
                ON DELETE NO ACTION ON UPDATE NO ACTION
)
        ENGINE = InnoDB
        DEFAULT CHARSET = utf8;

