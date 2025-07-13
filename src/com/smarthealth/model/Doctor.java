package com.smarthealth.model;

public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private String location;
    private String contact;

    public Doctor(){}

    public Doctor(String name, String specialization,String location, String contact) {
        this.name = name;
        this.specialization = specialization;
        this.location = location;
        this.contact = contact;
    }

    public Doctor(int id, String name, String specialization, String location, String contact) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.location = location;
        this.contact = contact;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getSpecialization() {return specialization;}
    public void setSpecialization(String specialization) {this.specialization = specialization;}

    public String getContact() {return contact;}
    public void setContact(String contact) {this.contact = contact;}

    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}

@Override
    public String toString(){
        return "Doctor{"+
                "id="+id+
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", contact='" + contact + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

}
