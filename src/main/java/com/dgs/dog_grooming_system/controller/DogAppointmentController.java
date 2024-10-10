package com.dgs.dog_grooming_system.controller;

import com.dgs.dog_grooming_system.dto.DogAppointmentDto;
import com.dgs.dog_grooming_system.model.DogAppointment;
import com.dgs.dog_grooming_system.service.DogAppointmentService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/appointment")
public class DogAppointmentController {

    @Autowired
    private DogAppointmentService dogAppointmentService;


    @PostMapping("/register")
    public ResponseEntity<?> createDogAppointment(@RequestBody @Valid DogAppointmentDto dogAppointmentDto) {
        try {
            DogAppointment dogAppointment = dogAppointmentService.createAppointment(dogAppointmentDto);
            return ResponseEntity.ok(dogAppointment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<DogAppointment>> getAppointments() {
        List<DogAppointment> getDogsAppointments = dogAppointmentService.retriveAppointment();

        return ResponseEntity.ok(getDogsAppointments);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<DogAppointment>> getAppointmentByName(@PathVariable String name) {
        Optional<List<DogAppointment>> dogAppointment = dogAppointmentService.getAppointmentByName(name);
        if (dogAppointment.isPresent()) {
            return ResponseEntity.ok(dogAppointment.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}/update")
    public ResponseEntity<?> updateDogAppointment(@PathVariable Long id, @RequestBody @Valid DogAppointmentDto dogUpdateDto) {

        try {
            DogAppointment dogAppointment = dogAppointmentService.updateAppointment(id, dogUpdateDto);
            return ResponseEntity.ok(dogAppointment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id) {

        try {
            DogAppointment dogAppointment = dogAppointmentService.deleteAppointment(id);
            return ResponseEntity.ok("Appointment deleted successfully!");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

}
