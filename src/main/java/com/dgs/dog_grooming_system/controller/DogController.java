package com.dgs.dog_grooming_system.controller;

import com.dgs.dog_grooming_system.dto.DogAppointmentDto;
import com.dgs.dog_grooming_system.dto.DogUpdateDto;
import com.dgs.dog_grooming_system.model.Dog;
import com.dgs.dog_grooming_system.service.DogService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/dogs")
public class DogController {

    @Autowired
    private DogService dogService;


    @PostMapping("/register")
    public ResponseEntity<?> createDogAppointment(@RequestBody @Valid DogAppointmentDto dogAppointmentDto) {
        try {
            Dog dogAppointment = dogService.createAppointment(dogAppointmentDto);
            return ResponseEntity.ok(dogAppointment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @GetMapping("/appointments")
    public ResponseEntity<List<Dog>> getAppointments() {
        List<Dog> getDogsAppointments = dogService.retriveAppointment();

        return ResponseEntity.ok(getDogsAppointments);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Dog> getAppointmentByName(@PathVariable String name) {
        Optional<Dog> dogAppointment = dogService.getAppointmentByName(name);
        if (dogAppointment.isPresent()) {
            return ResponseEntity.ok(dogAppointment.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}/update")
    public ResponseEntity<Dog> updateDogAppointment(@RequestBody @Valid DogUpdateDto dogUpdateDto) {

        Dog dogAppointment = dogService.updateAppointment(
                dogUpdateDto.id(),
                dogUpdateDto.name(),
                dogUpdateDto.ownerPhone(),
                dogUpdateDto.bathType());

        return ResponseEntity.ok(dogAppointment);
    }


    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id) {

        try {
            Dog dogAppointment = dogService.deleteAppointment(id);
            return ResponseEntity.ok("Appointment deleted successfully!");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

}
