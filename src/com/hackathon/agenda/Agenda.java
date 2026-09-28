package com.hackathon.agenda;

public class Agenda {


    //      PARTE DEL PROYECTO (MAFER)

    public void listarContactos() {
        if (this.contador == 0) {
            System.out.println("La agenda necesita un contacto :)");
            return;
        }

        System.out.println("--- LISTA DE CONTACTOS ¿a quién llamarás hoy? ---");
        for (int i = 0; i < this.contador; i++) {
            System.out.println((i + 1) + ". " + this.contactos[i]);
        }
    }

    public boolean agendaLlena() {
        return contador >= contactos.length;
    }

    public int espaciosLibres() {
        return contactos.length - contador;
    }
}