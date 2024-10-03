package com.dgs.dog_grooming_system.controller;

import com.dgs.dog_grooming_system.model.Dog;
import com.dgs.dog_grooming_system.repository.DogRepository;
import com.dgs.dog_grooming_system.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dogs")
public class DogController {

    @Autowired
    private DogService dogService;

    @PostMapping("/register")
    public ResponseEntity<Dog> createDogAppointment(@RequestParam String name, String ownerPhone, String bathType){
        Dog dogAppointment = dogService.createAppointment(name,ownerPhone,bathType);

        return ResponseEntity.ok(dogAppointment);
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<Dog>> getAppointments(){
        List<Dog> getDogsAppointments = dogService.retriveAppointment();

        return ResponseEntity.ok(getDogsAppointments);
    }

    @PutMapping("{id}/update")
    public ResponseEntity<Dog> updateDogAppointment(@PathVariable Long id, String name, String ownerPhone, String bathType){
        Dog dogAppointment = dogService.updateAppointment(id,name,ownerPhone,bathType);

        return ResponseEntity.ok(dogAppointment);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<Dog> deleteAppointment(@PathVariable Long id){
        Dog dogAppointment = dogService.deleteAppointment(id);

        return ResponseEntity.ok(dogAppointment);
    }

}
