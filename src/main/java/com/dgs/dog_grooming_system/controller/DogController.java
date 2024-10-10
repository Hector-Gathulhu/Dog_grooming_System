package com.dgs.dog_grooming_system.controller;

import com.dgs.dog_grooming_system.dto.DogDto;
import com.dgs.dog_grooming_system.model.Dog;
import com.dgs.dog_grooming_system.model.Owner;
import com.dgs.dog_grooming_system.service.DogService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dog")
public class DogController {

    @Autowired
    private DogService dogService;

    @PostMapping("/register")
    public ResponseEntity<?> registerDog(@RequestBody @Valid DogDto dogDto) {

        try {
            Dog registerDog = dogService.registerDog(dogDto);
            return ResponseEntity.ok(registerDog);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/allDogs")
    public ResponseEntity<List<Dog>> getDogs() {

        List<Dog> getDogs = dogService.getDogs();

        return ResponseEntity.ok(getDogs);
    }

    @GetMapping("/dog/{id}")
    public ResponseEntity<Dog> getDogId(@RequestBody @PathVariable Long id){

        Dog getDogId = dogService.getDogsId(id);

        return ResponseEntity.ok(getDogId);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Dog> updateDogId(@PathVariable Long id, @RequestBody @Valid DogDto dogDto) {
        Dog updateDog = dogService.updateDog(id, dogDto);

        return ResponseEntity.ok(updateDog);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDog(@PathVariable Long id) {

        try {
            Dog deleteDog = dogService.deleteDog(id);
            return ResponseEntity.ok("Dog deleted sussccesfully!");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
