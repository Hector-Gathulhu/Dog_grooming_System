package com.dgs.dog_grooming_system.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "dog")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String age;

    @ManyToOne
    @JoinColumn(name="owner_id")
    @JsonIgnoreProperties({"dogs", "phone", "email", "dogAppointmentAppointments"})
    private Owner owner;
    @OneToMany(mappedBy = "dog", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("dog, ")
    private List<DogAppointment> dogAppointments;

}
