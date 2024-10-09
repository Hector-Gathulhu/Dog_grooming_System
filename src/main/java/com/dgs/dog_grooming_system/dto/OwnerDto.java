package com.dgs.dog_grooming_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public record OwnerDto(
        @NotBlank
        String name,
        @NotBlank
        @Size(min = 10, max = 10)
        @Pattern(regexp = "\\d{10}")
        String phone,
        @NotBlank
        @Email
        String email
) {
}
