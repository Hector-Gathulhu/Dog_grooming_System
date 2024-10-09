package com.dgs.dog_grooming_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "owner")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 10)
    private String phone;
    private String email;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "owner")
    private List<Dog> dogAppointments;

}
