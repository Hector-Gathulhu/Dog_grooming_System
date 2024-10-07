package com.dgs.dog_grooming_system.repository;

import com.dgs.dog_grooming_system.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DogRepository extends JpaRepository<Dog,Long> {

    //JQPL
    @Query("SELECT d FROM appointment d WHERE LOWER(d.name) = LOWER(:name)")
    Optional<Dog> findByNameContaining(String name);
}
