package Proyecto_Cine;

/**
 * Clase principal que inicia el sistema de salas de cine.
 */
public class SistemaCine {
    /**
     * Método principal que inicia la aplicación.
     * 
     * @param args Argumentos de línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("  Sistema de Administración de CinemaStar  ");
        System.out.println("===========================================");
        
        // Crear e iniciar el menú principal
        Menu menu = new Menu();
        menu.mostrarMenuPrincipal();
    }
}
