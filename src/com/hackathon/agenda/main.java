package com.hackathon.agenda;

import java.util.SortedMap;

public class main {
    public static void main(String[] args) {
        Agenda miAgenda = new Agenda();

        Contacto c1 = new Contacto("Daniela", "Chagal", 569840341);
        miAgenda.agregarContacto(c1);
        Contacto c2 = new Contacto("Fernanda", "Enriquez", 5550008);
        miAgenda.agregarContacto(c2);
        Contacto c3 = new Contacto("Fernando", "Nava", 5550005);
        miAgenda.agregarContacto(c3);
        Contacto c4 = new Contacto("daniela", "chagal", 558060952);
        boolean resultado = miAgenda.existeContacto(c4);

        System.out.println("El contacto existe en la agenda?: " + resultado);
    }
}
