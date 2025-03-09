package Cine;

import java.util.ArrayList;
import java.util.Date;

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
}