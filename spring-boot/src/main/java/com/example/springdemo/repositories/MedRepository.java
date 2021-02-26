package com.example.springdemo.repositories;

import com.example.springdemo.entities.Med;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedRepository extends JpaRepository<Med, Integer> {
}
