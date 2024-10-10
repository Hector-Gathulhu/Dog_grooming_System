package com.dgs.dog_grooming_system.repository;

import com.dgs.dog_grooming_system.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<Dog,Long>  {
}
