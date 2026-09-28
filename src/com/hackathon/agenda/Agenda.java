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

}
