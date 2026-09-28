package com.hackathon.agenda;

public class EspaciosLibres {
    /**
     * Retorna el número de posiciones disponibles.
     */
    public int espacioLibres() {
        int libres = 0;
        for (Contacto contacto : contactos) {
            if (contacto == null) {
                libres++;
            }
        }
        return libres;
    }
}

