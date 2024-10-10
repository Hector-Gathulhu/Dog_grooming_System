package com.dgs.dog_grooming_system.service;

import com.dgs.dog_grooming_system.dto.OwnerDto;
import com.dgs.dog_grooming_system.model.Owner;
import com.dgs.dog_grooming_system.repository.DogAppointmentRepository;
import com.dgs.dog_grooming_system.repository.OwnerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public Owner registerOwner(OwnerDto ownerDto) {
        Owner registerOwner = new Owner();
        registerOwner.setName(ownerDto.name());
        registerOwner.setPhone(ownerDto.phone());
        registerOwner.setEmail(ownerDto.email());

        return ownerRepository.save(registerOwner);
    }

    public List<Owner> getOwners() {
        return ownerRepository.findAll();
    }

    public Owner getOwnersId(Long id) {
        return ownerRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Owner updateOwner(Long id, OwnerDto ownerDto) {
        Owner updateOwner = ownerRepository.findById(id).orElseThrow(RuntimeException::new);

        updateOwner.setName(ownerDto.name());
        updateOwner.setPhone(ownerDto.phone());
        updateOwner.setEmail(ownerDto.email());

        return ownerRepository.save(updateOwner);
    }

    public Owner deleteOwner(Long id) {

        Owner deleteOwner = ownerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("The owner doesn't exist, ID: " + id));

        ownerRepository.deleteById(deleteOwner.getId());
        return deleteOwner;
    }
}
