package com.example.springdemo.controller;


import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.dto.PatientViewDTO;
import com.example.springdemo.dto.PatientWithItemsDTO;
import com.example.springdemo.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value = "/{id}")
    public PatientViewDTO findById(@PathVariable("id") Integer id){
        return patientService.findPatientById(id);
    }

    @GetMapping()
    public List<PatientViewDTO> findAll(){
        return patientService.findAll();
    }

    @GetMapping(value = "/meds")
    public List<PatientWithItemsDTO> findAllWithItems(){
        return patientService.findAllFetch();
    }

    @GetMapping(value = "/meds/wrong")
    public List<PatientWithItemsDTO> findAllWithItemsWrong(){
        return patientService.findAllFetchWrong();
    }

    @PostMapping()
    public Integer insertPersonDTO(@RequestBody PatientDTO patientDTO){
        return patientService.insert(patientDTO);
    }

    @PutMapping()
    public Integer updatePerson(@RequestBody PatientDTO patientDTO) {
        return patientService.update(patientDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Integer id){
        System.out.println("In delete");
        patientService.delete(id);
    }
}
