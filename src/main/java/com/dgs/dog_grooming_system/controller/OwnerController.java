package com.dgs.dog_grooming_system.controller;

import com.dgs.dog_grooming_system.dto.OwnerDto;
import com.dgs.dog_grooming_system.model.Owner;
import com.dgs.dog_grooming_system.service.OwnerService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping("/register")
    public ResponseEntity<Owner> registerOwner(@RequestBody @Valid OwnerDto ownerDto) {

        Owner registerOwner = ownerService.registerOwner(ownerDto);
        return ResponseEntity.ok(registerOwner);
    }

    @GetMapping
    public ResponseEntity<List<Owner>> getOwners() {
        List<Owner> getOwners = ownerService.getOwners();
        return ResponseEntity.ok(getOwners);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerId(@PathVariable Long id) {
        Owner getOwnersid = ownerService.getOwnersId(id);
        return ResponseEntity.ok(getOwnersid);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> updateOwnerId(@PathVariable Long id, @RequestBody @Valid OwnerDto ownerDto) {
        Owner updateOwner = ownerService.updateOwner(id, ownerDto);

        return ResponseEntity.ok(updateOwner);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOwner(@PathVariable Long id) {

        try {
            Owner deleteOwner = ownerService.deleteOwner(id);
            return ResponseEntity.ok("Owner deleted sussccesfully!");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
