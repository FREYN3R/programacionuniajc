package Proyecto_Cine;

/**
 * Clase que representa una sala de cine.
 */
public class Sala {
    public static final int FILAS_GENERALES = 6; // a-f
    public static final int SILLAS_POR_FILA_GENERAL = 12;
    public static final int FILAS_PREFERENCIALES = 2; // g-h
    public static final int SILLAS_POR_FILA_PREFERENCIAL = 9;
    
    private int numero;
    private boolean es3D;
    private boolean tienePreferencial;
    
    /**
     * Constructor de la clase Sala.
     * 
     * @param numero Número de la sala
     * @param es3D Indica si la sala es 3D
     * @param tienePreferencial Indica si la sala tiene sección preferencial
     */
    public Sala(int numero, boolean es3D, boolean tienePreferencial) {
        this.numero = numero;
        this.es3D = es3D;
        this.tienePreferencial = tienePreferencial;
    }
    
    /**
     * Obtiene el número de la sala.
     * 
     * @return Número de sala
     */
    public int getNumero() {
        return numero;
    }
    
    /**
     * Verifica si la sala es 3D.
     * 
     * @return true si es 3D, false en caso contrario
     */
    public boolean es3D() {
        return es3D;
    }
    
    /**
     * Verifica si la sala tiene sección preferencial.
     * 
     * @return true si tiene sección preferencial, false en caso contrario
     */
    public boolean tienePreferencial() {
        return tienePreferencial;
    }
    
    /**
     * Calcula la capacidad total de la sala.
     * 
     * @return Número total de asientos
     */
    public int getCapacidadTotal() {
        int capacidad = FILAS_GENERALES * SILLAS_POR_FILA_GENERAL;
        if (tienePreferencial) {
            capacidad += FILAS_PREFERENCIALES * SILLAS_POR_FILA_PREFERENCIAL;
        }
        return capacidad;
    }
    
    /**
     * Verifica si una silla existe en la sala.
     * 
     * @param fila Letra de la fila (a-h)
     * @param numero Número de silla
     * @return true si la silla existe, false en caso contrario
     */
    public boolean existeSilla(char fila, int numero) {
        fila = Character.toLowerCase(fila);
        
        // Verificar filas generales (a-f)
        if (fila >= 'a' && fila < 'a' + FILAS_GENERALES) {
            return numero >= 1 && numero <= SILLAS_POR_FILA_GENERAL;
        }
        
        // Verificar filas preferenciales (g-h) si existen
        if (tienePreferencial && fila >= 'g' && fila < 'g' + FILAS_PREFERENCIALES) {
            return numero >= 1 && numero <= SILLAS_POR_FILA_PREFERENCIAL;
        }
        
        return false;
    }
    
    /**
     * Determina si una silla es preferencial.
     * 
     * @param fila Letra de la fila
     * @return true si es preferencial, false en caso contrario
     */
    public boolean esPreferencial(char fila) {
        fila = Character.toLowerCase(fila);
        return fila >= 'g' && fila <= 'h';
    }
    
    @Override
    public String toString() {
        String tipo = es3D ? "3D" : "2D";
        String seccion = tienePreferencial ? "Con sección preferencial" : "Sin sección preferencial";
        return "Sala " + numero + " (" + tipo + ") - " + seccion;
    }
}