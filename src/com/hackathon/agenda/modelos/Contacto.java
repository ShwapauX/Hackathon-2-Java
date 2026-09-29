package com.hackathon.agenda.modelos;

//todo: Probar método
public class Contacto extends Persona {

    private String telefono;

    // ==== Constructor
    // crea un contacto con nombre, apellido y telefono
    public Contacto(String nombre, String apellido, String telefono) {
        // super llama a persona y le pasa el nombre y el apellido
        super(nombre, apellido);
        // si se guarda aca porque es dato propio de contacto
        this.telefono = telefono;
    }

    /**
     * Constructor: crea un contacto sin teléfono.
     * Es útil para buscar o eliminar, donde solo importan nombre y apellido.
     */
    public Contacto(String nombre, String apellido) {
        this(nombre, apellido, "");
    }

    public String getTelefono() { // Getter para LEER el teléfono, porque el atributo es privado.
        return telefono;
    }

    public void setTelefono(String telefono) { // Asigna o actualiza el número de teléfono de la persona
        this.telefono = telefono;
    }

    // Devuelve la representación en texto del objeto, agregando el teléfono al final
    @Override
    public String toString() {
        return super.toString() + " - " + telefono;
    }

}
