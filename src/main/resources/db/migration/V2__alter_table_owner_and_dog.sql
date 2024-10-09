ALTER TABLE appointment
ADD owner_id BIGINT NOT NULL;

ALTER TABLE appointment
ADD CONSTRAINT fk_dog_owner
FOREIGN KEY (owner_id) REFERENCES owner(id);