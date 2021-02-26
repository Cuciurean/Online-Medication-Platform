package com.example.springdemo.dto;

import java.util.Objects;

public class PatientDTO {

    private Integer id;
    private String name;
    private String birth;
    private String address;
    private String record;
    private String gender;

    public PatientDTO() {
    }

    public PatientDTO(Integer id, String name, String birth,String gender ,String address, String record) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.address = address;
        this.record = record;

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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientDTO patientDTO = (PatientDTO) o;
        return Objects.equals(id, patientDTO.id) &&
                Objects.equals(name, patientDTO.name) &&
                Objects.equals(birth, patientDTO.birth)&&
                Objects.equals(address, patientDTO.address) &&
                Objects.equals(record, patientDTO.record);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, birth,address, record);
    }
}
