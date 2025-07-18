package com.smarthealth.model;

public class Patient {
    private int id;
    private String name;
    private String email;
    private String password;
    private String contact;

    public Patient(String name, String email, String password, String contact) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.contact = contact;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getContact() {return contact;}
    public void setContact(String contact) {this.contact = contact;}
}
