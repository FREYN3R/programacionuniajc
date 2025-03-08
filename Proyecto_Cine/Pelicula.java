package Proyecto_Cine;

/**
 * Clase que representa una película en el sistema de cines.
 */
public class Pelicula {
    private int id;
    private String nombre;
    private String idioma;
    private String tipo; // 35mm o 3D
    private int duracion; // en minutos

    /**
     * Constructor de la clase Pelicula.
     * 
     * @param id Identificador único de la película
     * @param nombre Nombre de la película
     * @param idioma Idioma en que se proyecta la película
     * @param tipo Tipo de película (35mm o 3D)
     * @param duracion Duración en minutos de la película
     */
    public Pelicula(int id, String nombre, String idioma, String tipo, int duracion) {
        this.id = id;
        this.nombre = nombre;
        this.idioma = idioma;
        this.tipo = tipo;
        this.duracion = duracion;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Película: " + nombre + " | Idioma: " + idioma + 
               " | Tipo: " + tipo + " | Duración: " + duracion + " min";
    }
}