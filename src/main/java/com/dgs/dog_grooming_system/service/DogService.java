package com.dgs.dog_grooming_system.service;
import com.dgs.dog_grooming_system.dto.DogAppointmentDto;
import com.dgs.dog_grooming_system.enums.BathType;
import com.dgs.dog_grooming_system.model.Dog;
import com.dgs.dog_grooming_system.repository.DogRepository;
import jakarta.persistence.EntityNotFoundException;
import org.aspectj.weaver.ast.Instanceof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;


    public Dog createAppointment(DogAppointmentDto dogAppointmentDto) {

            Dog dogAppointment = new Dog();
            dogAppointment.setName(dogAppointmentDto.name());
            dogAppointment.setOwnerPhone(dogAppointmentDto.ownerPhone());
            dogAppointment.setBathType(dogAppointmentDto.bathType());
            return dogRepository.save(dogAppointment);
    }

    public List<Dog> retriveAppointment(){
        return dogRepository.findAll();
    }

    public Optional<Dog> getAppointmentByName(String name){
        return dogRepository.findByNameContaining(name);
    }

    public Dog updateAppointment(Long id,String name, String ownerPhone, BathType bathType ){
        Dog dogAppointment = dogRepository.findById(id).orElseThrow(RuntimeException::new);
        dogAppointment.setName(name);
        dogAppointment.setOwnerPhone(ownerPhone);
        dogAppointment.setBathType(bathType);

        return dogRepository.save(dogAppointment);
    }

    public Dog deleteAppointment(Long id){
        Dog dogAppointment = dogRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("The appointment doesn't exist, ID: "+id));
        dogRepository.deleteById(dogAppointment.getId());

        return dogAppointment;
    }

}
