package Cine;

public class Function {
    private Movie movie;
    private CinemaRoom room;
    private Seat[][] seats;
    private int availableSeats;
    
    public Function(CinemaRoom room) {
        this.room = room;
        this.movie = null;
    }
    
    public Movie getMovie() {
        return movie;
    }
    
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    public int getAvailableSeats() {
        return availableSeats;
    }
    
    // Inicializa la matriz de asientos según la configuración de la sala
    public void initializeSeats() {
        if (room.hasPreferentialSection()) {
            seats = new Seat[8][12];  // Filas a-h, columnas 1-12 (las últimas 3 columnas de g-h no se usan)
            availableSeats = 6 * 12 + 2 * 9;  // 6 filas generales + 2 filas preferenciales
        } else {
            seats = new Seat[6][12];  // Filas a-f, columnas 1-12
            availableSeats = 6 * 12;  // Solo sección general
        }
        
        // Inicializar todos los asientos como disponibles
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                // Para filas preferenciales (g, h), solo las primeras 9 columnas son válidas
                if (room.hasPreferentialSection() && i >= 6 && j >= 9) {
                    seats[i][j] = null;  // No hay asiento en esta posición
                } else {
                    boolean isPreferential = room.hasPreferentialSection() && i >= 6;
                    seats[i][j] = new Seat((char)('A' + i), j + 1, isPreferential);
                }
            }
        }
    }
    
    // Muestra el mapa de asientos en la consola
    public void displaySeatsMap() {
        if (seats == null) {
            System.out.println("No hay asientos disponibles para esta función.");
            return;
        }
        
        System.out.println("\nMapa de Asientos - Sala " + room.getRoomId() + " - " + movie.getName() + 
                           " (" + getAvailableSeats() + " disponibles)");
        System.out.println("==========PANTALLA==========");
        
        // Imprimir números de columna
        System.out.print("   ");
        for (int j = 0; j < 12; j++) {
            System.out.printf("%2d ", j + 1);
        }
        System.out.println();
        
        // Imprimir filas
        for (int i = 0; i < seats.length; i++) {
            System.out.printf("%c: ", (char)('A' + i));
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == null) {
                    System.out.print("   ");  // Espacio para asientos no válidos
                } else if (seats[i][j].isAvailable()) {
                    System.out.print(" O ");  // O para asientos disponibles
                } else {
                    System.out.print(" X ");  // X para asientos ocupados
                }
            }
            System.out.println();
        }
        
        if (room.hasPreferentialSection()) {
            System.out.println("\nFilas A-F: Sección General");
            System.out.println("Filas G-H: Sección Preferencial");
        } else {
            System.out.println("\nTodas las filas son de tarifa 3D");
        }
    }
    
    // Compra un asiento y devuelve el precio
    public int buySeat(char row, int seatNumber) {
        int rowIndex = row - 'A';
        int columnIndex = seatNumber - 1;
        
        // Verificar si el asiento existe
        if (rowIndex < 0 || rowIndex >= seats.length || 
            columnIndex < 0 || columnIndex >= seats[0].length || 
            seats[rowIndex][columnIndex] == null) {
            System.out.println("El asiento seleccionado no existe.");
            return 0;
        }
        
        Seat seat = seats[rowIndex][columnIndex];
        
        // Verificar si el asiento está disponible
        if (!seat.isAvailable()) {
            System.out.println("El asiento seleccionado ya está ocupado.");
            return 0;
        }
        
        // Marcar asiento como ocupado
        seat.setAvailable(false);
        availableSeats--;
        
        // Calcular precio según el tipo de asiento y sala
        int price;
        if (room.getRoomId() == 3) {
            price = 10000;  // Sala 3 (3D)
        } else if (seat.isPreferential()) {
            price = 12000;  // Sección preferencial
        } else {
            price = 8000;   // Sección general
        }
        
        return price;
    }
}
