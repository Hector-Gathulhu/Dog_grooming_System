package com.dgs.dog_grooming_system.model;

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
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length=10)
    private String ownerPhone;
    private String bathType;
}
