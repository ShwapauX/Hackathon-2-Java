package com.hackathon.agenda;

import java.util.ArrayList;




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
