package com.ap.DentalClinic.entities;

import jakarta.persistence.*;

// JPA annotations for ORM (Object-Relational Mapping)

@Entity // Specifies that the class is an entity and is mapped to a database table
@Table(name = "dentists") // Specifies the name of the database table to be used for mapping
public class Dentist {

    @Id // Specifies the primary key of an entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Provides the specification of generation strategies for the values of primary keys

    @Column(name = "dentist_id") // Specifies the mapped column for a persistent property or field
    private Integer id;
    @Column(name = "registration", nullable = false)
    private Integer registration;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "last_name", nullable = false)
    private String lastName;

    public Dentist() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRegistration() {
        return registration;
    }

    public void setRegistration(Integer registration) {
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
