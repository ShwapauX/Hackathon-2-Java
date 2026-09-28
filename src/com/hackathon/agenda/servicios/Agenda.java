package com.hackathon.agenda.servicios;

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

}
