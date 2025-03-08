package Proyecto;

public class Pelicula {
    private String nombre;
    private String idioma;
    private String tipo;
    private int duracion;

    public Pelicula(String nombre, String idioma, String tipo, int duracion) {
        this.nombre = nombre;
        this.idioma = idioma;
        this.tipo = tipo;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "nombre='" + nombre + '\'' +
                ", idioma='" + idioma + '\'' +
                ", tipo='" + tipo + '\'' +
                ", duracion=" + duracion + " minutos" +
                '}';
    }
}