package com.example.springdemo.services;

import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.dto.PatientViewDTO;
import com.example.springdemo.dto.PatientWithItemsDTO;
import com.example.springdemo.dto.builders.PatientBuilder;
import com.example.springdemo.dto.builders.PatientViewBuilder;
import com.example.springdemo.dto.builders.PatientWithItemsBuilder;
import com.example.springdemo.entities.Patient;

import com.example.springdemo.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientViewDTO findPatientById(Integer id){
        Optional<Patient> doctor  = patientRepository.findById(id);


        return PatientViewBuilder.generateDTOFromEntity(doctor.get());
    }

    public List<PatientViewDTO> findAll(){
        List<Patient> patients = patientRepository.getAllOrdered();

        return patients.stream()
                .map(PatientViewBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public List<PatientWithItemsDTO> findAllFetch(){
        List<Patient> patientList = patientRepository.getAllFetch();

        return patientList.stream()
                .map(x-> PatientWithItemsBuilder.generateDTOFromEntity(x, x.getMeds()))
                .collect(Collectors.toList());
    }


    //WRONG - without fetch an additional query is executed for each FK
    public List<PatientWithItemsDTO> findAllFetchWrong(){
        List<Patient> patientList = patientRepository.findAll();

        return patientList.stream()
                .map(x-> PatientWithItemsBuilder.generateDTOFromEntity(x, x.getMeds()))
                .collect(Collectors.toList());
    }

    public Integer insert(PatientDTO patientDTO) {


        Patient patient = patientRepository.findByGender(patientDTO.getBirth());


        return patientRepository
                .save(PatientBuilder.generateEntityFromDTO(patientDTO))
                .getId();
    }

    public Integer update(PatientDTO patientDTO) {

        Optional<Patient> person = patientRepository.findById(patientDTO.getId());




        return patientRepository.save(PatientBuilder.generateEntityFromDTO(patientDTO)).getId();
    }

    public void delete(Integer id){
        this.patientRepository.deleteById(id);
    }

}
