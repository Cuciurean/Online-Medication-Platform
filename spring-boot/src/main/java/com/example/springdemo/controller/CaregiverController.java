package com.example.springdemo.controller;


import com.example.springdemo.dto.CaregiverDTO;

import com.example.springdemo.dto.CaregiverViewDTO;
import com.example.springdemo.dto.PatientWithItemsDTO;
import com.example.springdemo.services.CaregiverService;
import com.example.springdemo.services.MedService;
import com.example.springdemo.services.CaregiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/caregiver")
public class CaregiverController {


    private final CaregiverService caregiverService;

    @Autowired
    public CaregiverController(CaregiverService caregiverService) {
        this.caregiverService = caregiverService;
    }

    @GetMapping(value = "/{id}")
    public CaregiverViewDTO findById(@PathVariable("id") Integer id){
        return caregiverService.findCaregiverById(id);
    }

    @GetMapping()
    public List<CaregiverViewDTO> findAll(){
        return caregiverService.findAll();
    }


    @PostMapping()
    public Integer insertPersonDTO(@RequestBody CaregiverDTO caregiverDTO){
        return caregiverService.insert(caregiverDTO);
    }

    @PutMapping()
    public Integer updatePerson(@RequestBody CaregiverDTO caregiverDTO) {
        return caregiverService.update(caregiverDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Integer id){
        System.out.println("In delete");
        caregiverService.delete(id);
    }
}
