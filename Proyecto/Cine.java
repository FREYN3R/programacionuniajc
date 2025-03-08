package Proyecto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Cine {

    private static List<Pelicula> peliculas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Sala sala1 = new Sala("Sala 1", true, false);
        Sala sala2 = new Sala("Sala 2", true, false);
        Sala sala3 = new Sala("Sala 3", false, true);

        int opcion;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Creación de Películas");
            System.out.println("2. Asignación de Funciones");
            System.out.println("3. Ventas");
            System.out.println("4. Cierre de la Aplicación");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuPeliculas(scanner);
                    break;
                case 2:
                    menuAsignacionFunciones(scanner, sala1, sala2, sala3);
                    break;
                case 3:
                    System.out.println("Accediendo al menú de ventas...");
                    break;
                case 4:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void verPeliculas() {
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas registradas.");
        } else {
            System.out.println("\n--- Películas Registradas ---");
            for (int i = 0; i < peliculas.size(); i++) {
                System.out.println(i + ". " + peliculas.get(i));
            }
        }
    }

    private static void crearPelicula(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Ingrese el nombre de la película: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el idioma de la película: ");
        String idioma = scanner.nextLine();
        System.out.print("Ingrese el tipo de la película (35mm o 3D): ");
        String tipo = scanner.nextLine();
        System.out.print("Ingrese la duración de la película en minutos: ");
        int duracion = scanner.nextInt();

        Pelicula nuevaPelicula = new Pelicula(nombre, idioma, tipo, duracion);
        peliculas.add(nuevaPelicula);
        System.out.println("Película registrada exitosamente.");
    }

    private static void menuAsignacionFunciones(Scanner scanner, Sala... salas) {
        System.out.println("\n--- Asignación de Funciones ---");
        System.out.println("Horarios disponibles: 14:00 - 16:30, 16:30 - 19:00, 19:00 - 21:00");
        verPeliculas();

        if (peliculas.isEmpty()) return;

        System.out.print("Seleccione el índice de la película: ");
        int indice = scanner.nextInt();
        if (indice < 0 || indice >= peliculas.size()) {
            System.out.println("Índice inválido.");
            return;
        }
        Pelicula pelicula = peliculas.get(indice);

        System.out.print("Ingrese la sala (1, 2, 3): ");
        int numSala = scanner.nextInt();
        if (numSala < 1 || numSala > 3) {
            System.out.println("Sala inválida.");
            return;
        }

        System.out.print("Ingrese el horario: ");
        scanner.nextLine();
        String horario = scanner.nextLine();

        salas[numSala - 1].asignarFuncion(horario, pelicula);
        salas[numSala - 1].mostrarFunciones();
    }
}
