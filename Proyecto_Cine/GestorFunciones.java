package Proyecto_Cine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase que gestiona las funciones del teatro.
 */
public class GestorFunciones {
    private List<Sala> salas;
    private List<Funcion> funciones;
    private Map<String, Funcion> funcionesPorSalaYFranja;
    private int contadorIdFuncion;
    private GestorPeliculas gestorPeliculas;
    
    /**
     * Constructor de la clase GestorFunciones.
     * Inicializa las estructuras de datos y crea las salas según lo especificado.
     */
    public GestorFunciones() {
        salas = new ArrayList<>();
        funciones = new ArrayList<>();
        funcionesPorSalaYFranja = new HashMap<>();
        contadorIdFuncion = 1;
        gestorPeliculas = new GestorPeliculas();
        
        // Inicializar las salas según los requisitos
        // Sala 1: No 3D, con sección preferencial
        salas.add(new Sala(1, false, true));
        // Sala 2: No 3D, con sección preferencial
        salas.add(new Sala(2, false, true));
        // Sala 3: Solo 3D, sin sección preferencial
        salas.add(new Sala(3, true, false));
    }
    
    /**
     * Asigna una película a una función específica.
     * 
     * @param numeroSala Número de sala (1, 2 o 3)
     * @param franjaHoraria Franja horaria (1, 2 o 3)
     * @param idPelicula ID de la película a asignar
     * @return true si se asignó correctamente, false si ya existe una función en esa sala y franja
     */
    public boolean asignarFuncion(int numeroSala, int franjaHoraria, int idPelicula) {
        // Verificar que la sala exista
        if (numeroSala < 1 || numeroSala > salas.size()) {
            return false;
        }
        
        // Verificar que la franja horaria sea válida
        if (franjaHoraria < 1 || franjaHoraria > Funcion.FRANJAS_HORARIAS.length) {
            return false;
        }
        
        // Obtener la sala
        Sala sala = salas.get(numeroSala - 1);
        
        // Verificar que no exista ya una función para esta sala y franja
        String clave = numeroSala + ":" + franjaHoraria;
        if (funcionesPorSalaYFranja.containsKey(clave)) {
            return false;
        }
        
        // Obtener la película
        Pelicula pelicula = gestorPeliculas.getPeliculaPorId(idPelicula);
        if (pelicula == null) {
            return false;
        }
        
        // Verificar compatibilidad de la película con la sala
        if (sala.es3D() && !pelicula.getTipo().equalsIgnoreCase("3D")) {
            return false;
        }
        if (!sala.es3D() && pelicula.getTipo().equalsIgnoreCase("3D")) {
            return false;
        }
        
        // Crear la función
        Funcion funcion = new Funcion(contadorIdFuncion++, sala, franjaHoraria, pelicula);
        funciones.add(funcion);
        funcionesPorSalaYFranja.put(clave, funcion);
        
        return true;
    }
    
    /**
     * Muestra las funciones programadas.
     */
    public void mostrarFunciones() {
        if (funciones.isEmpty()) {
            System.out.println("No hay funciones programadas.");
            return;
        }
        
        System.out.println("\n===== FUNCIONES PROGRAMADAS =====");
        for (Funcion funcion : funciones) {
            System.out.println(funcion);
        }
    }
    
    /**
     * Obtiene una función por su ID.
     * 
     * @param id ID de la función
     * @return La función encontrada o null si no existe
     */
    public Funcion getFuncionPorId(int id) {
        for (Funcion funcion : funciones) {
            if (funcion.getId() == id) {
                return funcion;
            }
        }
        return null;
    }
    
    /**
     * Verifica si existe una función con el ID dado.
     * 
     * @param id ID a verificar
     * @return true si existe, false en caso contrario
     */
    public boolean existeFuncion(int id) {
        return getFuncionPorId(id) != null;
    }
    
    /**
     * Obtiene la cantidad de funciones programadas.
     * 
     * @return Número de funciones
     */
    public int cantidadFunciones() {
        return funciones.size();
    }
    
    /**
     * Obtiene la lista de salas.
     * 
     * @return Lista de salas
     */
    public List<Sala> getSalas() {
        return salas;
    }
}
