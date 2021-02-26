package com.example.springdemo.dto;

import java.util.Objects;

public class CaregiverDTO {

    private Integer id;
    private String name;
    private String birth;
    private String address;
    private String patients;
    private String gender;

    public CaregiverDTO() {
    }

    public CaregiverDTO(Integer id, String name, String birth,String gender ,String address, String patients) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.address = address;
        this.patients = patients;

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

    public String getPatients() {
        return patients;
    }

    public void setPatients(String patients) {
        this.patients = patients;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaregiverDTO caregiverDTO = (CaregiverDTO) o;
        return Objects.equals(id, caregiverDTO.id) &&
                Objects.equals(name, caregiverDTO.name) &&
                Objects.equals(birth, caregiverDTO.birth)&&
                Objects.equals(address, caregiverDTO.address) &&
                Objects.equals(patients, caregiverDTO.patients);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, birth,address, patients);
    }
}
