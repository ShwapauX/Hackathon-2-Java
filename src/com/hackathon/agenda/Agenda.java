package com.hackathon.agenda;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private List<Contacto> contactos;
    private int capacidadMaxima;

    //? Tamaño personalizado
    public Agenda(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.contactos = new ArrayList<>();
    }

    //? Por defecto
    public Agenda() {
        this(10);
    }

    //todo: Cantidad de contactos
    public boolean agregarContacto(Contacto c) {
        if (contactos.size() < capacidadMaxima) {
            contactos.add(c);
            return true;
        } return false;
    }

    //* Comienzo del código de la tarea
    //todo: Verificar si un contacto ya existe en la agenda
    public boolean existeContacto(Contacto c) {
        if (c == null || c.getName() == null || c.getLastname() == null) {
            return false;
        }

        for (Contacto contactoGuardado : contactos) {
            boolean mismoNombre = contactoGuardado.getName().equalsIgnoreCase(c.getName());
            boolean mismoApellido = contactoGuardado.getLastname().equalsIgnoreCase(c.getLastname());
            if (mismoNombre && mismoApellido) {
                return true;
        }
    } return false;
} //* Fin del código de la tarea

    //! Getters
    public List<Contacto> getContactos() {
        return contactos;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
}
