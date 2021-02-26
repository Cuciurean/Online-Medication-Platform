package com.example.springdemo.entities;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "birth")
    private String birth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "record")
    private String record;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private List<Med> meds;

    public Patient() {
    }

    public Patient(Integer id, String name, String birth,String gender ,String address, String record) {
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


    public List<Med> getMeds() {
        return meds;
    }

    public void setMeds(List<Med> meds) {
        this.meds = meds;
    }
}
