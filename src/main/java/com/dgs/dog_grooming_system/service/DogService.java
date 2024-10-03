package com.dgs.dog_grooming_system.service;
import com.dgs.dog_grooming_system.model.Dog;
import com.dgs.dog_grooming_system.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    public Dog createAppointment(String name, String ownerPhone, String bathType){
        Dog dogAppointment = new Dog();
        dogAppointment.setName(name);
        dogAppointment.setOwnerPhone(ownerPhone);
        dogAppointment.setBathType(bathType);
        return dogRepository.save(dogAppointment);
    }

    public List<Dog> retriveAppointment(){
        return dogRepository.findAll();
    }

    public Dog updateAppointment(Long id,String name, String ownerPhone, String bathType ){
        Dog dogAppointment = dogRepository.findById(id).orElseThrow(RuntimeException::new);
        dogAppointment.setName(name);
        dogAppointment.setOwnerPhone(ownerPhone);
        dogAppointment.setBathType(bathType);

        return dogRepository.save(dogAppointment);
    }

    public Dog deleteAppointment(Long id){
        Dog dogAppointment = dogRepository.findById(id).orElseThrow(RuntimeException::new);
        dogRepository.deleteById(dogAppointment.getId());

        return dogAppointment;
    }

}
