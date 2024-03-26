package com.example.medipet.exceptions;

import java.util.UUID;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(UUID id){
        super("Could not find Doctor: " + id);
    }
}
