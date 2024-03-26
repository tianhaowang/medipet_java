package com.example.medipet.doctors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="api/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    //Get all doctors
    @GetMapping(path="/get_all")
    List<Doctor> getAllDoctor(){
        return doctorService.getAllDoctors();
    }

    @PostMapping(path="/create")
    Doctor createDoctor(@RequestBody Doctor doctor){
        return doctorService.createDoctor(doctor);
    }

    @GetMapping(path="/{id}")
    Doctor getDoctor(@PathVariable UUID id){
        return doctorService.findDoctor(id);
    }

}
