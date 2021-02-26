package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.PatientViewDTO;
import com.example.springdemo.entities.Patient;

public class PatientViewBuilder {
    private PatientViewBuilder(){}

    public static PatientViewDTO generateDTOFromEntity(Patient patient){
        return new PatientViewDTO(
                patient.getId(),
                patient.getName(),
                patient.getBirth(),
                patient.getGender(),
                patient.getAddress(),
                patient.getRecord());
    }

    public static Patient generateEntityFromDTO(PatientViewDTO patientViewDTO){
        return new Patient(
                patientViewDTO.getId(),
                patientViewDTO.getName(),
                patientViewDTO.getBirth(),
                patientViewDTO.getGender(),
                patientViewDTO.getAddress(),
                patientViewDTO.getRecord());
    }
}
