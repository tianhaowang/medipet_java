package com.example.medipet.doctors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorService {

    final DoctorRepository doctorRepository;

    @Autowired
    DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    Doctor createDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    Doctor findDoctor(UUID id){
        return doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException(id));
    }

}
