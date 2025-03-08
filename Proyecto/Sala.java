package Proyecto;

import java.util.HashMap;
import java.util.Map;

public class Sala {
    private String nombre;
    private char[][] asientosGenerales;
    private char[][] asientosPreferenciales;
    private boolean es3D;
    private Map<String, Pelicula> funciones;

    public Sala(String nombre, boolean tienePreferencial, boolean es3D) {
        this.nombre = nombre;
        this.es3D = es3D;
        this.funciones = new HashMap<>();

        asientosGenerales = new char[6][12];
        inicializarAsientos(asientosGenerales);

        if (tienePreferencial) {
            asientosPreferenciales = new char[2][9];
            inicializarAsientos(asientosPreferenciales);
        } else {
            asientosPreferenciales = null;
        }
    }

    private void inicializarAsientos(char[][] asientos) {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                asientos[i][j] = 'O';
            }
        }
    }

    public boolean asignarFuncion(String horario, Pelicula pelicula) {
        if (es3D && !pelicula.getTipo().equals("3D")) {
            System.out.println("La " + nombre + " solo puede proyectar películas en 3D.");
            return false;
        }
        if (!es3D && pelicula.getTipo().equals("3D")) {
            System.out.println("La " + nombre + " no puede proyectar películas en 3D.");
            return false;
        }
        if (funciones.containsKey(horario)) {
            System.out.println("Ya hay una película asignada a la " + nombre + " en el horario " + horario);
            return false;
        }
        funciones.put(horario, pelicula);
        System.out.println("Película " + pelicula.getNombre() + " asignada a la " + nombre + " en el horario " + horario);
        return true;
    }

    public void mostrarFunciones() {
        if (funciones.isEmpty()) {
            System.out.println("No hay funciones asignadas para " + nombre);
        } else {
            System.out.println("\n--- Funciones de " + nombre + " ---");
            for (Map.Entry<String, Pelicula> entry : funciones.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue().getNombre());
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public boolean es3D() {
        return es3D;
    }
}
