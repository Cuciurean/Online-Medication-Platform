package com.example.springdemo.repositories;

import com.example.springdemo.entities.Caregiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaregiverRepository extends JpaRepository<Caregiver, Integer> {

    Caregiver findByGender(String gender);

    @Query(value = "SELECT u " +
            "FROM Caregiver u " +
            "ORDER BY u.name")
    List<Caregiver> getAllOrdered();

}
