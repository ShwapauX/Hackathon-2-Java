package com.hackathon.agenda.servicios;

import com.hackathon.agenda.modelos.Contacto;
import java.util.HashSet;
import java.util.Set;

public class Agenda {
    // =====================================================
    // ESTRUCTURA DE LA AGENDA
    // Aportación: Ximena
    // Se agregan los atributos necesarios para manejar la
    // capacidad de la agenda y permitir comprobar si está llena.
    // Además usamos Set para evitar repetidos (coherente con equals/hashCode de Persona)
    // =====================================================

    private final Set<Contacto> contactos;
    private final int tamanoMaximo;

    // =====================================================
    // CONSTRUCTORES
    // Aportación combinada (Dani chagal, Ximena, etc.)
    // Permite crear una agenda con capacidad personalizada
    // o utilizar el tamaño por defecto solicitado (10).
    // =====================================================

    // Constructor por defecto
    public Agenda() {
        this(10);
    }

    // Constructor con tamaño personalizado
    public Agenda(int tamanoMaximo) {
        this.tamanoMaximo = tamanoMaximo;
        this.contactos = new HashSet<>();
    }

    // =====================================================
    // PARTE DEL PROYECTO (Jaz y demás equipo)
    // Añadir y validar contactos
    // =====================================================

    /**
     * Añade un contacto si es válido, no está repetido y hay espacio.
     * @return true si se añadió, false si no (el motivo se muestra por pantalla).
     */
    public boolean anadirContacto(Contacto c) {
        // Validar para no nulo y con nombre y apellido
        if (!esContactoValido(c)) {
            return false;
        }
        // Revisar que haya espacio (Aportación: Ximena)
        if (agendaLlena()) {
            System.out.println("Error: la agenda está llena.");
            return false;
        }
        // add() devuelve false si ya existe gracias al Set y el equals
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

    // =====================================================
    // PARTE DEL PROYECTO (MAFER)
    // =====================================================

    public void listarContactos() {
        if (this.contactos.isEmpty()) {
            System.out.println("La agenda necesita un contacto :)");
            return;
        }

        System.out.println("--- LISTA DE CONTACTOS ¿a quién llamarás hoy? ---");
        int i = 1;
        for (Contacto contacto : contactos) {
            System.out.println(i + ". " + contacto);
            i++;
        }
    }

    // =====================================================
    // PARTE DEL PROYECTO (Chris)
    // =====================================================
    /**
     * Busca un contacto en la agenda por su nombre y apellido.
     */
    public void buscarContacto(String nombre, String apellido) {
        // 1. Validación rápida
        if (nombre == null || nombre.trim().isEmpty() || apellido == null || apellido.trim().isEmpty()) {
            System.out.println("Error: El nombre y apellido de búsqueda no pueden estar vacíos.");
            return;
        }

        boolean contactoEncontrado = false;

        // 2. OOP (Colecciones/Arreglos) y Legibilidad: Uso de un for-each claro
        for (Contacto contactoActual : this.contactos) {

            // Validamos comparando ignorando mayúsculas/minúsculas
            if (contactoActual.getNombre().equalsIgnoreCase(nombre.trim()) &&
                contactoActual.getApellido().equalsIgnoreCase(apellido.trim())) {

                System.out.println("Contacto encontrado:");
                System.out.println(contactoActual.getNombre() + " " + contactoActual.getApellido() + " - Teléfono: " + contactoActual.getTelefono());

                contactoEncontrado = true;
                break;
            }
        }

        // Si el ciclo termina y la bandera sigue en false, el contacto no existe
        if (!contactoEncontrado) {
            System.out.println("No se ha encontrado ningún contacto con el nombre y apellido especificados.");
        }
    }
    // Fin de (Chris)

    // =====================================================
    // PARTE DEL PROYECTO (Daniel Arellano)
    // =====================================================
    public boolean eliminarContacto(Contacto c) {
        boolean eliminado = contactos.remove(c);

        if (eliminado) {
            System.out.println("Contacto eliminado");
        } else {
            System.out.println("Contacto no encontrado");
        }

        return eliminado;
    }

    // =====================================================
    // PARTE DEL PROYECTO (Fer Nava)
    // =====================================================
    /**
     * Modifica el teléfono de un contacto existente.
     */
    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        contactos.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido))
                .findFirst()
                // Si existe, se actualiza el teléfono; si no, se avisa por pantalla
                .ifPresentOrElse(
                        c -> {
                            c.setTelefono(nuevoTelefono);
                            System.out.println("Teléfono modificado: " + c);
                        },
                        () -> System.out.println("No se ha encontrado el contacto."));
    }

    // =====================================================
    // UTILIDADES (Ximena y Fer Enríquez)
    // =====================================================
    public boolean agendaLlena() {
        return contactos.size() >= tamanoMaximo;
    }

    /**
     * Retorna el número de posiciones disponibles.
     */
    public int espaciosLibres() {
        return tamanoMaximo - contactos.size();
    }
    
    // =====================================================
    // GETTERS (Dani Chagal)
    // =====================================================
    public Set<Contacto> getContactos() {
        return contactos;
    }

    public int getCapacidadMaxima() {
        return tamanoMaximo;
    }
}
