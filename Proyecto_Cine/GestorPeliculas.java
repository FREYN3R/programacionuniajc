package Proyecto_Cine;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona las películas del sistema.
 */
public class GestorPeliculas {
    private List<Pelicula> peliculas;
    private int contadorId;

    /**
     * Constructor de la clase GestorPeliculas.
     * Inicializa la lista de películas.
     */
    public GestorPeliculas() {
        peliculas = new ArrayList<>();
        contadorId = 1;
    }

    /**
     * Añade una nueva película al sistema.
     * 
     * @param nombre Nombre de la película
     * @param idioma Idioma de la película
     * @param tipo Tipo de película (35mm o 3D)
     * @param duracion Duración en minutos
     * @return La película creada
     */
    public Pelicula agregarPelicula(String nombre, String idioma, String tipo, int duracion) {
        Pelicula pelicula = new Pelicula(contadorId++, nombre, idioma, tipo, duracion);
        peliculas.add(pelicula);
        return pelicula;
    }

    /**
     * Muestra las películas registradas en el sistema.
     */
    public void mostrarPeliculas() {
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas registradas en el sistema.");
            return;
        }
        
        System.out.println("\n===== PELÍCULAS REGISTRADAS =====");
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
    }

    /**
     * Obtiene una película por su ID.
     * 
     * @param id ID de la película a buscar
     * @return La película encontrada o null si no existe
     */
    public Pelicula getPeliculaPorId(int id) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getId() == id) {
                return pelicula;
            }
        }
        return null;
    }

    /**
     * Verifica si existe una película con el ID dado.
     * 
     * @param id ID a verificar
     * @return true si existe, false en caso contrario
     */
    public boolean existePelicula(int id) {
        return getPeliculaPorId(id) != null;
    }

    /**
     * Obtiene el tipo de una película por su ID.
     * 
     * @param id ID de la película
     * @return Tipo de película o null si no existe
     */
    public String getTipoPelicula(int id) {
        Pelicula pelicula = getPeliculaPorId(id);
        return pelicula != null ? pelicula.getTipo() : null;
    }

    /**
     * Obtiene la cantidad de películas registradas.
     * 
     * @return Número de películas
     */
    public int cantidadPeliculas() {
        return peliculas.size();
    }
}