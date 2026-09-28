package com.hackathon.agenda.servicios.Age
import java.util.ArrayList;
import java.util.List;

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

    // PARTE DEL PROYECTO (Chris)
    /**
     * Busca un contacto en la agenda por su nombre y muestra su teléfono.
     *
     * @param nombre El nombre del contacto que se desea buscar.
     */
    public void buscaContacto(String nombre) {
        // 1. Validación rápida
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Error: El nombre de búsqueda no puede estar vacío.");
            return;
        }

        boolean contactoEncontrado = false;

        // 2. OOP (Colecciones/Arreglos) y Legibilidad: Uso de un for-each claro
        for (Contacto contactoActual : this.listaContactos) {

            // Validamos que el espacio no esté vacío y comparamos ignorando mayúsculas/minúsculas
            if (contactoActual != null && contactoActual.getNombre().equalsIgnoreCase(nombre.trim())) {

                System.out.println("Contacto encontrado:");
                System.out.println(contactoActual.getNombre() + " " + contactoActual.getApellido() + " - Teléfono: " + contactoActual.getTelefono());

                contactoEncontrado = true;

                break;
            }
        }

        // Si el ciclo termina y la bandera sigue en false, el contacto no existe
        if (!contactoEncontrado) {
            System.out.println("No se ha encontrado ningún contacto con el nombre: " + nombre);
        }
    }
    // Fin de (Chris)

    //Codigo de Dani chagal
    private List<Contacto> contactos;
    private int capacidadMaxima;

    //? Tamaño personalizado
    public Agenda(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.contactos = new ArrayList<>();
    }

    //? Por defecto
    public Agenda() {
        this(10);
    }

    //todo: Cantidad de contactos
    public boolean agregarContacto(Contacto c) {
        if (contactos.size() < capacidadMaxima) {
            contactos.add(c);
            return true;
        } return false;
    }

    //* Comienzo del código de la tarea
    //todo: Verificar si un contacto ya existe en la agenda
    public boolean existeContacto(Contacto c) {
        if (c == null || c.getName() == null || c.getLastname() == null) {
            return false;
        }

        for (Contacto contactoGuardado : contactos) {
            boolean mismoNombre = contactoGuardado.getName().equalsIgnoreCase(c.getName());
            boolean mismoApellido = contactoGuardado.getLastname().equalsIgnoreCase(c.getLastname());
            if (mismoNombre && mismoApellido) {
                return true;
            }
        } return false;
    } //* Fin del código de la tarea

    //! Getters
    public List<Contacto> getContactos() {
        return contactos;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    //Fin Dani Chagal

    public boolean eliminarContacto(Contacto c) { //Codigo de Daniel Arellano
        boolean eliminado = false;

        if (c != null) {
            for (Contacto guardado : contactos) {
                boolean mismoNombre = guardado.getName().equalsIgnoreCase(c.getName());
                boolean mismoApellido = guardado.getLastname().equalsIgnoreCase(c.getLastname());
                if (mismoNombre && mismoApellido) {
                    contactos.remove(guardado);
                    eliminado = true;
                    break;
                }
            }
        }

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
    public void modificarTelefono(String nombre, String nuevoTelefono) { // Codigo de Fer Nava
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
