package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.CaregiverDTO;
import com.example.springdemo.entities.Caregiver;

public class CaregiverBuilder {

    private CaregiverBuilder() {
    }

    public static CaregiverDTO generateDTOFromEntity(Caregiver patient){
        return new CaregiverDTO(
                patient.getId(),
                patient.getName(),
                patient.getBirth(),
                patient.getGender(),
                patient.getAddress(),
                patient.getPatients());

    }

    public static Caregiver generateEntityFromDTO(CaregiverDTO patientDTO){
        return new Caregiver(
                patientDTO.getId(),
                patientDTO.getName(),
                patientDTO.getBirth(),
                patientDTO.getGender(),
                patientDTO.getAddress(),
                patientDTO.getPatients());

    }
}
