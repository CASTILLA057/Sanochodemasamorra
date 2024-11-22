import java.util.ArrayList;
import java.util.List;

//Clase que representa una comida en el comedor
class Comida {
    private String nombre;
    private String tipo; //"vegetariana", "vegana", "estándar"
    private int disponibilidad;

    //Constructor
    public Comida(String nombre, String tipo, int disponibilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
    }
    //Métodos
    public void servir() {
        if (disponibilidad > 0) {
            disponibilidad--;
            System.out.println("Se ha servido una " + nombre + ". Disponibilidad: " + disponibilidad);
        } else {
            System.out.println("No hay más " + nombre + " disponible");
        }
    }
    public void reponer(int cantidad) {
        disponibilidad += cantidad;
        System.out.println("Se han repuesto " + cantidad + " unidades de " + nombre + ". Disponibilidad: " + disponibilidad);
    }
    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ") - Disponibilidad: " + disponibilidad;
    }
}
//Clase que representa a un estudiante
class Estudiante {
    private String nombre;
    private String id;

    //Constructor
    public Estudiante(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }
    //Método para seleccionar una comida
    public void seleccionarComida(Comida comida) {
        if (comida.getDisponibilidad() > 0) {
            comida.servir();
            System.out.println(nombre + " (ID: " + id + ") ha seleccionado " + comida.getNombre());
        } else {
            System.out.println("Lo siento, " + nombre + ", no hay " + comida.getNombre() + " disponible.");
        }
    }
    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

}

//Clase que gestiona el comedor
class GestionComedor {
    private List<Comida> comidas;

    //Constructor
    public GestionComedor() {
        comidas = new ArrayList<>();
    }

    //Método para registrar una comida en el sistema
    public void registrarComida(Comida comida) {
        comidas.add(comida);
        System.out.println("Comida registrada: " + comida);
    }

    //Método para mostrar la disponibilidad de todas las comidas
    public void mostrarDisponibilidad() {
        System.out.println("\nDisponibilidad de comidas:");
        for (Comida comida : comidas) {
            System.out.println(comida);
        }
    }

    //Método para registrar el consumo de comida por parte de los estudiantes
    public void registrarConsumo(Estudiante estudiante, Comida comida) {
        estudiante.seleccionarComida(comida);
    }
}
public class ComedorUniversitario {
    public static void main(String[] args) {
        // Crear instancias de comidas
        Comida comida1 = new Comida("Ensalada", "vegetariana", 10);
        Comida comida2 = new Comida("Hamburguesa", "estándar", 5);
        Comida comida3 = new Comida("Tofu", "vegana", 3);

        //Crear una instancia del sistema de gestión del comedor
        GestionComedor gestionComedor = new GestionComedor();
        gestionComedor.registrarComida(comida1);
        gestionComedor.registrarComida(comida2);
        gestionComedor.registrarComida(comida3);

        //Crear estudiantes
        Estudiante estudiante1 = new Estudiante("Santiago Castilla", "413");
        Estudiante estudiante2 = new Estudiante("Luis Felipe", "391");

        //Mostrar disponibilidad inicial
        gestionComedor.mostrarDisponibilidad();

        //Los estudiantes seleccionan comidas
        gestionComedor.registrarConsumo(estudiante1, comida1);
        gestionComedor.registrarConsumo(estudiante2, comida2);

        //Mostrar disponibilidad después de los consumos
        gestionComedor.mostrarDisponibilidad();

        //Reponer comidas
        comida2.reponer(3);
        comida3.reponer(2);

        //Mostrar disponibilidad después de repuestos
        gestionComedor.mostrarDisponibilidad();
    }
}

