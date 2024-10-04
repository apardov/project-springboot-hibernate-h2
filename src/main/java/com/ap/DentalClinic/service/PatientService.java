package com.ap.DentalClinic.service;

import com.ap.DentalClinic.entities.Patient;
import com.ap.DentalClinic.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
// Indicates that this class is a Spring service component, which is a specialized form of @Component.
// It is used to encapsulate the business logic of the application.
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    // Marks the constructor to be autowired by Spring's dependency injection, allowing Spring to resolve
    // and inject the collaborating beans into this bean.
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> findPatientById(Integer id) {
        return patientRepository.findById(id);
    }

    public void updatePatient(Patient patient) {
        patientRepository.save(patient);
    }

    public void deletePatient(Integer id) {
        patientRepository.deleteById(id);
    }

    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

}
