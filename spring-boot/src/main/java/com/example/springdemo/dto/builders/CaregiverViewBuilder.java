package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.CaregiverViewDTO;
import com.example.springdemo.entities.Caregiver;

public class CaregiverViewBuilder {
    private CaregiverViewBuilder(){}

    public static CaregiverViewDTO generateDTOFromEntity(Caregiver patient){
        return new CaregiverViewDTO(
                patient.getId(),
                patient.getName(),
                patient.getBirth(),
                patient.getGender(),
                patient.getAddress(),
                patient.getPatients());
    }

    public static Caregiver generateEntityFromDTO(CaregiverViewDTO patientViewDTO){
        return new Caregiver(
                patientViewDTO.getId(),
                patientViewDTO.getName(),
                patientViewDTO.getBirth(),
                patientViewDTO.getGender(),
                patientViewDTO.getAddress(),
                patientViewDTO.getPatients());
    }
}
