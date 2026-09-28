//package com.hackathon.agenda;
package com.hackathon.agenda.servicios;

import java.util.ArrayList;
import com.hackathon.agenda.modelos.Contacto;

import java.util.HashSet;
import java.util.Set;


public class AgendaService {
    private static final int TAMANO_POR_DEFECTO = 10;

    // Conjunto de contactos: un Set no permite repetidos (hashCode de Persona)

    private final Set<Contacto> contactos = new HashSet<>();
    private final int tamanoMaximo; //Cuántos contactos caben como máximo


    /** Crea la agenda con el tamaño por defecto (10). */
    public AgendaService() {
        this(TAMANO_POR_DEFECTO);
    }

    /** Crea la agenda con el tamaño máximo indicado. */
    public AgendaService(int tamanoMaximo) {
        this.tamanoMaximo = tamanoMaximo;
    }

    /**
     * Añade un contacto si es válido, no está repetido y hay espacio.
     * @return true si se añadió, false si no (el motivo se muestra por pantalla).
     */
    public boolean anadirContacto(Contacto c) {
        // Validar para no nulo y con nombre y apellido
        if (!esContactoValido(c)) {
            return false;
        }
        // Revisar que haya espacio
        if (estaLlena()) {
            System.out.println("Error: la agenda está llena.");
            return false;
        }
        // add() devuelve false si ya existe
        if (!contactos.add(c)) {
            System.out.println("Error: ya existe un contacto con ese nombre y apellido.");
            return false;
        }
        // si ya paso todo ya quedó guardado
        System.out.println("Contacto añadido: " + c);
        return true;
    }

    /** Comprueba que el contacto exista y tenga nombre y apellido. */
    private boolean esContactoValido(Contacto c) {
        if (c == null) {
            System.out.println("Error: el contacto no puede ser nulo.");
            return false;
        }
        if (c.tieneDatosVacios()) {
            System.out.println("Error: el nombre y el apellido no pueden estar vacíos.");
            return false;
        }
        return true;
    }

    /** Indica si ya no caben más contactos. */
    private boolean estaLlena() {
        return contactos.size() >= tamanoMaximo;
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
