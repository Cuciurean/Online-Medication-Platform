package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.MedDTO;
import com.example.springdemo.dto.PatientWithItemsDTO;
import com.example.springdemo.entities.Med;
import com.example.springdemo.entities.Patient;

import java.util.List;
import java.util.stream.Collectors;

public class PatientWithItemsBuilder {
    private PatientWithItemsBuilder(){}

    public static PatientWithItemsDTO generateDTOFromEntity(Patient patient, List<Med> meds){
        List<MedDTO> dtos =  meds.stream()
                .map(MedBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());

        return new PatientWithItemsDTO(
                patient.getId(),
                patient.getName(),
                dtos);
    }

}
