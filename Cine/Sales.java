package Cine;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Sales {
    private ArrayList<Ticket> tickets;
    private int totalSales;
    private Date date;
    
    public Sales() {
        this.tickets = new ArrayList<>();
        this.totalSales = 0;
        this.date = new Date();
    }
    
    // Agregar un ticket a las ventas
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        totalSales += ticket.getPrice();
    }
    
    // Obtener todas las ventas del día
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
    
    // Obtener el total de ventas en pesos
    public int getTotalSales() {
        return totalSales;
    }
    
    // Obtener la cantidad de tickets vendidos
    public int getTicketCount() {
        return tickets.size();
    }
    
    // Obtener la fecha de las ventas
    public Date getDate() {
        return date;
    }
    
    // Generar reporte de ventas
    public void generateSalesReport() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("\n===== REPORTE DE VENTAS - " + dateFormat.format(date) + " =====");
        System.out.println("Total de entradas vendidas: " + getTicketCount());
        System.out.println("Total de ingresos: $" + getTotalSales());
        
        if (tickets.isEmpty()) {
            System.out.println("No hay ventas registradas para hoy.");
            return;
        }
        
        // Ventas por sala
        int[] salesByRoom = new int[3];
        int[] ticketsByRoom = new int[3];
        
        // Ventas por tipo de asiento
        int generalTickets = 0;
        int preferentialTickets = 0;
        int threeDTickets = 0;
        
        for (Ticket ticket : tickets) {
            int roomId = ticket.getRoom().getRoomId();
            salesByRoom[roomId - 1] += ticket.getPrice();
            ticketsByRoom[roomId - 1]++;
            
            if (roomId == 3) {
                threeDTickets++;
            } else if (ticket.isPreferential()) {
                preferentialTickets++;
            } else {
                generalTickets++;
            }
        }
        
        System.out.println("\nVENTAS POR SALA:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Sala " + (i + 1) + ": " + ticketsByRoom[i] + 
                               " entradas - $" + salesByRoom[i]);
        }
        
        System.out.println("\nVENTAS POR TIPO DE ENTRADA:");
        System.out.println("General: " + generalTickets + " entradas - $" + (generalTickets * 8000));
        System.out.println("Preferencial: " + preferentialTickets + " entradas - $" + (preferentialTickets * 12000));
        System.out.println("3D: " + threeDTickets + " entradas - $" + (threeDTickets * 10000));
    }
    
    // Obtener ventas por película
    public void getSalesByMovie() {
        if (tickets.isEmpty()) {
            System.out.println("No hay ventas registradas para hoy.");
            return;
        }
        
        // Crear un mapa para contar las ventas por película
        ArrayList<MovieSales> movieSales = new ArrayList<>();
        
        for (Ticket ticket : tickets) {
            String movieName = ticket.getMovie().getName();
            boolean found = false;
            
            // Buscar si ya existe la película en el resumen
            for (MovieSales ms : movieSales) {
                if (ms.getMovieName().equals(movieName)) {
                    ms.addSale(ticket.getPrice());
                    found = true;
                    break;
                }
            }
            
            // Si no existe, crear un nuevo resumen
            if (!found) {
                MovieSales ms = new MovieSales(movieName);
                ms.addSale(ticket.getPrice());
                movieSales.add(ms);
            }
        }
        
        // Mostrar ventas por película
        System.out.println("\nVENTAS POR PELÍCULA:");
        for (MovieSales ms : movieSales) {
            System.out.println(ms.getMovieName() + ": " + ms.getTicketCount() + 
                               " entradas - $" + ms.getTotalSales());
        }
    }
    
    // Clase auxiliar para manejar las ventas por película
    private class MovieSales {
        private String movieName;
        private int ticketCount;
        private int totalSales;
        
        public MovieSales(String movieName) {
            this.movieName = movieName;
            this.ticketCount = 0;
            this.totalSales = 0;
        }
        
        public void addSale(int price) {
            ticketCount++;
            totalSales += price;
        }
        
        public String getMovieName() {
            return movieName;
        }
        
        public int getTicketCount() {
            return ticketCount;
        }
        
        public int getTotalSales() {
            return totalSales;
        }
    }
}