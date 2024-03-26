package com.example.medipet.doctors;

import java.util.UUID;

public class DoctorNotFoundException extends RuntimeException {
    DoctorNotFoundException(UUID id){
        super("Could not find Doctor: " + id);
    }
}
