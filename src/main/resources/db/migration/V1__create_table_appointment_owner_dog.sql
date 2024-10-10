CREATE TABLE appointment(

    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    owner_phone VARCHAR(20) NOT NULL,
    bath_type VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE owner(
        id BIGINT NOT NULL AUTO_INCREMENT,
        name VARCHAR(20) NOT NULL,
        phone VARCHAR(10) NOT NULL,
        email VARCHAR(20) NOT NULL,
        PRIMARY KEY (id)
);

ALTER TABLE appointment
ADD owner_id BIGINT NOT NULL;

ALTER TABLE appointment
ADD CONSTRAINT fk_appointment_owner FOREIGN KEY (owner_id) REFERENCES owner(id);


CREATE TABLE dog (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    breed VARCHAR(50),
    age INT,
    owner_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_dog1_owner FOREIGN KEY (owner_id) REFERENCES owner(id)
);

ALTER TABLE appointment
ADD dog_id BIGINT NOT NULL;

ALTER TABLE appointment
ADD CONSTRAINT fk_appointment_dog
FOREIGN KEY (dog_id) REFERENCES dog(id);