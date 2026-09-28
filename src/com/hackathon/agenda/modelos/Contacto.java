package com.hackathon.agenda.modelos;

//todo: Probar método
public class Contacto {

    //* Atributos
    private String name;
    private String lastname;
    private Integer phone;

    //* Getter y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    //* Constructor
    public Contacto(String name, String lastname, Integer phone) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;


    }
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
