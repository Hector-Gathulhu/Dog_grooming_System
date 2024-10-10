package com.dgs.dog_grooming_system.model;

import com.dgs.dog_grooming_system.enums.BathType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "appointment")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DogAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length=10)
    private String ownerPhone;
    @Enumerated(EnumType.STRING)
    private BathType bathType;

    //Add ownerID
    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonIgnoreProperties({"name", "phone", "email", "dogAppointmentAppointments"})
    private Owner owner;
    @ManyToOne
    @JoinColumn(name = "dog_id")
    @JsonIgnoreProperties("dogAppointments")
    private Dog dog;
}
