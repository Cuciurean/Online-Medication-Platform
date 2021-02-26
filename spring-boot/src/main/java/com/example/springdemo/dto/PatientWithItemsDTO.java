package com.example.springdemo.dto;

import java.util.List;

public class PatientWithItemsDTO {
    private Integer id;
    private String name;
    private List<MedDTO> meds;

    public PatientWithItemsDTO(){}
    public PatientWithItemsDTO(Integer id, String name, List<MedDTO> meds) {
        this.id = id;
        this.name = name;
        this.meds = meds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MedDTO> getItems() {
        return meds;
    }

    public void setItems(List<MedDTO> items) {
        this.meds = meds;
    }
}
