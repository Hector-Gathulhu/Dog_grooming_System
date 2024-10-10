package com.dgs.dog_grooming_system.service;

import com.dgs.dog_grooming_system.dto.DogAppointmentDto;
import com.dgs.dog_grooming_system.model.DogAppointment;
import com.dgs.dog_grooming_system.model.Owner;
import com.dgs.dog_grooming_system.repository.DogAppointmentRepository;
import com.dgs.dog_grooming_system.repository.OwnerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogAppointmentService {

    @Autowired
    private DogAppointmentRepository dogAppointmentRepository;
    @Autowired
    private OwnerRepository ownerRepository;


    public DogAppointment createAppointment(DogAppointmentDto dogAppointmentDto) {

        Owner owner = ownerRepository.findById(dogAppointmentDto.ownerId())
                .orElseThrow(() -> new IllegalArgumentException("Owner not found"));

        if (!owner.getPhone().equals(dogAppointmentDto.ownerPhone())) {
            throw new IllegalArgumentException("The phone provied doesn't match with the owner's information!");
        }

        DogAppointment dogAppointment = new DogAppointment();
        dogAppointment.setName(dogAppointmentDto.name());
        dogAppointment.setOwnerPhone(dogAppointmentDto.ownerPhone());
        dogAppointment.setBathType(dogAppointmentDto.bathType());
        dogAppointment.setOwner(owner);
        return dogAppointmentRepository.save(dogAppointment);
    }

    public List<DogAppointment> retriveAppointment() {
        return dogAppointmentRepository.findAll();
    }

    public Optional<List<DogAppointment>> getAppointmentByName(String name) {
        return dogAppointmentRepository.findByNameContaining(name);
    }

    public DogAppointment updateAppointment(Long id, DogAppointmentDto dogUpdateDto) {
        DogAppointment dogAppointment = dogAppointmentRepository.findById(id).orElseThrow(RuntimeException::new);
        Owner owner = ownerRepository.findById(dogUpdateDto.ownerId())
                .orElseThrow(() -> new IllegalArgumentException("Owner not found"));

        if (!owner.getPhone().equals(dogUpdateDto.ownerPhone())) {
            throw new IllegalArgumentException("The phone provied doesn't match with the owner's information!");
        }

        dogAppointment.setName(dogUpdateDto.name());
        dogAppointment.setOwnerPhone(dogUpdateDto.ownerPhone());
        dogAppointment.setBathType(dogUpdateDto.bathType());
        dogAppointment.setOwner(dogAppointment.getOwner());

        return dogAppointmentRepository.save(dogAppointment);
    }

    public DogAppointment deleteAppointment(Long id) {
        DogAppointment dogAppointment = dogAppointmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The appointment doesn't exist, ID: " + id));
        dogAppointmentRepository.deleteById(dogAppointment.getId());

        return dogAppointment;
    }

}
