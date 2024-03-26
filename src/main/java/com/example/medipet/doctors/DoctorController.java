package com.example.medipet.doctors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;
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

    @PostMapping(path="/login")
    Doctor login(@RequestBody LoginCredentials credentials) {
        // Your authentication logic here
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        // Assuming you have a service to authenticate the doctor
        Optional<Doctor> doctor = doctorService.authenticate(username, password);

        if(doctor.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Login failed");
        }

        return doctor.get(); // Return the authenticated doctor
    }

    @PostMapping(path="logout")
    String logout(){
        return "Successful";
    }



}
