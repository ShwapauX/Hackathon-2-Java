package com.hackathon.agenda;
import com.hackathon.agenda.menu.MenuConsola;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciamos el menú
        MenuConsola menu = new MenuConsola();

        // 2. Llamamos al método que arranca toda la interacción
        menu.iniciarMenu();
    }
}
