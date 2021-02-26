package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.entities.Patient;

public class PatientBuilder {

    private PatientBuilder() {
    }

    public static PatientDTO generateDTOFromEntity(Patient patient){
        return new PatientDTO(
                patient.getId(),
                patient.getName(),
                patient.getBirth(),
                patient.getGender(),
                patient.getAddress(),
                patient.getRecord());

    }

    public static Patient generateEntityFromDTO(PatientDTO patientDTO){
        return new Patient(
                patientDTO.getId(),
                patientDTO.getName(),
                patientDTO.getBirth(),
                patientDTO.getGender(),
                patientDTO.getAddress(),
                patientDTO.getRecord());

}
}
