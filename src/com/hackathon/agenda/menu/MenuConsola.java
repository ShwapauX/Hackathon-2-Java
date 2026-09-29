package com.hackathon.agenda.menu;

import com.hackathon.agenda.modelos.Contacto;
import com.hackathon.agenda.servicios.Agenda;
import java.util.Scanner;

public class MenuConsola {

    public void iniciarMenu() {
        Scanner scanner = new Scanner(System.in);

        // Aquí se instancia el servicio ya sea con tamaño por defecto de 10
        Agenda agenda = new Agenda();

        int opcion = 0;

        do {
            System.out.println("\n       AGENDA TELEFÓNICA");
            System.out.println("=================================");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Modificar teléfono");
            System.out.println("5. Listar contactos");
            System.out.println("6. Verificar espacios libres");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");

            // Validación básica para evitar que el programa falle si no ingresan un número
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar
            } else {
                System.out.println("Error: Por favor ingresa un número válido.");
                scanner.nextLine(); // Limpiar
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- AÑADIR CONTACTO ---");
                    System.out.print("Introduce el nombre: ");
                    String nombreAnadir = scanner.nextLine();
                    System.out.print("Introduce el apellido: ");
                    String apellidoAnadir = scanner.nextLine();
                    System.out.print("Introduce el teléfono: ");
                    String telefonoAnadir = scanner.nextLine();

                    // Aquí se conectara con el método de Jaz:
                    Contacto nuevoContacto = new Contacto(nombreAnadir, apellidoAnadir, telefonoAnadir);
                    agenda.anadirContacto(nuevoContacto);
                    break;

                case 2:
                    System.out.println("\n--- BUSCAR CONTACTO ---");
                    System.out.print("Introduce el nombre: ");
                    String nombreBuscar = scanner.nextLine();
                    System.out.print("Introduce el apellido: ");
                    String apellidoBuscar = scanner.nextLine();

                    // Aquí se conectara con el método (Chris):
                    agenda.buscarContacto(nombreBuscar, apellidoBuscar);
                    break;

                case 3:
                    System.out.println("\n--- ELIMINAR CONTACTO ---");
                    System.out.print("Introduce el nombre del contacto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    System.out.print("Introduce el apellido: ");
                    String apellidoEliminar = scanner.nextLine();

                    // Aquí se conectara con el método de Daniel:
                    Contacto contactoAEliminar = new Contacto(nombreEliminar, apellidoEliminar);
                    agenda.eliminarContacto(contactoAEliminar);
                    break;

                case 4:
                    System.out.println("\n--- MODIFICAR TELÉFONO ---");
                    System.out.print("Introduce el nombre del contacto: ");
                    String nombreModificar = scanner.nextLine();
                    System.out.print("Introduce el apellido: ");
                    String apellidoModificar = scanner.nextLine();
                    System.out.print("Introduce el NUEVO teléfono: ");
                    String nuevoTelefono = scanner.nextLine();

                    // Aquí se conectara con el método de Fer Nava:
                    agenda.modificarTelefono(nombreModificar, apellidoModificar, nuevoTelefono);
                    break;

                case 5:
                    System.out.println("\n--- LISTA DE CONTACTOS ---");
                    // Aquí se conectara con el método de Mafer:
                    agenda.listarContactos();
                    break;

                case 6:
                    System.out.println("\n--- ESTADO DE LA AGENDA ---");
                    // Aquí conectara con los métodos de Ximena y Fer Enríquez:
                    System.out.println("La agenda está " + (agenda.agendaLlena() ? "llena." : "con espacio."));
                    System.out.println("Espacios libres: " + agenda.espaciosLibres());
                    break;

                case 7:
                    System.out.println("Saliendo del programa... ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elige un número del 1 al 7.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}
