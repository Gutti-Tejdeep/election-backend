package com.springbootsql.model;

import jakarta.persistence.*;

@Entity
@Table(name = "volunteers")
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String address;
    private String workingArea;
    private String status;
    private String joinedOn;

    public Volunteer() {}

    public Volunteer(String name, String email, String phone, String address, String workingArea, String status, String joinedOn) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.workingArea = workingArea;
        this.status = status;
        this.joinedOn = joinedOn;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getWorkingArea() { return workingArea; }
    public void setWorkingArea(String workingArea) { this.workingArea = workingArea; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getJoinedOn() { return joinedOn; }
    public void setJoinedOn(String joinedOn) { this.joinedOn = joinedOn; }
}