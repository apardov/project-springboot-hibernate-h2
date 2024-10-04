package com.ap.DentalClinic.service;

import com.ap.DentalClinic.entities.Dentist;
import com.ap.DentalClinic.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
// Indicates that this class is a Spring service component, which is a specialized form of @Component.
// It is used to encapsulate the business logic of the application.
public class DentistService {

    private final DentistRepository dentistRepository;

    @Autowired
    // Marks the constructor to be autowired by Spring's dependency injection, allowing Spring to resolve
    // and inject the collaborating beans into this bean.
    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    public Dentist saveDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    public Optional<Dentist> findDentistById(Integer id) {
        return dentistRepository.findById(id);
    }

    public void updateDentist(Dentist dentist) {
        dentistRepository.save(dentist);
    }

    public void deleteDentist(Integer id) {
        dentistRepository.deleteById(id);
    }

    public List<Dentist> findAllDentists() {
        return dentistRepository.findAll();
    }
}
