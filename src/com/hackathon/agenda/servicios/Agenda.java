package com.hackathon.agenda.servicios;

public class Agenda {
    // =====================================================
    // ESTRUCTURA DE LA AGENDA
    // Aportación: Ximena
    // Se agregan los atributos necesarios para manejar la
    // capacidad de la agenda y permitir comprobar si está llena.
    // =====================================================

    private Contacto[] contactos;
    private int contador;


    // =====================================================
    // CONSTRUCTORES
    // Permite crear una agenda con capacidad personalizada
    // o utilizar el tamaño por defecto solicitado (10).
    // =====================================================

    // Constructor por defecto
    public Agenda() {
        this.contactos = new Contacto[10];
        this.contador = 0;
    }

    // Constructor con tamaño personalizado
    public Agenda(int capacidad) {
        this.contactos = new Contacto[capacidad];
        this.contador = 0;
    }



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
        for (Contacto contactoActual : this.contactos) {

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

}
