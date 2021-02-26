package com.example.springdemo.controller;

import com.example.springdemo.services.MedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/meds")
public class MedController {
    private MedService medService;

    @Autowired
    public void setMedService(MedService medService) {
        this.medService = medService;
    }

    //TODO: to be implemented
}
