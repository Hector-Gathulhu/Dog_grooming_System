package com.dgs.dog_grooming_system.dto;

import com.dgs.dog_grooming_system.enums.BathType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DogUpdateDto(
        @NotBlank
        Long id,
        @NotBlank
        @Size(min = 3)
        String name,
        @NotBlank
        @Size(min = 10, max = 10)
        @Pattern(regexp = "\\d{10}")
        String ownerPhone,
        @NotNull(message = "Write in UPPERCASE")
        BathType bathType
) {
}
