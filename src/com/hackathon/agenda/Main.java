package com.hackathon.agenda;

public class Main {
    public static void main(String[] args) {
        // Creamos una agenda de 10 espacios
        Agenda miAgenda = new Agenda(10);

        // Agregamos contactos de prueba
        miAgenda.anadirContacto(new Contacto("Jaz Gomez", "555-0001"));
        miAgenda.anadirContacto(new Contacto("Mafer Lopez", "555-0003"));

        System.out.println(); // Espacio en blanco

        // Probamos el método
        miAgenda.listarContactos();
    }
}