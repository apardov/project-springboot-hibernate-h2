package com.ap.DentalClinic.repository;

import com.ap.DentalClinic.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Indicates that this interface is a Spring Data repository, which is a specialized
// form of @Component. It is used to encapsulate storage, retrieval, and search behavior which
// emulates a collection of objects.

public interface DentistRepository extends JpaRepository<Dentist, Integer> {


}
