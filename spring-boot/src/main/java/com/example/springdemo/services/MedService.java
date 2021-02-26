package com.example.springdemo.services;

import com.example.springdemo.repositories.MedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedService {
    private MedRepository medRepository;

    @Autowired
    public void setMedRepository(MedRepository medRepository) {
        this.medRepository = medRepository;
    }

    //TODO: to be implemented
}
