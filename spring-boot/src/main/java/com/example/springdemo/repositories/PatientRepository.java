package com.example.springdemo.repositories;

import com.example.springdemo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Patient findByGender(String gender);

    @Query(value = "SELECT u " +
            "FROM Patient u " +
            "ORDER BY u.name")
    List<Patient> getAllOrdered();


    @Query(value = "SELECT p " +
            "FROM Patient p " +
            "INNER JOIN FETCH p.meds i"
    )
    List<Patient> getAllFetch();
}
