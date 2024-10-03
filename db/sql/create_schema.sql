CREATE TABLE appointment(

    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    owner_phone VARCHAR(20) NOT NULL,
    bath_type VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);