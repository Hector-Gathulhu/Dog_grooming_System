package com.dgs.dog_grooming_system.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.http.converter.HttpMessageNotReadableException;


public enum BathType {
    BASIC,
    DELUXE,
    PREMIUM;

    @JsonCreator
    public static BathType fromString(String enume) {
        try {
            return BathType.valueOf(enume.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid bath type. Select Basic, Deluxe or Premium. Error: "+enume );
        }
    }
}
