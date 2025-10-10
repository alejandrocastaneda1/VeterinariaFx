package org.example.veterinariajavafx.Model;
import java.util.ArrayList;

public class Veterinaria {
    private String nombre;
    private String nit;

    private ArrayList<Mascota> mascotas;
    private ArrayList<Responsable> responsables;
    private ArrayList<Consulta> consultas;

    // Constructor
    public Veterinaria(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.mascotas = new ArrayList<>();
        this.responsables = new ArrayList<>();
        this.consultas = new ArrayList<>();
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    //CRUD Mascota
    public void agregarMascota(Mascota m) {
        mascotas.add(m);
        System.out.println("Mascota agregada: " + m.getNombre());
    }

    public void listarMascotas() {
        for (Mascota m : mascotas) {
            System.out.println("Mascota: " + m.getNombre());
        }
    }

    public void eliminarMascota(String nombre) {
        mascotas.removeIf(m -> m.getNombre().equalsIgnoreCase(nombre));
        System.out.println("Mascota eliminada: " + nombre);
    }

    // CRUD Responsable
    public void agregarResponsable(Responsable r) {
        responsables.add(r);
        System.out.println("Responsable agregado: " + r.getNombre());
    }

    public void listarResponsables() {
        for (Responsable r : responsables) {
            System.out.println("Responsable: " + r.getNombre());
        }
    }

    public void eliminarResponsable(String nombre) {
        responsables.removeIf(r -> r.getNombre().equalsIgnoreCase(nombre));
        System.out.println("Responsable eliminado: " + nombre);
    }

    // CRUD Consulta
    public void CRUD(String accion, Consulta consulta) {
        switch (accion.toLowerCase()) {
            case "crear":
                if (consultas == null) {
                    consultas = new ArrayList<>();
                }
                consultas.add(consulta);
                System.out.println(" Consulta agregada: " + consulta.getNumId());
                break;
            case "eliminar":
                consultas.removeIf(c -> c.getNumId().equalsIgnoreCase(consulta.getNumId()));
                break;

            default:
                System.out.println("Acción no válida.");
        }
    }


    // Métodos Lógicos

    // Estimar dosis de medicamento (ejemplo sencillo)
    public String estimarDosis(String nombreMascota, double peso) {
        double dosis = peso * 2.5; // mg por kg
        System.out.println("Dosis estimada para " + nombreMascota + ": " + dosis + " mg");
        return nombreMascota;
    }

    // Sugerir próxima fecha de vacunación
    public String sugerirFechaVacunacion(String fecha) {
        System.out.println("Próxima vacunación recomendada aproximadamente 1 año después de: " + fecha);
        return fecha;
    }

    // Determinar prioridad de atención (ejemplo)
    public int prioridadAtencion(String animal) {
        if (animal.equalsIgnoreCase("perro") || animal.equalsIgnoreCase("gato")) {
            System.out.println("Prioridad: Alta (mascota doméstica común)");
        } else {
            System.out.println("Prioridad: Media");
        }
        return 0;
    }

    // Determinar responsable más frecuente
    public String responsableFrecuente() {
        if (responsables.isEmpty()) {
            System.out.println("No hay responsables registrados.");
            return null;
        }

        Responsable max = responsables.get(0);
        for (Responsable r : responsables) {
            if (r.getNivelFidelidad() > max.getNivelFidelidad()) {
                max = r;
            }
        }
        System.out.println("Responsable más frecuente: " + max.getNombre());
        return null;
    }

    // Calcular costo de consulta
    public float costoConsulta(Consulta consulta, String idConsulta, String categoriaEdad) {
        for (Consulta c : consultas) {
            if (c.getNumId().equalsIgnoreCase(idConsulta)) {
                float costoFinal = c.getValorBase();

                // Ejemplo de regla: si el paciente es joven, no hay recargo; si es adulto o senior, se aumenta 10%
                if (categoriaEdad.equalsIgnoreCase("adulto") || categoriaEdad.equalsIgnoreCase("senior")) {
                    costoFinal *= 1.10f; // recargo del 10%
                }
                c.setCostoFinal(costoFinal);
                System.out.println("Costo final de la consulta " + idConsulta + ": $" + costoFinal);
                return costoFinal; // 🔹 ahora retorna el valor
            }
        }

        System.out.println("Consulta no encontrada.");
        return 0f; // 🔹 retorna 0 si no encuentra la consulta
    }

}





