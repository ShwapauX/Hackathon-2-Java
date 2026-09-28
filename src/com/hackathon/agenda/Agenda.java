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


public class Agenda {

    public boolean eliminarContacto(Contacto c) {
        boolean eliminado = contactos.remove(c);

        if (eliminado) {
            System.out.println("Contacto eliminado");
        } else {
            System.out.println("Contacto no encontrado");
        }

        return eliminado;
    }
    /**
     * Modifica el teléfono de un contacto existente.
     */
    public void modificarTelefono(String nombre, String nuevoTelefono) {
        contactos.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                // Si existe, se actualiza el teléfono; si no, se avisa por pantalla
                .ifPresentOrElse(
                        c -> {
                            c.setTelefono(nuevoTelefono);
                            System.out.println("Teléfono modificado.");
                        },
                        () -> System.out.println("No se ha encontrado el contacto."));
    }

}
