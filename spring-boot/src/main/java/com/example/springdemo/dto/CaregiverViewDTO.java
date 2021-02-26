package com.example.springdemo.dto;

public class CaregiverViewDTO {
    private Integer id;
    private String name;
    private String birth;
    private String address;
    private String patients;
    private String gender;

    public CaregiverViewDTO() {
    }

    public CaregiverViewDTO(Integer id, String name, String birth,String gender ,String address, String patients) {
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


}
