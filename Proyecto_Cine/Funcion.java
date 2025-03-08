package Proyecto_Cine;

/**
 * Clase que representa una función de cine.
 */
public class Funcion {
    public static final String[] FRANJAS_HORARIAS = {
        "14:00 - 16:30",
        "16:30 - 19:00",
        "19:00 - 21:00"
    };
    
    private int id;
    private Sala sala;
    private int franjaHoraria; // 1, 2 o 3
    private Pelicula pelicula;
    private boolean[][] asientosOcupados;
    
    /**
     * Constructor de la clase Funcion.
     * 
     * @param id Identificador único de la función
     * @param sala Sala donde se proyectará
     * @param franjaHoraria Franja horaria (1, 2 o 3)
     * @param pelicula Película a proyectar
     */
    public Funcion(int id, Sala sala, int franjaHoraria, Pelicula pelicula) {
        this.id = id;
        this.sala = sala;
        this.franjaHoraria = franjaHoraria;
        this.pelicula = pelicula;
        
        // Inicializar matriz de asientos
        // Primera dimensión: filas (a-h)
        // Segunda dimensión: números de asiento (1-12 para general, 1-9 para preferencial)
        int totalFilas = Sala.FILAS_GENERALES;
        if (sala.tienePreferencial()) {
            totalFilas += Sala.FILAS_PREFERENCIALES;
        }
        
        asientosOcupados = new boolean[totalFilas][];
        
        // Inicializar filas generales
        for (int i = 0; i < Sala.FILAS_GENERALES; i++) {
            asientosOcupados[i] = new boolean[Sala.SILLAS_POR_FILA_GENERAL];
        }
        
        // Inicializar filas preferenciales si existen
        if (sala.tienePreferencial()) {
            for (int i = Sala.FILAS_GENERALES; i < totalFilas; i++) {
                asientosOcupados[i] = new boolean[Sala.SILLAS_POR_FILA_PREFERENCIAL];
            }
        }
    }
    
    /**
     * Obtiene el ID de la función.
     * 
     * @return ID de la función
     */
    public int getId() {
        return id;
    }
    
    /**
     * Obtiene la sala donde se proyecta la función.
     * 
     * @return Sala de la función
     */
    public Sala getSala() {
        return sala;
    }
    
    /**
     * Obtiene la franja horaria de la función.
     * 
     * @return Número de franja horaria (1, 2 o 3)
     */
    public int getFranjaHoraria() {
        return franjaHoraria;
    }
    
    /**
     * Obtiene la representación textual de la franja horaria.
     * 
     * @return String con la franja horaria
     */
    public String getFranjaHorariaTexto() {
        return FRANJAS_HORARIAS[franjaHoraria - 1];
    }
    
    /**
     * Obtiene la película que se proyecta en la función.
     * 
     * @return Película de la función
     */
    public Pelicula getPelicula() {
        return pelicula;
    }
    
    /**
     * Verifica si un asiento está ocupado.
     * 
     * @param fila Letra de la fila
     * @param numero Número del asiento
     * @return true si está ocupado, false si está disponible
     */
    public boolean estaOcupado(char fila, int numero) {
        int indiceFila = obtenerIndiceFila(fila);
        int indiceAsiento = numero - 1;
        
        if (indiceFila >= 0 && indiceFila < asientosOcupados.length &&
            indiceAsiento >= 0 && indiceAsiento < asientosOcupados[indiceFila].length) {
            return asientosOcupados[indiceFila][indiceAsiento];
        }
        
        return false; // Si el asiento no existe, consideramos que no está ocupado
    }
    
    /**
     * Ocupa un asiento.
     * 
     * @param fila Letra de la fila
     * @param numero Número del asiento
     * @return true si se pudo ocupar, false si ya estaba ocupado o no existe
     */
    public boolean ocuparAsiento(char fila, int numero) {
        if (!sala.existeSilla(fila, numero)) {
            return false;
        }
        
        int indiceFila = obtenerIndiceFila(fila);
        int indiceAsiento = numero - 1;
        
        if (asientosOcupados[indiceFila][indiceAsiento]) {
            return false; // Ya está ocupado
        }
        
        asientosOcupados[indiceFila][indiceAsiento] = true;
        return true;
    }
    
    /**
     * Calcula la cantidad de asientos disponibles.
     * 
     * @return Número de asientos disponibles
     */
    public int asientosDisponibles() {
        int disponibles = 0;
        
        for (int i = 0; i < asientosOcupados.length; i++) {
            for (int j = 0; j < asientosOcupados[i].length; j++) {
                if (!asientosOcupados[i][j]) {
                    disponibles++;
                }
            }
        }
        
        return disponibles;
    }
    
    /**
     * Convierte una letra de fila a su índice correspondiente en la matriz.
     * 
     * @param fila Letra de la fila (a-h)
     * @return Índice de la fila en la matriz
     */
    private int obtenerIndiceFila(char fila) {
        fila = Character.toLowerCase(fila);
        return fila - 'a';
    }
    
    @Override
    public String toString() {
        return "ID: " + id + " | Sala: " + sala.getNumero() + 
               " | Horario: " + getFranjaHorariaTexto() + 
               " | Película: " + pelicula.getNombre() + 
               " | Asientos disponibles: " + asientosDisponibles() + 
               "/" + sala.getCapacidadTotal();
    }
}
