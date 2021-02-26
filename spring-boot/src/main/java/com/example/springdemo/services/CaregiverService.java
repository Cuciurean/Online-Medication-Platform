package com.example.springdemo.services;

import com.example.springdemo.dto.CaregiverDTO;
import com.example.springdemo.dto.CaregiverViewDTO;
import com.example.springdemo.dto.builders.CaregiverBuilder;
import com.example.springdemo.dto.builders.CaregiverViewBuilder;
import com.example.springdemo.entities.Caregiver;
import com.example.springdemo.repositories.CaregiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CaregiverService {

    private final CaregiverRepository patientRepository;

    @Autowired
    public CaregiverService(CaregiverRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public CaregiverViewDTO findCaregiverById(Integer id){
        Optional<Caregiver> doctor  = patientRepository.findById(id);


        return CaregiverViewBuilder.generateDTOFromEntity(doctor.get());
    }

    public List<CaregiverViewDTO> findAll(){
        List<Caregiver> patients = patientRepository.getAllOrdered();

        return patients.stream()
                .map(CaregiverViewBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }



    public Integer insert(CaregiverDTO patientDTO) {


        Caregiver patient = patientRepository.findByGender(patientDTO.getBirth());


        return patientRepository
                .save(CaregiverBuilder.generateEntityFromDTO(patientDTO))
                .getId();
    }

    public Integer update(CaregiverDTO patientDTO) {

        Optional<Caregiver> person = patientRepository.findById(patientDTO.getId());




        return patientRepository.save(CaregiverBuilder.generateEntityFromDTO(patientDTO)).getId();
    }

    public void delete(Integer id){
        this.patientRepository.deleteById(id);
    }

}
