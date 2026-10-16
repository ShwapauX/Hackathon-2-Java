package com.hackathon.agenda;

import com.hackathon.agenda.menu.MenuSwing;

public class Main {
    public static void main(String[] args) {
        // Inicia la ventana de Swing en el hilo encargado de dibujar la interfaz.
        javax.swing.SwingUtilities.invokeLater(() -> new MenuSwing().iniciar());
    }
}