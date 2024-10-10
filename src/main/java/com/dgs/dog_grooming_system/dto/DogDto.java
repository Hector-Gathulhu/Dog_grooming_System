package com.dgs.dog_grooming_system.dto;

import com.dgs.dog_grooming_system.model.Owner;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DogDto(
        @NotBlank
        String name,
        @NotBlank
        String age,
        @NotNull
        Long ownerId
) {
}
