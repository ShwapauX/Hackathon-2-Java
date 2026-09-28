package com.hackathon.agenda.modelos;

//todo: Probar método
public class Contacto {

    //* Atributos
    private String name;
    private String lastname;
    private Integer phone;

    //* Getter y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    //* Constructor
    public Contacto(String name, String lastname, Integer phone) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;


    }

}