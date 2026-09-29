package com.hackathon.agenda.modelos;

import java.util.Objects;

// =====================================================
// PARTE DEL PROYECTO (Jazmin Hernández)
// =====================================================
/** persona se identifica por nombre y apellido. */
public abstract class Persona { //abstract: solo queremos usarla como base para otras clases.
    // "final": una vez asignado en el constructor, ya no puede cambiar.
    private final String nombre;
    private final String apellido;
    
    // ========Constructor=============
    protected Persona(String nombre, String apellido) {
        // "this.nombre" es el atributo de la clase "nombre" es el dato recibido
        // "limpiamos" con el método normalizar.
        this.nombre = normalizar(nombre);
        this.apellido = normalizar(apellido);
    }

    /** Devuelve el nombre espacios sobrantes */
    public String getNombre() {
        return nombre;
    }

    /** Devuelve el apellido espacios sobrantes */
    public String getApellido() {
        return apellido;
    }

    /** Indica si el nombre o el apellido están vacíos. */
    public boolean tieneDatosVacios() {
        return nombre.isBlank() || apellido.isBlank(); // isBlank: revisa que no esten vacios
    }

    /** Convierte null en texto vacío y quita espacios sobrantes. */
    private static String normalizar(String texto) {
        // null lo convierte en texto vacío ""
        // le quita los espacios del inicio y del final con trim()
        return texto == null ? "" : texto.trim();
    }

    /** Iguales si tienen mismo nombre y apellido, sin distinguir mayúsculas. */
    @Override
    public boolean equals(Object objeto) {
        // Solo si es exactamente el mismo objeto, obviamente son iguales.
        if (this == objeto) return true;
        //Si lo que nos ingresan es null o es de otro tipo de clase, obviamente no pueden ser iguales.
        if (objeto == null || getClass() != objeto.getClass()) return false;
        // Convierte (cast) el objeto genérico a tipo Persona para acceder a sus atributos específicos
        // cast = (Persona)
        Persona otra = (Persona) objeto;
        //    equalsIgnoreCase compara ignorando mayúsculas y minúsculas.
        return nombre.equalsIgnoreCase(otra.nombre)
                && apellido.equalsIgnoreCase(otra.apellido);
    }

    /** Coherente con equals, necesario para que HashSet detecte duplicados. */
    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), apellido.toLowerCase());
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}
