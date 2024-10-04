package com.ap.DentalClinic.controller;


import com.ap.DentalClinic.entities.Patient;
import com.ap.DentalClinic.service.PatientService;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


// Indicates that this class is a REST controller in a Spring Boot application.
// It is used to handle HTTP requests and send responses in a RESTful web service.
@RestController
// Maps HTTP requests to handler methods of the controller.
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    // Marks the constructor to be autowired by Spring's dependency injection, allowing Spring to resolve
    // and inject the collaborating beans into this bean.
    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // Handles HTTP POST requests to the specified URL and maps them to the save method.
    @PostMapping
    // @RequestBody Binds the HTTP request body to a method parameter in the save method.
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }


    // Handles HTTP GET requests to the specified URL and maps them to the findDentistByID method.
    @GetMapping
    // @RequestParam Binds the value of the query parameter `id` from the HTTP request to the method parameter `id`.
    public Optional<Patient> findPatientByID(@RequestParam Integer id) {
        return patientService.findPatientById(id);
    }


    // Handles HTTP PUT requests to the specified URL and maps them to the updateDentist method.
    @PutMapping("/update")
    // @RequestBody Binds the HTTP request body to a method parameter in the save method.
    public void updatePatient(@RequestBody Patient patient) {
        patientService.updatePatient(patient);
    }

    // Handles HTTP DELETE requests to the specified URL and maps them to the deleteDentist method.
    @DeleteMapping("/delete")
    // @RequestParam Binds the value of the query parameter `id` from the HTTP request to the method parameter `id`.
    public void deletePatient(@RequestParam Integer id) {
        patientService.deletePatient(id);
    }

    // Handles HTTP GET requests to the specified URL and maps them to the findAllDentist method.
    @GetMapping("/findall")
    public List<Patient> findAllPatient() {
        return patientService.findAllPatients();
    }


}
