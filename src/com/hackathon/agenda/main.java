import com.hackathon.agenda.menu.MenuConsola;
import com.hackathon.agenda.servicios.Agenda;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Agenda miAgenda = new Agenda();

        Contacto c1 = new Contacto("Daniela", "Chagal", 569840341);
        miAgenda.agregarContacto(c1);
        Contacto c2 = new Contacto("Fernanda", "Enriquez", 5550008);
        miAgenda.agregarContacto(c2);
        Contacto c3 = new Contacto("Fernando", "Nava", 5550005);
        miAgenda.agregarContacto(c3);
        Contacto c4 = new Contacto("daniela", "chagal", 558060952);
        boolean resultado = miAgenda.existeContacto(c4);

        System.out.println("El contacto existe en la agenda?: " + resultado);

        // Creamos una agenda de 10 espacios
        Agenda miAgenda = new Agenda(10);

        // Agregamos contactos de prueba
        miAgenda.anadirContacto(new Contacto("Jaz Gomez", "555-0001"));
        miAgenda.anadirContacto(new Contacto("Mafer Lopez", "555-0003"));

        System.out.println(); // Espacio en blanco

        // Probamos el método
        miAgenda.listarContactos();

        // 1. Instanciamos el menú
        MenuConsola menu = new MenuConsola();

        // 2. Llamamos al método que arranca toda la interacción
        menu.iniciarMenu();
    }
}
