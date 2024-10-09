package com.dgs.dog_grooming_system.repository;

import com.dgs.dog_grooming_system.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface DogRepository extends JpaRepository<Dog,Long> {

    //JPQL(Java Persistence Query Language)
    @Query("SELECT d FROM appointment d WHERE LOWER(d.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    Optional<List<Dog>> findByNameContaining(String name);

    Optional<Dog> findByOwnerId(Long id);
}
