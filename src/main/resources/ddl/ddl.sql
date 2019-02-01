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