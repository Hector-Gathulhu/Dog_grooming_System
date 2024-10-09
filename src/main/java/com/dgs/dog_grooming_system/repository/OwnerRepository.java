package com.dgs.dog_grooming_system.repository;

import com.dgs.dog_grooming_system.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
