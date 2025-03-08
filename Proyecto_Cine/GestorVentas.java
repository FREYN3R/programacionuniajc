package Proyecto_Cine;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona las ventas de entradas.
 */
public class GestorVentas {
    private static final double PRECIO_GENERAL = 8000;
    private static final double PRECIO_PREFERENCIAL = 12000;
    private static final double PRECIO_3D = 10000;
    
    private GestorFunciones gestorFunciones;
    private List<String> sillasCompradas;
    private double totalCompraActual;
    
    /**
     * Constructor de la clase GestorVentas.
     * 
     * @param gestorFunciones Gestor de funciones para obtener información de salas y funciones
     */
    public GestorVentas(GestorFunciones gestorFunciones) {
        this.gestorFunciones = gestorFunciones;
        this.sillasCompradas = new ArrayList<>();
        this.totalCompraActual = 0;
    }
    
    /**
     * Muestra la disponibilidad de asientos para una función.
     * 
     * @param idFuncion ID de la función
     * @return true si la función existe, false en caso contrario
     */
    public boolean mostrarDisponibilidadAsientos(int idFuncion) {
        Funcion funcion = gestorFunciones.getFuncionPorId(idFuncion);
        if (funcion == null) {
            System.out.println("La función no existe.");
            return false;
        }
        
        Sala sala = funcion.getSala();
        int totalFilas = Sala.FILAS_GENERALES;
        if (sala.tienePreferencial()) {
            totalFilas += Sala.FILAS_PREFERENCIALES;
        }
        
        System.out.println("\n===== DISPONIBILIDAD DE ASIENTOS - SALA " + sala.getNumero() + " =====");
        System.out.println("Película: " + funcion.getPelicula().getNombre());
        System.out.println("Horario: " + funcion.getFranjaHorariaTexto());
        System.out.println("Asientos disponibles: " + funcion.asientosDisponibles());
        System.out.println("\nLeyenda: [O] Ocupado, [D] Disponible");
        System.out.println();
        
        // Mostrar encabezado con números de asiento
        System.out.print("   ");
        for (int i = 1; i <= Sala.SILLAS_POR_FILA_GENERAL; i++) {
            System.out.printf("%2d ", i);
        }
        System.out.println();
        
        // Mostrar filas generales
        for (char fila = 'A'; fila < 'A' + Sala.FILAS_GENERALES; fila++) {
            System.out.print(fila + " |");
            for (int asiento = 1; asiento <= Sala.SILLAS_POR_FILA_GENERAL; asiento++) {
                String estado = funcion.estaOcupado(fila, asiento) ? "[O]" : "[D]";
                System.out.print(estado);
            }
            System.out.println("| General");
        }
        
        // Mostrar filas preferenciales si existen
        if (sala.tienePreferencial()) {
            System.out.println();
            
            // Encabezado para preferencial (tiene menos asientos)
            System.out.print("   ");
            for (int i = 1; i <= Sala.SILLAS_POR_FILA_PREFERENCIAL; i++) {
                System.out.printf("%2d ", i);
            }
            System.out.println();
            
            for (char fila = 'G'; fila < 'G' + Sala.FILAS_PREFERENCIALES; fila++) {
                System.out.print(fila + " |");
                for (int asiento = 1; asiento <= Sala.SILLAS_POR_FILA_PREFERENCIAL; asiento++) {
                    String estado = funcion.estaOcupado(fila, asiento) ? "[O]" : "[D]";
                    System.out.print(estado);
                }
                System.out.println("| Preferencial");
            }
        }
        
        return true;
    }
    
    /**
     * Compra una silla para una función específica.
     * 
     * @param idFuncion ID de la función
     * @param codigoSilla Código de la silla (ej: A3, B8, G4)
     * @return true si se realizó la compra, false en caso contrario
     */
    public boolean comprarSilla(int idFuncion, String codigoSilla) {
        Funcion funcion = gestorFunciones.getFuncionPorId(idFuncion);
        if (funcion == null) {
            return false;
        }
        
        // Parsear el código de silla
        if (codigoSilla.length() < 2) {
            System.out.println("Código de silla inválido. Ejemplo válido: A3");
            return false;
        }
        
        char fila = codigoSilla.charAt(0);
        int numeroAsiento;
        
        try {
            numeroAsiento = Integer.parseInt(codigoSilla.substring(1));
        } catch (NumberFormatException e) {
            System.out.println("Número de asiento inválido. Ejemplo válido: A3");
            return false;
        }
        
        Sala sala = funcion.getSala();
        
        // Verificar si la silla existe
        if (!sala.existeSilla(fila, numeroAsiento)) {
            System.out.println("La silla " + codigoSilla + " no existe en esta sala.");
            return false;
        }
        
        // Verificar si la silla está disponible
        if (funcion.estaOcupado(fila, numeroAsiento)) {
            System.out.println("La silla " + codigoSilla + " ya está ocupada.");
            return false;
        }
        
        // Realizar la compra
        if (funcion.ocuparAsiento(fila, numeroAsiento)) {
            // Calcular el precio según el tipo de sala y silla
            double precio;
            
            if (sala.es3D()) {
                precio = PRECIO_3D;
            } else if (sala.esPreferencial(fila)) {
                precio = PRECIO_PREFERENCIAL;
            } else {
                precio = PRECIO_GENERAL;
            }
            
            totalCompraActual += precio;
            sillasCompradas.add(codigoSilla);
            
            return true;
        }
        
        return false;
    }
    
    /**
     * Finaliza la compra actual y devuelve el total a pagar.
     * 
     * @return Total de la compra
     */
    public double finalizarCompra() {
        if (sillasCompradas.isEmpty()) {
            return 0;
        }
        
        System.out.println("\n===== RESUMEN DE COMPRA =====");
        System.out.println("Sillas compradas: " + String.join(", ", sillasCompradas));
        System.out.printf("Total a pagar: $%.2f\n", totalCompraActual);
        
        double total = totalCompraActual;
        
        // Reiniciar para la próxima compra
        sillasCompradas.clear();
        totalCompraActual = 0;
        
        return total;
    }
}
