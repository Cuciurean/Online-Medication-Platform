package com.example.springdemo.dto.builders;

import com.example.springdemo.dto.MedDTO;
import com.example.springdemo.entities.Med;

public class MedBuilder {
    private MedBuilder() {
    }

    public static MedDTO generateDTOFromEntity(Med med) {
        return new MedDTO(
                med.getId(),
                med.getName());
    }

    public static Med generateEntityFromDTO(MedDTO medDTO) {
        return new Med(
                medDTO.getId(),
                medDTO.getName());
    }
}
