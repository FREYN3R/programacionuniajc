package Proyecto_Cine;

import java.util.Scanner;

/**
 * Clase Menu que maneja la interfaz de usuario para el sistema de administración
 * de salas de cine de CinemaStar.
 */
public class Menu {
    private Scanner scanner;
    private GestorPeliculas gestorPeliculas;
    private GestorFunciones gestorFunciones;
    private GestorVentas gestorVentas;
    private boolean ejecutando;

    /**
     * Constructor de la clase Menu.
     * Inicializa los gestores necesarios para el funcionamiento del sistema.
     */
    public Menu() {
        scanner = new Scanner(System.in);
        gestorPeliculas = new GestorPeliculas();
        gestorFunciones = new GestorFunciones();
        gestorVentas = new GestorVentas(gestorFunciones);
        ejecutando = true;
    }

    /**
     * Método principal que muestra y maneja el menú principal del sistema.
     */
    public void mostrarMenuPrincipal() {
        while (ejecutando) {
            System.out.println("\n===== SISTEMA DE SALAS DE CINE CINEMASTAR =====");
            System.out.println("1. Gestión de Películas");
            System.out.println("2. Asignación de Funciones");
            System.out.println("3. Ventas de Entradas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    mostrarMenuPeliculas();
                    break;
                case 2:
                    mostrarMenuFunciones();
                    break;
                case 3:
                    mostrarMenuVentas();
                    break;
                case 4:
                    ejecutando = false;
                    System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor intente nuevamente.");
            }
        }
    }

    /**
     * Método que muestra y maneja el menú de gestión de películas.
     */
    private void mostrarMenuPeliculas() {
        boolean menuPeliculas = true;
        
        while (menuPeliculas) {
            System.out.println("\n===== GESTIÓN DE PELÍCULAS =====");
            System.out.println("1. Ver películas registradas");
            System.out.println("2. Añadir nueva película");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    gestorPeliculas.mostrarPeliculas();
                    break;
                case 2:
                    agregarPelicula();
                    break;
                case 3:
                    menuPeliculas = false;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor intente nuevamente.");
            }
        }
    }

    /**
     * Método para obtener los datos de una nueva película y agregarla al sistema.
     */
    private void agregarPelicula() {
        System.out.println("\n===== AÑADIR NUEVA PELÍCULA =====");
        
        System.out.print("Ingrese el nombre de la película: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese el idioma de la película: ");
        String idioma = scanner.nextLine();
        
        System.out.print("Ingrese el tipo de película (35mm/3D): ");
        String tipo = scanner.nextLine();
        while (!tipo.equalsIgnoreCase("35mm") && !tipo.equalsIgnoreCase("3D")) {
            System.out.print("Tipo inválido. Ingrese 35mm o 3D: ");
            tipo = scanner.nextLine();
        }
        
        System.out.print("Ingrese la duración de la película (en minutos): ");
        int duracion = leerOpcion();
        
        gestorPeliculas.agregarPelicula(nombre, idioma, tipo, duracion);
        System.out.println("Película agregada con éxito.");
    }

    /**
     * Método que muestra y maneja el menú de asignación de funciones.
     */
    private void mostrarMenuFunciones() {
        boolean menuFunciones = true;
        
        while (menuFunciones) {
            System.out.println("\n===== ASIGNACIÓN DE FUNCIONES =====");
            System.out.println("1. Ver funciones programadas");
            System.out.println("2. Asignar película a una función");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    gestorFunciones.mostrarFunciones();
                    break;
                case 2:
                    asignarFuncion();
                    break;
                case 3:
                    menuFunciones = false;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor intente nuevamente.");
            }
        }
    }

    /**
     * Método para asignar una película a una función específica.
     */
    private void asignarFuncion() {
        System.out.println("\n===== ASIGNAR PELÍCULA A FUNCIÓN =====");
        
        // Mostrar películas disponibles
        gestorPeliculas.mostrarPeliculas();
        if (gestorPeliculas.cantidadPeliculas() == 0) {
            System.out.println("No hay películas registradas. Debe agregar películas primero.");
            return;
        }
        
        System.out.print("Seleccione el ID de la película: ");
        int idPelicula = leerOpcion();
        
        // Verificar si el ID es válido
        if (!gestorPeliculas.existePelicula(idPelicula)) {
            System.out.println("ID de película inválido.");
            return;
        }
        
        // Seleccionar sala
        System.out.println("\nSalas disponibles:");
        System.out.println("1. Sala 1 (No permite películas 3D)");
        System.out.println("2. Sala 2 (No permite películas 3D)");
        System.out.println("3. Sala 3 (Solo permite películas 3D)");
        System.out.print("Seleccione una sala: ");
        int sala = leerOpcion();
        
        if (sala < 1 || sala > 3) {
            System.out.println("Sala inválida.");
            return;
        }
        
        // Verificar compatibilidad de la película con la sala
        String tipoPelicula = gestorPeliculas.getTipoPelicula(idPelicula);
        if ((sala == 3 && !tipoPelicula.equalsIgnoreCase("3D")) || 
            (sala < 3 && tipoPelicula.equalsIgnoreCase("3D"))) {
            System.out.println("La película seleccionada no es compatible con esta sala.");
            return;
        }
        
        // Seleccionar franja horaria
        System.out.println("\nFranjas horarias disponibles:");
        System.out.println("1. 14:00 - 16:30");
        System.out.println("2. 16:30 - 19:00");
        System.out.println("3. 19:00 - 21:00");
        System.out.print("Seleccione una franja horaria: ");
        int franja = leerOpcion();
        
        if (franja < 1 || franja > 3) {
            System.out.println("Franja horaria inválida.");
            return;
        }
        
        // Intentar asignar la función
        if (gestorFunciones.asignarFuncion(sala, franja, idPelicula)) {
            System.out.println("Función asignada con éxito.");
        } else {
            System.out.println("Ya existe una función asignada para esta sala y franja horaria.");
        }
    }

    /**
     * Método que muestra y maneja el menú de ventas de entradas.
     */
    private void mostrarMenuVentas() {
        boolean menuVentas = true;
        
        while (menuVentas) {
            System.out.println("\n===== VENTAS DE ENTRADAS =====");
            System.out.println("1. Mostrar funciones disponibles");
            System.out.println("2. Comprar entradas");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    gestorFunciones.mostrarFunciones();
                    break;
                case 2:
                    comprarEntradas();
                    break;
                case 3:
                    menuVentas = false;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor intente nuevamente.");
            }
        }
    }

    /**
     * Método para gestionar la compra de entradas.
     */
    private void comprarEntradas() {
        System.out.println("\n===== COMPRAR ENTRADAS =====");
        
        // Mostrar funciones disponibles
        gestorFunciones.mostrarFunciones();
        if (gestorFunciones.cantidadFunciones() == 0) {
            System.out.println("No hay funciones programadas. Debe asignar funciones primero.");
            return;
        }
        
        System.out.print("Seleccione el ID de la función: ");
        int idFuncion = leerOpcion();
        
        // Verificar si la función existe
        if (!gestorFunciones.existeFuncion(idFuncion)) {
            System.out.println("Función no encontrada.");
            return;
        }
        
        // Mostrar la disponibilidad de asientos
        gestorVentas.mostrarDisponibilidadAsientos(idFuncion);
        
        // Solicitar sillas a comprar
        System.out.println("Ingrese las sillas que desea comprar (Ejemplo: A3,B8,D9)");
        System.out.println("Escriba 'finalizar' para terminar la selección");
        
        boolean comprando = true;
        while (comprando) {
            System.out.print("Silla: ");
            String entradaSilla = scanner.nextLine().trim();
            
            if (entradaSilla.equalsIgnoreCase("finalizar")) {
                comprando = false;
            } else {
                boolean resultado = gestorVentas.comprarSilla(idFuncion, entradaSilla);
                if (resultado) {
                    System.out.println("Silla " + entradaSilla + " comprada exitosamente.");
                } else {
                    System.out.println("No se pudo comprar la silla " + entradaSilla + ". Verifique que exista y esté disponible.");
                }
            }
        }
        
        // Mostrar total a pagar
        double totalCompra = gestorVentas.finalizarCompra();
        System.out.println("Total a pagar: $" + totalCompra);
    }

    /**
     * Método utilitario para leer opciones numéricas del usuario.
     * @return El número entero ingresado por el usuario.
     */
    private int leerOpcion() {
        try {
            String entrada = scanner.nextLine();
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            return -1; // Valor inválido que será manejado por el menú correspondiente
        }
    }

    /**
     * Método principal para iniciar el sistema.
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mostrarMenuPrincipal();
    }
}
