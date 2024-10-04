package com.ap.DentalClinic.controller;


import com.ap.DentalClinic.entities.Dentist;
import com.ap.DentalClinic.service.DentistService;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


// Indicates that this class is a REST controller in a Spring Boot application.
// It is used to handle HTTP requests and send responses in a RESTful web service.
@RestController
// Maps HTTP requests to handler methods of the controller.
@RequestMapping("/dentist")
public class DentistController {

    private final DentistService dentistService;

    // Marks the constructor to be autowired by Spring's dependency injection, allowing Spring to resolve
    // and inject the collaborating beans into this bean.
    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    // Handles HTTP POST requests to the specified URL and maps them to the save method.
    @PostMapping
    // @RequestBody Binds the HTTP request body to a method parameter in the save method.
    public Dentist saveDentist(@RequestBody Dentist dentist) {
        return dentistService.saveDentist(dentist);
    }


    // Handles HTTP GET requests to the specified URL and maps them to the findDentistByID method.
    @GetMapping
    // @RequestParam Binds the value of the query parameter `id` from the HTTP request to the method parameter `id`.
    public Optional<Dentist> findDentistByID(@RequestParam Integer id) {
        if (dentistService.findDentistById(id).isPresent()) {

            return dentistService.findDentistById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dentist not found");
        }
    }


    // Handles HTTP PUT requests to the specified URL and maps them to the updateDentist method.
    @PutMapping("/update")
    // @RequestBody Binds the HTTP request body to a method parameter in the save method.
    public void updateDentist(@RequestBody Dentist dentist) {
        dentistService.updateDentist(dentist);
    }

    // Handles HTTP DELETE requests to the specified URL and maps them to the deleteDentist method.
    @DeleteMapping("/delete")
    // @RequestParam Binds the value of the query parameter `id` from the HTTP request to the method parameter `id`.

    public void deleteDentist(@RequestParam Integer id) {
        dentistService.deleteDentist(id);
    }

    // Handles HTTP GET requests to the specified URL and maps them to the findAllDentist method.
    @GetMapping("/findall")
    public List<Dentist> findAllDentist() {
        return dentistService.findAllDentists();
    }


}
