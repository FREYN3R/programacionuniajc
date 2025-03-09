package Cine;

import java.util.Scanner;

public class CinemaStarApp {
    private static Cinema cinema;
    private static Scanner scanner;

    public static void main(String[] args) {
        // Inicializar el cine
        cinema = new Cinema();
        scanner = new Scanner(System.in);
        
        boolean exit = false;
        
        while (!exit) {
            showMainMenu();
            int option = readOption();
            
            switch (option) {
                case 1:
                    handleMoviesMenu();
                    break;
                case 2:
                    handleFunctionsMenu();
                    break;
                case 3:
                    handleSalesMenu();
                    break;
                case 4:
                    exit = true;
                    System.out.println("¡Gracias por usar el sistema de CinemaStar!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        
        scanner.close();
    }
    
    // Muestra el menú principal
    private static void showMainMenu() {
        System.out.println("\n===== CINEMA STAR SYSTEM =====");
        System.out.println("1. Gestión de Películas");
        System.out.println("2. Asignación de Funciones");
        System.out.println("3. Ventas de Entradas");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    // Lee una opción del usuario
    private static int readOption() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    // Maneja el menú de películas
    private static void handleMoviesMenu() {
        boolean back = false;
        
        while (!back) {
            System.out.println("\n===== GESTIÓN DE PELÍCULAS =====");
            System.out.println("1. Ver películas registradas");
            System.out.println("2. Agregar nueva película");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int option = readOption();
            
            switch (option) {
                case 1:
                    showMovies();
                    break;
                case 2:
                    addMovie();
                    break;
                case 3:
                    back = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
    
    // Muestra las películas registradas
    private static void showMovies() {
        Movie[] movies = cinema.getMovies();
        int count = cinema.getMovieCount();
        
        if (count == 0) {
            System.out.println("No hay películas registradas.");
            return;
        }
        
        System.out.println("\nPELÍCULAS REGISTRADAS:");
        System.out.println("---------------------");
        for (int i = 0; i < count; i++) {
            Movie movie = movies[i];
            System.out.println((i+1) + ". " + movie.getName() + 
                               " - Idioma: " + movie.getLanguage() + 
                               " - Tipo: " + movie.getType() + 
                               " - Duración: " + movie.getDuration() + " min");
        }
    }
    
    // Agrega una nueva película
    private static void addMovie() {
        System.out.println("\nAGREGAR NUEVA PELÍCULA");
        System.out.println("---------------------");
        
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        
        System.out.print("Idioma: ");
        String language = scanner.nextLine();
        
        String type = "";
        boolean validType = false;
        while (!validType) {
            System.out.print("Tipo (35mm/3D): ");
            type = scanner.nextLine();
            if (type.equalsIgnoreCase("35mm") || type.equalsIgnoreCase("3D")) {
                validType = true;
            } else {
                System.out.println("Tipo no válido. Debe ser 35mm o 3D.");
            }
        }
        
        int duration = 0;
        boolean validDuration = false;
        while (!validDuration) {
            System.out.print("Duración (minutos): ");
            try {
                duration = Integer.parseInt(scanner.nextLine());
                if (duration > 0) {
                    validDuration = true;
                } else {
                    System.out.println("La duración debe ser mayor a 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
        
        Movie movie = new Movie(name, language, type, duration);
        if (cinema.addMovie(movie)) {
            System.out.println("Película agregada correctamente.");
        } else {
            System.out.println("No se pudo agregar la película. El repertorio está lleno.");
        }
    }
    
    // Maneja el menú de funciones
    private static void handleFunctionsMenu() {
        boolean back = false;
        
        while (!back) {
            System.out.println("\n===== ASIGNACIÓN DE FUNCIONES =====");
            System.out.println("1. Ver funciones programadas");
            System.out.println("2. Asignar nueva función");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int option = readOption();
            
            switch (option) {
                case 1:
                    showFunctions();
                    break;
                case 2:
                    assignFunction();
                    break;
                case 3:
                    back = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
    
    // Muestra las funciones programadas
    private static void showFunctions() {
        System.out.println("\nFUNCIONES PROGRAMADAS:");
        System.out.println("---------------------");
        
        String[] timeSlots = {"14:00 - 16:30", "16:30 - 19:00", "19:00 - 21:00"};
        
        for (int roomId = 1; roomId <= 3; roomId++) {
            System.out.println("\nSALA " + roomId + ":");
            CinemaRoom room = cinema.getRoomById(roomId);
            
            for (int slot = 0; slot < 3; slot++) {
                System.out.print(timeSlots[slot] + ": ");
                
                Function function = room.getFunctions()[slot];
                if (function != null && function.getMovie() != null) {
                    System.out.println(function.getMovie().getName() + 
                                       " - Asientos disponibles: " + function.getAvailableSeats());
                } else {
                    System.out.println("No asignada");
                }
            }
        }
    }
    
    // Asigna una nueva función
    private static void assignFunction() {
        Movie[] movies = cinema.getMovies();
        int count = cinema.getMovieCount();
        
        if (count == 0) {
            System.out.println("No hay películas registradas. Agregue películas primero.");
            return;
        }
        
        System.out.println("\nASIGNAR NUEVA FUNCIÓN");
        System.out.println("---------------------");
        
        // Mostrar películas disponibles
        showMovies();
        
        // Seleccionar película
        int movieIndex = -1;
        boolean validMovie = false;
        while (!validMovie) {
            System.out.print("\nSeleccione el número de la película: ");
            try {
                movieIndex = Integer.parseInt(scanner.nextLine()) - 1;
                if (movieIndex >= 0 && movieIndex < count) {
                    validMovie = true;
                } else {
                    System.out.println("Número de película no válido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
        
        Movie selectedMovie = movies[movieIndex];
        
        // Seleccionar sala
        int roomId = -1;
        boolean validRoom = false;
        while (!validRoom) {
            System.out.print("Seleccione el número de sala (1-3): ");
            try {
                roomId = Integer.parseInt(scanner.nextLine());
                if (roomId >= 1 && roomId <= 3) {
                    // Verificar compatibilidad de la sala con el tipo de película
                    if (roomId == 3 && !selectedMovie.getType().equalsIgnoreCase("3D")) {
                        System.out.println("La sala 3 solo puede proyectar películas en 3D.");
                    } else if (roomId != 3 && selectedMovie.getType().equalsIgnoreCase("3D")) {
                        System.out.println("Las salas 1 y 2 no pueden proyectar películas en 3D.");
                    } else {
                        validRoom = true;
                    }
                } else {
                    System.out.println("Número de sala no válido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
        
        // Seleccionar franja horaria
        System.out.println("\nFranjas horarias:");
        System.out.println("1. 14:00 - 16:30");
        System.out.println("2. 16:30 - 19:00");
        System.out.println("3. 19:00 - 21:00");
        
        int timeSlot = -1;
        boolean validTimeSlot = false;
        while (!validTimeSlot) {
            System.out.print("Seleccione la franja horaria (1-3): ");
            try {
                timeSlot = Integer.parseInt(scanner.nextLine()) - 1;
                if (timeSlot >= 0 && timeSlot < 3) {
                    // Verificar si ya hay función asignada
                    if (cinema.getRoomById(roomId).getFunctions()[timeSlot] != null &&
                        cinema.getRoomById(roomId).getFunctions()[timeSlot].getMovie() != null) {
                        System.out.println("Ya hay una función asignada para esta sala y franja horaria.");
                    } else {
                        validTimeSlot = true;
                    }
                } else {
                    System.out.println("Franja horaria no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
        
        // Asignar función
        if (cinema.assignFunction(roomId, timeSlot, selectedMovie)) {
            System.out.println("Función asignada correctamente.");
        } else {
            System.out.println("No se pudo asignar la función.");
        }
    }
    
    // Maneja el menú de ventas
    private static void handleSalesMenu() {
        boolean back = false;
        
        while (!back) {
            System.out.println("\n===== VENTAS DE ENTRADAS =====");
            System.out.println("1. Comprar entradas");
            System.out.println("2. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int option = readOption();
            
            switch (option) {
                case 1:
                    sellTickets();
                    break;
                case 2:
                    back = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
    
    // Vende entradas
    private static void sellTickets() {
        System.out.println("\nCOMPRA DE ENTRADAS");
        System.out.println("------------------");
        
        // Seleccionar sala
        int roomId = -1;
        boolean validRoom = false;
        while (!validRoom) {
            System.out.print("Seleccione el número de sala (1-3): ");
            try {
                roomId = Integer.parseInt(scanner.nextLine());
                if (roomId >= 1 && roomId <= 3) {
                    validRoom = true;
                } else {
                    System.out.println("Número de sala no válido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
        
        CinemaRoom room = cinema.getRoomById(roomId);
        
        // Mostrar funciones disponibles
        String[] timeSlots = {"14:00 - 16:30", "16:30 - 19:00", "19:00 - 21:00"};
        
        System.out.println("\nFunciones disponibles para la Sala " + roomId + ":");
        for (int i = 0; i < 3; i++) {
            Function function = room.getFunctions()[i];
            if (function != null && function.getMovie() != null) {
                System.out.println((i+1) + ". " + timeSlots[i] + ": " + function.getMovie().getName() + 
                                   " - Asientos disponibles: " + function.getAvailableSeats());
            } else {
                System.out.println((i+1) + ". " + timeSlots[i] + ": No asignada");
            }
        }
        
        // Seleccionar función
        int functionIndex = -1;
        Function selectedFunction = null;
        boolean validFunction = false;
        
        while (!validFunction) {
            System.out.print("\nSeleccione el número de función: ");
            try {
                functionIndex = Integer.parseInt(scanner.nextLine()) - 1;
                if (functionIndex >= 0 && functionIndex < 3) {
                    selectedFunction = room.getFunctions()[functionIndex];
                    if (selectedFunction != null && selectedFunction.getMovie() != null) {
                        validFunction = true;
                    } else {
                        System.out.println("No hay función asignada para esta franja horaria.");
                    }
                } else {
                    System.out.println("Número de función no válido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
        
        // Mostrar esquema de asientos
        selectedFunction.displaySeatsMap();
        
        // Comprar entradas
        boolean continueBuying = true;
        int totalPrice = 0;
        
        while (continueBuying) {
            System.out.print("\nIngrese el asiento a comprar (ej: A3, B8): ");
            String seatCode = scanner.nextLine().toUpperCase();
            
            // Validar formato del asiento
            if (seatCode.length() < 2 || !Character.isLetter(seatCode.charAt(0)) || 
                !Character.isDigit(seatCode.charAt(1))) {
                System.out.println("Formato de asiento no válido. Debe ser una letra seguida de un número.");
                continue;
            }
            
            char row = seatCode.charAt(0);
            int seatNumber;
            
            try {
                if (seatCode.length() > 2) {
                    seatNumber = Integer.parseInt(seatCode.substring(1));
                } else {
                    seatNumber = Character.getNumericValue(seatCode.charAt(1));
                }
            } catch (NumberFormatException e) {
                System.out.println("Número de asiento no válido.");
                continue;
            }
            
            // Comprar asiento
            int price = selectedFunction.buySeat(row, seatNumber);
            if (price > 0) {
                totalPrice += price;
                System.out.println("Asiento " + seatCode + " comprado por $" + price);
                
                // Mostrar asientos actualizados
                selectedFunction.displaySeatsMap();
            }
            
            System.out.print("\n¿Desea comprar otro asiento? (S/N): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("S")) {
                continueBuying = false;
            }
        }
        
        System.out.println("\nTotal a pagar: $" + totalPrice);
        System.out.println("¡Compra realizada con éxito! Disfrute la función.");
    }
}