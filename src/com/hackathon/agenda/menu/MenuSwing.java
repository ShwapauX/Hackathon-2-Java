package com.hackathon.agenda.menu;

import com.hackathon.agenda.modelos.Contacto;
import com.hackathon.agenda.servicios.Agenda;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Comparator;
import java.util.Optional;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MenuSwing {

    private final Agenda agenda = new Agenda();
    private final JFrame ventana = new JFrame("Agenda telefónica");
    private final JTextArea listaContactos = new JTextArea();
    private final JLabel estadoAgenda = new JLabel();

    public void iniciar() {
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel("Agenda telefónica", JLabel.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(12, 8, 4, 8));
        ventana.add(titulo, BorderLayout.NORTH);

        listaContactos.setEditable(false);
        listaContactos.setText("Todavía no hay contactos.");
        ventana.add(new JScrollPane(listaContactos), BorderLayout.CENTER);

        JPanel botones = new JPanel(new GridLayout(0, 2, 8, 8));
        botones.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        agregarBoton(botones, "Agregar contacto", this::agregarContacto);
        agregarBoton(botones, "Buscar contacto", this::buscarContacto);
        agregarBoton(botones, "Modificar teléfono", this::modificarTelefono);
        agregarBoton(botones, "Eliminar contacto", this::eliminarContacto);
        agregarBoton(botones, "Actualizar lista", this::actualizarLista);
        agregarBoton(botones, "Salir", () -> ventana.dispose());
        ventana.add(botones, BorderLayout.WEST);

        estadoAgenda.setBorder(BorderFactory.createEmptyBorder(4, 10, 10, 10));
        ventana.add(estadoAgenda, BorderLayout.SOUTH);

        actualizarLista();
        ventana.setSize(650, 400);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    private void agregarBoton(JPanel panel, String texto, Runnable accion) {
        JButton boton = new JButton(texto);
        boton.addActionListener(evento -> accion.run());
        panel.add(boton);
    }

    // Solicita los datos y registra el contacto en la agenda existente.
    private void agregarContacto() {
        String nombre = pedirTexto("Nombre:");
        if (nombre == null) return;
        String apellido = pedirTexto("Apellido:");
        if (apellido == null) return;
        String telefono = pedirTexto("Teléfono:");
        if (telefono == null) return;

        Contacto contacto = new Contacto(nombre, apellido, telefono);
        if (contacto.tieneDatosVacios()) {
            mostrarMensaje("El nombre y el apellido no pueden estar vacíos.");
        } else if (agenda.getContactos().contains(contacto)) {
            mostrarMensaje("Ya existe un contacto con ese nombre y apellido.");
        } else if (agenda.agendaLlena()) {
            mostrarMensaje("La agenda está llena.");
        } else if (agenda.anadirContacto(contacto)) {
            mostrarMensaje("Contacto agregado.");
            actualizarLista();
        }
    }

    // Busca sin distinguir mayúsculas y muestra los datos del contacto encontrado.
    private void buscarContacto() {
        Contacto contacto = pedirContacto();
        if (contacto == null) return;

        mostrarMensaje("Nombre: " + contacto.getNombre() + " " + contacto.getApellido()
                + "\nTeléfono: " + contacto.getTelefono());
    }

    // Actualiza el teléfono del contacto seleccionado.
    private void modificarTelefono() {
        Contacto contacto = pedirContacto();
        if (contacto == null) return;

        String telefono = pedirTexto("Nuevo teléfono:");
        if (telefono == null) return;

        agenda.modificarTelefono(contacto.getNombre(), contacto.getApellido(), telefono);
        mostrarMensaje("Teléfono modificado.");
        actualizarLista();
    }

    // Elimina el contacto que coincide con el nombre y apellido indicados.
    private void eliminarContacto() {
        String nombre = pedirTexto("Nombre del contacto:");
        if (nombre == null) return;
        String apellido = pedirTexto("Apellido del contacto:");
        if (apellido == null) return;

        if (agenda.eliminarContacto(new Contacto(nombre, apellido))) {
            mostrarMensaje("Contacto eliminado.");
            actualizarLista();
        } else {
            mostrarMensaje("No se encontró ese contacto.");
        }
    }

    // Muestra los contactos ordenados por nombre y actualiza la capacidad disponible.
    private void actualizarLista() {
        StringBuilder texto = new StringBuilder();
        agenda.getContactos().stream()
                .sorted(Comparator.comparing(Contacto::getNombre, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Contacto::getApellido, String.CASE_INSENSITIVE_ORDER))
                .forEach(contacto -> texto.append(contacto.getNombre()).append(' ')
                        .append(contacto.getApellido()).append(" - ")
                        .append(contacto.getTelefono()).append('\n'));

        listaContactos.setText(texto.length() == 0 ? "Todavía no hay contactos." : texto.toString());
        estadoAgenda.setText("Contactos: " + agenda.getContactos().size() + " / "
                + agenda.getCapacidadMaxima() + "    Espacios libres: " + agenda.espaciosLibres());
    }

    private Contacto pedirContacto() {
        String nombre = pedirTexto("Nombre:");
        if (nombre == null) return null;
        String apellido = pedirTexto("Apellido:");
        if (apellido == null) return null;

        Optional<Contacto> encontrado = agenda.getContactos().stream()
                .filter(contacto -> contacto.getNombre().equalsIgnoreCase(nombre.trim())
                        && contacto.getApellido().equalsIgnoreCase(apellido.trim()))
                .findFirst();
        if (!encontrado.isPresent()) {
            mostrarMensaje("No se encontró ese contacto.");
            return null;
        }
        return encontrado.get();
    }

    private String pedirTexto(String mensaje) {
        return JOptionPane.showInputDialog(ventana, mensaje, "Entrada", JOptionPane.PLAIN_MESSAGE);
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(ventana, mensaje);
    }
}
